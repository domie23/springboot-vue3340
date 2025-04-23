package com.entity.vo;

import com.entity.KaoqinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考勤通知
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kaoqin")
public class KaoqinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 考勤编号
     */

    @TableField(value = "kaoqin_uuid_number")
    private String kaoqinUuidNumber;


    /**
     * 考勤标题
     */

    @TableField(value = "kaoqin_name")
    private String kaoqinName;


    /**
     * 考勤专业
     */

    @TableField(value = "zhuanye_types")
    private Integer zhuanyeTypes;


    /**
     * 考勤结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "kaoqin_time")
    private Date kaoqinTime;


    /**
     * 考勤时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：考勤编号
	 */
    public String getKaoqinUuidNumber() {
        return kaoqinUuidNumber;
    }


    /**
	 * 获取：考勤编号
	 */

    public void setKaoqinUuidNumber(String kaoqinUuidNumber) {
        this.kaoqinUuidNumber = kaoqinUuidNumber;
    }
    /**
	 * 设置：考勤标题
	 */
    public String getKaoqinName() {
        return kaoqinName;
    }


    /**
	 * 获取：考勤标题
	 */

    public void setKaoqinName(String kaoqinName) {
        this.kaoqinName = kaoqinName;
    }
    /**
	 * 设置：考勤专业
	 */
    public Integer getZhuanyeTypes() {
        return zhuanyeTypes;
    }


    /**
	 * 获取：考勤专业
	 */

    public void setZhuanyeTypes(Integer zhuanyeTypes) {
        this.zhuanyeTypes = zhuanyeTypes;
    }
    /**
	 * 设置：考勤结束时间
	 */
    public Date getKaoqinTime() {
        return kaoqinTime;
    }


    /**
	 * 获取：考勤结束时间
	 */

    public void setKaoqinTime(Date kaoqinTime) {
        this.kaoqinTime = kaoqinTime;
    }
    /**
	 * 设置：考勤时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：考勤时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
