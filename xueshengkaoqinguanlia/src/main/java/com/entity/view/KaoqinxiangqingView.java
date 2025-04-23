package com.entity.view;

import com.entity.KaoqinxiangqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 考勤详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kaoqinxiangqing")
public class KaoqinxiangqingView extends KaoqinxiangqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 考勤状态的值
		*/
		private String kaoqinxiangqingStatusValue;



		//级联表 kaoqin
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
				* 考勤专业的值
				*/
				private String zhuanyeValue;
			/**
			* 考勤结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			private Date kaoqinTime;

		//级联表 yonghu
			/**
			* 学生姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 学生身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public KaoqinxiangqingView() {

	}

	public KaoqinxiangqingView(KaoqinxiangqingEntity kaoqinxiangqingEntity) {
		try {
			BeanUtils.copyProperties(this, kaoqinxiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 考勤状态的值
			*/
			public String getKaoqinxiangqingStatusValue() {
				return kaoqinxiangqingStatusValue;
			}
			/**
			* 设置： 考勤状态的值
			*/
			public void setKaoqinxiangqingStatusValue(String kaoqinxiangqingStatusValue) {
				this.kaoqinxiangqingStatusValue = kaoqinxiangqingStatusValue;
			}













				//级联表的get和set kaoqin

					/**
					* 获取： 考勤编号
					*/
					public String getKaoqinUuidNumber() {
						return kaoqinUuidNumber;
					}
					/**
					* 设置： 考勤编号
					*/
					public void setKaoqinUuidNumber(String kaoqinUuidNumber) {
						this.kaoqinUuidNumber = kaoqinUuidNumber;
					}

					/**
					* 获取： 考勤标题
					*/
					public String getKaoqinName() {
						return kaoqinName;
					}
					/**
					* 设置： 考勤标题
					*/
					public void setKaoqinName(String kaoqinName) {
						this.kaoqinName = kaoqinName;
					}



					/**
					* 获取： 考勤结束时间
					*/
					public Date getKaoqinTime() {
						return kaoqinTime;
					}
					/**
					* 设置： 考勤结束时间
					*/
					public void setKaoqinTime(Date kaoqinTime) {
						this.kaoqinTime = kaoqinTime;
					}



















				//级联表的get和set yonghu

					/**
					* 获取： 学生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 专业
					*/
					public Integer getZhuanyeTypes() {
						return zhuanyeTypes;
					}
					/**
					* 设置： 专业
					*/
					public void setZhuanyeTypes(Integer zhuanyeTypes) {
						this.zhuanyeTypes = zhuanyeTypes;
					}


						/**
						* 获取： 专业的值
						*/
						public String getZhuanyeValue() {
							return zhuanyeValue;
						}
						/**
						* 设置： 专业的值
						*/
						public void setZhuanyeValue(String zhuanyeValue) {
							this.zhuanyeValue = zhuanyeValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
