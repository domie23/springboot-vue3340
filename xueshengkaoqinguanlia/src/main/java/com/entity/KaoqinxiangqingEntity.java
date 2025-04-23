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
 * 考勤详情
 *
 * @author 
 * @email
 */
@TableName("kaoqinxiangqing")
public class KaoqinxiangqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KaoqinxiangqingEntity() {

	}

	public KaoqinxiangqingEntity(T t) {
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
    @TableField(value = "kaoqin_id")

    private Integer kaoqinId;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 考勤状态
     */
    @TableField(value = "kaoqinxiangqing_status_types")

    private Integer kaoqinxiangqingStatusTypes;


    /**
     * 考勤时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
    public Integer getKaoqinId() {
        return kaoqinId;
    }
    /**
	 * 获取：考勤编号
	 */

    public void setKaoqinId(Integer kaoqinId) {
        this.kaoqinId = kaoqinId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：考勤状态
	 */
    public Integer getKaoqinxiangqingStatusTypes() {
        return kaoqinxiangqingStatusTypes;
    }
    /**
	 * 获取：考勤状态
	 */

    public void setKaoqinxiangqingStatusTypes(Integer kaoqinxiangqingStatusTypes) {
        this.kaoqinxiangqingStatusTypes = kaoqinxiangqingStatusTypes;
    }
    /**
	 * 设置：考勤时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 获取：考勤时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "Kaoqinxiangqing{" +
            "id=" + id +
            ", kaoqinId=" + kaoqinId +
            ", yonghuId=" + yonghuId +
            ", kaoqinxiangqingStatusTypes=" + kaoqinxiangqingStatusTypes +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
