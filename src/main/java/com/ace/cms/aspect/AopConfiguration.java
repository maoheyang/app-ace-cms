package com.ace.cms.aspect;

import com.ace.cms.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 打印请求日志
 * @author: sanhu
 * @date: 2017年10月24日 上午10:18:50
 */
@Slf4j
@Aspect
@Configuration	
public class AopConfiguration {

	/**
	 * 定义拦截规则：拦截com.xqcx.activity.controller包下面的所有类中，有@RequestMapping注解的方法。
	 */
	@Pointcut("execution(* com.ace.cms.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void controllerMethodPointcut() {
	}

	@Around("controllerMethodPointcut()")
	public Object logTimeUsage(ProceedingJoinPoint point) throws Throwable {
		Signature method = point.getSignature();
		long start = System.currentTimeMillis();
		Object ret = point.proceed();
		long end = System.currentTimeMillis();
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		log.info("Method invoke time {} ms by {} {} URL:{}?{}", end - start, method.toShortString(),request.getMethod().toUpperCase(),
				request.getRequestURL().toString(), LogUtils.buildBodyLog(request).toString());
		return ret;
	}

	@AfterThrowing(pointcut="controllerMethodPointcut()",throwing="e")
	public void afterException(Exception e){
		log.error("AopConfiguration AfterThrowing ERROR:", e);
	}
	
}