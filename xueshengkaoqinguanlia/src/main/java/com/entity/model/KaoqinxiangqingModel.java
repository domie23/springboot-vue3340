package com.entity.model;

import com.entity.KaoqinxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考勤详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KaoqinxiangqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 考勤编号
     */
    private Integer kaoqinId;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 考勤状态
     */
    private Integer kaoqinxiangqingStatusTypes;


    /**
     * 考勤时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
    public Integer getKaoqinId() {
        return kaoqinId;
    }


    /**
	 * 设置：考勤编号
	 */
    public void setKaoqinId(Integer kaoqinId) {
        this.kaoqinId = kaoqinId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：考勤状态
	 */
    public Integer getKaoqinxiangqingStatusTypes() {
        return kaoqinxiangqingStatusTypes;
    }


    /**
	 * 设置：考勤状态
	 */
    public void setKaoqinxiangqingStatusTypes(Integer kaoqinxiangqingStatusTypes) {
        this.kaoqinxiangqingStatusTypes = kaoqinxiangqingStatusTypes;
    }
    /**
	 * 获取：考勤时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：考勤时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
