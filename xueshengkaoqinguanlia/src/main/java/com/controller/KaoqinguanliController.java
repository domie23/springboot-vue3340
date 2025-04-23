
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 院系考勤管理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaoqinguanli")
public class KaoqinguanliController {
    private static final Logger logger = LoggerFactory.getLogger(KaoqinguanliController.class);

    @Autowired
    private KaoqinguanliService kaoqinguanliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private FudaoyuanService fudaoyuanService;
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("辅导员".equals(role))
            params.put("fudaoyuanId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("院系考勤管理".equals(role))
            params.put("kaoqinguanliId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = kaoqinguanliService.queryPage(params);

        //字典表数据转换
        List<KaoqinguanliView> list =(List<KaoqinguanliView>)page.getList();
        for(KaoqinguanliView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoqinguanliEntity kaoqinguanli = kaoqinguanliService.selectById(id);
        if(kaoqinguanli !=null){
            //entity转view
            KaoqinguanliView view = new KaoqinguanliView();
            BeanUtils.copyProperties( kaoqinguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KaoqinguanliEntity kaoqinguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoqinguanli:{}",this.getClass().getName(),kaoqinguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KaoqinguanliEntity> queryWrapper = new EntityWrapper<KaoqinguanliEntity>()
            .eq("username", kaoqinguanli.getUsername())
            .or()
            .eq("kaoqinguanli_phone", kaoqinguanli.getKaoqinguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinguanliEntity kaoqinguanliEntity = kaoqinguanliService.selectOne(queryWrapper);
        if(kaoqinguanliEntity==null){
            kaoqinguanli.setCreateTime(new Date());
            kaoqinguanli.setPassword("123456");
            kaoqinguanliService.insert(kaoqinguanli);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoqinguanliEntity kaoqinguanli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaoqinguanli:{}",this.getClass().getName(),kaoqinguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<KaoqinguanliEntity> queryWrapper = new EntityWrapper<KaoqinguanliEntity>()
            .notIn("id",kaoqinguanli.getId())
            .andNew()
            .eq("username", kaoqinguanli.getUsername())
            .or()
            .eq("kaoqinguanli_phone", kaoqinguanli.getKaoqinguanliPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinguanliEntity kaoqinguanliEntity = kaoqinguanliService.selectOne(queryWrapper);
        if("".equals(kaoqinguanli.getKaoqinguanliPhoto()) || "null".equals(kaoqinguanli.getKaoqinguanliPhoto())){
                kaoqinguanli.setKaoqinguanliPhoto(null);
        }
        if(kaoqinguanliEntity==null){
            kaoqinguanliService.updateById(kaoqinguanli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoqinguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<KaoqinguanliEntity> kaoqinguanliList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            KaoqinguanliEntity kaoqinguanliEntity = new KaoqinguanliEntity();
//                            kaoqinguanliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //kaoqinguanliEntity.setPassword("123456");//密码
//                            kaoqinguanliEntity.setKaoqinguanliName(data.get(0));                    //院系考勤管理姓名 要改的
//                            kaoqinguanliEntity.setKaoqinguanliPhoto("");//详情和图片
//                            kaoqinguanliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            kaoqinguanliEntity.setKaoqinguanliPhone(data.get(0));                    //联系方式 要改的
//                            kaoqinguanliEntity.setKaoqinguanliEmail(data.get(0));                    //邮箱 要改的
//                            kaoqinguanliEntity.setCreateTime(date);//时间
                            kaoqinguanliList.add(kaoqinguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("kaoqinguanliPhone")){
                                    List<String> kaoqinguanliPhone = seachFields.get("kaoqinguanliPhone");
                                    kaoqinguanliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> kaoqinguanliPhone = new ArrayList<>();
                                    kaoqinguanliPhone.add(data.get(0));//要改的
                                    seachFields.put("kaoqinguanliPhone",kaoqinguanliPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<KaoqinguanliEntity> kaoqinguanliEntities_username = kaoqinguanliService.selectList(new EntityWrapper<KaoqinguanliEntity>().in("username", seachFields.get("username")));
                        if(kaoqinguanliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KaoqinguanliEntity s:kaoqinguanliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<KaoqinguanliEntity> kaoqinguanliEntities_kaoqinguanliPhone = kaoqinguanliService.selectList(new EntityWrapper<KaoqinguanliEntity>().in("kaoqinguanli_phone", seachFields.get("kaoqinguanliPhone")));
                        if(kaoqinguanliEntities_kaoqinguanliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KaoqinguanliEntity s:kaoqinguanliEntities_kaoqinguanliPhone){
                                repeatFields.add(s.getKaoqinguanliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kaoqinguanliService.insertBatch(kaoqinguanliList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        KaoqinguanliEntity kaoqinguanli = kaoqinguanliService.selectOne(new EntityWrapper<KaoqinguanliEntity>().eq("username", username));
        if(kaoqinguanli==null || !kaoqinguanli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(kaoqinguanli.getId(),username, "kaoqinguanli", "院系考勤管理");
        R r = R.ok();
        r.put("token", token);
        r.put("role","院系考勤管理");
        r.put("username",kaoqinguanli.getKaoqinguanliName());
        r.put("tableName","kaoqinguanli");
        r.put("userId",kaoqinguanli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody KaoqinguanliEntity kaoqinguanli){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<KaoqinguanliEntity> queryWrapper = new EntityWrapper<KaoqinguanliEntity>()
            .eq("username", kaoqinguanli.getUsername())
            .or()
            .eq("kaoqinguanli_phone", kaoqinguanli.getKaoqinguanliPhone())
            ;
        KaoqinguanliEntity kaoqinguanliEntity = kaoqinguanliService.selectOne(queryWrapper);
        if(kaoqinguanliEntity != null)
            return R.error("账户或者联系方式已经被使用");
        kaoqinguanli.setCreateTime(new Date());
        kaoqinguanliService.insert(kaoqinguanli);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        KaoqinguanliEntity kaoqinguanli = new KaoqinguanliEntity();
        kaoqinguanli.setPassword("123456");
        kaoqinguanli.setId(id);
        kaoqinguanliService.updateById(kaoqinguanli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        KaoqinguanliEntity kaoqinguanli = kaoqinguanliService.selectOne(new EntityWrapper<KaoqinguanliEntity>().eq("username", username));
        if(kaoqinguanli!=null){
            kaoqinguanli.setPassword("123456");
            boolean b = kaoqinguanliService.updateById(kaoqinguanli);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrKaoqinguanli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        KaoqinguanliEntity kaoqinguanli = kaoqinguanliService.selectById(id);
        if(kaoqinguanli !=null){
            //entity转view
            KaoqinguanliView view = new KaoqinguanliView();
            BeanUtils.copyProperties( kaoqinguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
