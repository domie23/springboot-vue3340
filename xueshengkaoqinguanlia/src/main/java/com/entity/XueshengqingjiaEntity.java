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
 * 学生请假
 *
 * @author 
 * @email
 */
@TableName("xueshengqingjia")
public class XueshengqingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueshengqingjiaEntity() {

	}

	public XueshengqingjiaEntity(T t) {
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
     * 请假原因
     */
    @TableField(value = "xueshengqingjia_name")

    private String xueshengqingjiaName;


    /**
     * 详情
     */
    @TableField(value = "xueshengqingjia_text")

    private String xueshengqingjiaText;


    /**
     * 请假类型
     */
    @TableField(value = "xueshengqingjia_types")

    private Integer xueshengqingjiaTypes;


    /**
     * 请假时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "xueshengqingjia_time")

    private Date xueshengqingjiaTime;


    /**
     * 请假天数
     */
    @TableField(value = "xueshengqingjia_number")

    private Integer xueshengqingjiaNumber;


    /**
     * 学生
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 审核结果
     */
    @TableField(value = "xueshengqingjia_yesno_types")

    private Integer xueshengqingjiaYesnoTypes;


    /**
     * 处理结果
     */
    @TableField(value = "xueshengqingjia_yesno_text")

    private String xueshengqingjiaYesnoText;


    /**
     * 创建时间
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
	 * 设置：请假原因
	 */
    public String getXueshengqingjiaName() {
        return xueshengqingjiaName;
    }
    /**
	 * 获取：请假原因
	 */

    public void setXueshengqingjiaName(String xueshengqingjiaName) {
        this.xueshengqingjiaName = xueshengqingjiaName;
    }
    /**
	 * 设置：详情
	 */
    public String getXueshengqingjiaText() {
        return xueshengqingjiaText;
    }
    /**
	 * 获取：详情
	 */

    public void setXueshengqingjiaText(String xueshengqingjiaText) {
        this.xueshengqingjiaText = xueshengqingjiaText;
    }
    /**
	 * 设置：请假类型
	 */
    public Integer getXueshengqingjiaTypes() {
        return xueshengqingjiaTypes;
    }
    /**
	 * 获取：请假类型
	 */

    public void setXueshengqingjiaTypes(Integer xueshengqingjiaTypes) {
        this.xueshengqingjiaTypes = xueshengqingjiaTypes;
    }
    /**
	 * 设置：请假时间
	 */
    public Date getXueshengqingjiaTime() {
        return xueshengqingjiaTime;
    }
    /**
	 * 获取：请假时间
	 */

    public void setXueshengqingjiaTime(Date xueshengqingjiaTime) {
        this.xueshengqingjiaTime = xueshengqingjiaTime;
    }
    /**
	 * 设置：请假天数
	 */
    public Integer getXueshengqingjiaNumber() {
        return xueshengqingjiaNumber;
    }
    /**
	 * 获取：请假天数
	 */

    public void setXueshengqingjiaNumber(Integer xueshengqingjiaNumber) {
        this.xueshengqingjiaNumber = xueshengqingjiaNumber;
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
	 * 设置：审核结果
	 */
    public Integer getXueshengqingjiaYesnoTypes() {
        return xueshengqingjiaYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */

    public void setXueshengqingjiaYesnoTypes(Integer xueshengqingjiaYesnoTypes) {
        this.xueshengqingjiaYesnoTypes = xueshengqingjiaYesnoTypes;
    }
    /**
	 * 设置：处理结果
	 */
    public String getXueshengqingjiaYesnoText() {
        return xueshengqingjiaYesnoText;
    }
    /**
	 * 获取：处理结果
	 */

    public void setXueshengqingjiaYesnoText(String xueshengqingjiaYesnoText) {
        this.xueshengqingjiaYesnoText = xueshengqingjiaYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：创建时间
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
        return "Xueshengqingjia{" +
            "id=" + id +
            ", xueshengqingjiaName=" + xueshengqingjiaName +
            ", xueshengqingjiaText=" + xueshengqingjiaText +
            ", xueshengqingjiaTypes=" + xueshengqingjiaTypes +
            ", xueshengqingjiaTime=" + xueshengqingjiaTime +
            ", xueshengqingjiaNumber=" + xueshengqingjiaNumber +
            ", yonghuId=" + yonghuId +
            ", xueshengqingjiaYesnoTypes=" + xueshengqingjiaYesnoTypes +
            ", xueshengqingjiaYesnoText=" + xueshengqingjiaYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
