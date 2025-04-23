package com.entity.vo;

import com.entity.XueshengqingjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生请假
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xueshengqingjia")
public class XueshengqingjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
