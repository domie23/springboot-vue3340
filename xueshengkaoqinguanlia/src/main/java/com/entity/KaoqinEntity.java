package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 考勤通知
 *
 * @author 
 * @email
 */
@TableName("kaoqin")
public class KaoqinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoqinEntity() {

	}

	public KaoqinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Kaoqin{" +
            "id=" + id +
            ", kaoqinUuidNumber=" + kaoqinUuidNumber +
            ", kaoqinName=" + kaoqinName +
            ", zhuanyeTypes=" + zhuanyeTypes +
            ", kaoqinTime=" + kaoqinTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
