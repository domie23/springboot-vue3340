package com.entity.view;

import com.entity.KaoqinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 考勤通知
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kaoqin")
public class KaoqinView extends KaoqinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 考勤专业的值
		*/
		private String zhuanyeValue;



	public KaoqinView() {

	}

	public KaoqinView(KaoqinEntity kaoqinEntity) {
		try {
			BeanUtils.copyProperties(this, kaoqinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 考勤专业的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 考勤专业的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
			}













}
