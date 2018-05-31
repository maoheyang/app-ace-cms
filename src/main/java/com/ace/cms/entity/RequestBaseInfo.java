package com.ace.cms.entity;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import lombok.Data;

/**
 * @Description:基础请求对象
 * @author: sanhu
 * @date: 2017年10月17日 上午9:19:21
 */
@Data
public class RequestBaseInfo implements Serializable{
	private static final long serialVersionUID = 6799682561585226797L;
	//移动手机号（用户id）
	private String mobile;
	//系统码
	private String source;
	//系统版本号
	private String version;
	//sessionkey
	private String sessionKey;
	//经度
	private String lng;
	//纬度
	private String lat;
	//验签码
	private String skey;
	//语言 i18n 处理新增择字段
	private String language = "zh";
	//活动id
	private Long activityId;
	
	public String getLanguage() {
		// 默认zh ，并转小写
		return StringUtils.isBlank(language) ? "zh" : language.toLowerCase();
	}
}