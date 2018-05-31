package com.ace.cms.enums;

import org.apache.commons.lang.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	OVERFLOW("OVERFLOW", "系统繁忙，请稍后再试", "SYSTEM BUSY! PLEASE TRY AGAIN LATER.","Sistema ocupado, por favor tente mais tarde"),
    SYS_ERR("SYS_ERR", "操作失败,请稍后再试", "Unknown error! Please try again later.","Erro desconhecido, por favor tente mais tarde");

    private String code;
    // 中文描述
    private String desc;
    // 英文描述
    private String en;
    // 葡萄牙文描述
    private String descPt;
    
	public static ErrorCode getErrorCodeByCode(String code) {
		for (ErrorCode errorCodeEnum : ErrorCode.values()) {
			if (StringUtils.equals(code, errorCodeEnum.getCode())) {
				return errorCodeEnum;
			}
		}
		return null;
	}
}