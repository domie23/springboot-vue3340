package com.entity.model;

import com.entity.KaoqinguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 院系考勤管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoqinguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 院系考勤管理姓名
     */
    private String kaoqinguanliName;


    /**
     * 头像
     */
    private String kaoqinguanliPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 联系方式
     */
    private String kaoqinguanliPhone;


    /**
     * 邮箱
     */
    private String kaoqinguanliEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：院系考勤管理姓名
	 */
    public String getKaoqinguanliName() {
        return kaoqinguanliName;
    }


    /**
	 * 设置：院系考勤管理姓名
	 */
    public void setKaoqinguanliName(String kaoqinguanliName) {
        this.kaoqinguanliName = kaoqinguanliName;
    }
    /**
	 * 获取：头像
	 */
    public String getKaoqinguanliPhoto() {
        return kaoqinguanliPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setKaoqinguanliPhoto(String kaoqinguanliPhoto) {
        this.kaoqinguanliPhoto = kaoqinguanliPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：联系方式
	 */
    public String getKaoqinguanliPhone() {
        return kaoqinguanliPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setKaoqinguanliPhone(String kaoqinguanliPhone) {
        this.kaoqinguanliPhone = kaoqinguanliPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getKaoqinguanliEmail() {
        return kaoqinguanliEmail;
    }


    /**
	 * 设置：邮箱
	 */
    public void setKaoqinguanliEmail(String kaoqinguanliEmail) {
        this.kaoqinguanliEmail = kaoqinguanliEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
