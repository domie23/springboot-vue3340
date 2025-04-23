
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
 * 考勤通知
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kaoqin")
public class KaoqinController {
    private static final Logger logger = LoggerFactory.getLogger(KaoqinController.class);

    @Autowired
    private KaoqinService kaoqinService;


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
    @Autowired
    private KaoqinguanliService kaoqinguanliService;


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
            params.put("zhuanyeTypes",yonghuService.selectById((Integer)request.getSession().getAttribute("userId")).getZhuanyeTypes());
        else if("辅导员".equals(role))
            params.put("fudaoyuanId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        else if("院系考勤管理".equals(role))
            params.put("kaoqinguanliId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = kaoqinService.queryPage(params);

        //字典表数据转换
        List<KaoqinView> list =(List<KaoqinView>)page.getList();
        for(KaoqinView c:list){
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
        KaoqinEntity kaoqin = kaoqinService.selectById(id);
        if(kaoqin !=null){
            //entity转view
            KaoqinView view = new KaoqinView();
            BeanUtils.copyProperties( kaoqin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    @Autowired
    private KaoqinxiangqingService kaoqinxiangqingService;


    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KaoqinEntity kaoqin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoqin:{}",this.getClass().getName(),kaoqin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<KaoqinEntity> queryWrapper = new EntityWrapper<KaoqinEntity>()
            .eq("kaoqin_uuid_number", kaoqin.getKaoqinUuidNumber())
            .eq("kaoqin_name", kaoqin.getKaoqinName())
            .eq("zhuanye_types", kaoqin.getZhuanyeTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinEntity kaoqinEntity = kaoqinService.selectOne(queryWrapper);
        if(kaoqinEntity==null){
            kaoqin.setInsertTime(new Date());
            kaoqin.setCreateTime(new Date());
            kaoqinService.insert(kaoqin);
            Wrapper<YonghuEntity> yonghuEntityEntityWrapper = new EntityWrapper<YonghuEntity>()
                    .eq("zhuanye_types",kaoqin.getZhuanyeTypes());
            List<YonghuEntity> yonghuEntities = yonghuService.selectList(yonghuEntityEntityWrapper);
            ArrayList<KaoqinxiangqingEntity> kq = new ArrayList<>();
            if(yonghuEntities.size()>0){
                for (YonghuEntity yh:yonghuEntities) {
                    KaoqinxiangqingEntity kaoqinxiangqingEntity = new KaoqinxiangqingEntity();
                    kaoqinxiangqingEntity.setKaoqinId(kaoqin.getId());
                    kaoqinxiangqingEntity.setYonghuId(yh.getId());
                    kaoqinxiangqingEntity.setKaoqinxiangqingStatusTypes(1);
                    kaoqinxiangqingEntity.setCreateTime(new Date());
                    kq.add(kaoqinxiangqingEntity);
                }
                if(kq.size()>0){
                    kaoqinxiangqingService.insertBatch(kq);
                }
            }
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaoqinEntity kaoqin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaoqin:{}",this.getClass().getName(),kaoqin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<KaoqinEntity> queryWrapper = new EntityWrapper<KaoqinEntity>()
            .notIn("id",kaoqin.getId())
            .andNew()
            .eq("kaoqin_uuid_number", kaoqin.getKaoqinUuidNumber())
            .eq("kaoqin_name", kaoqin.getKaoqinName())
            .eq("zhuanye_types", kaoqin.getZhuanyeTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoqinEntity kaoqinEntity = kaoqinService.selectOne(queryWrapper);
        if(kaoqinEntity==null){
            kaoqinService.updateById(kaoqin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoqinService.deleteBatchIds(Arrays.asList(ids));
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
            List<KaoqinEntity> kaoqinList = new ArrayList<>();//上传的东西
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
                            KaoqinEntity kaoqinEntity = new KaoqinEntity();
//                            kaoqinEntity.setKaoqinUuidNumber(data.get(0));                    //考勤编号 要改的
//                            kaoqinEntity.setKaoqinName(data.get(0));                    //考勤标题 要改的
//                            kaoqinEntity.setZhuanyeTypes(Integer.valueOf(data.get(0)));   //考勤专业 要改的
//                            kaoqinEntity.setKaoqinTime(sdf.parse(data.get(0)));          //考勤结束时间 要改的
//                            kaoqinEntity.setInsertTime(date);//时间
//                            kaoqinEntity.setCreateTime(date);//时间
                            kaoqinList.add(kaoqinEntity);


                            //把要查询是否重复的字段放入map中
                                //考勤编号
                                if(seachFields.containsKey("kaoqinUuidNumber")){
                                    List<String> kaoqinUuidNumber = seachFields.get("kaoqinUuidNumber");
                                    kaoqinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> kaoqinUuidNumber = new ArrayList<>();
                                    kaoqinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("kaoqinUuidNumber",kaoqinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //考勤编号
                        List<KaoqinEntity> kaoqinEntities_kaoqinUuidNumber = kaoqinService.selectList(new EntityWrapper<KaoqinEntity>().in("kaoqin_uuid_number", seachFields.get("kaoqinUuidNumber")));
                        if(kaoqinEntities_kaoqinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(KaoqinEntity s:kaoqinEntities_kaoqinUuidNumber){
                                repeatFields.add(s.getKaoqinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [考勤编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        kaoqinService.insertBatch(kaoqinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
