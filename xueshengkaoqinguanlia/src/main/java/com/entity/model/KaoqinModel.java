package com.entity.model;

import com.entity.KaoqinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考勤通知
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoqinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考勤编号
     */
    private String kaoqinUuidNumber;


    /**
     * 考勤标题
     */
    private String kaoqinName;


    /**
     * 考勤专业
     */
    private Integer zhuanyeTypes;


    /**
     * 考勤结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaoqinTime;


    /**
     * 考勤时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：考勤编号
	 */
    public String getKaoqinUuidNumber() {
        return kaoqinUuidNumber;
    }


    /**
	 * 设置：考勤编号
	 */
    public void setKaoqinUuidNumber(String kaoqinUuidNumber) {
        this.kaoqinUuidNumber = kaoqinUuidNumber;
    }
    /**
	 * 获取：考勤标题
	 */
    public String getKaoqinName() {
        return kaoqinName;
    }


    /**
	 * 设置：考勤标题
	 */
    public void setKaoqinName(String kaoqinName) {
        this.kaoqinName = kaoqinName;
    }
    /**
	 * 获取：考勤专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 设置：考勤专业
	 */
    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 获取：考勤结束时间
	 */
    public Date getKaoqinTime() {
        return kaoqinTime;
    }


    /**
	 * 设置：考勤结束时间
	 */
    public void setKaoqinTime(Date kaoqinTime) {
        this.kaoqinTime = kaoqinTime;
    }
    /**
	 * 获取：考勤时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：考勤时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
