package com.ace.cms;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;


import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 启动类
 * @date: 2017年10月16日 下午4:54:41
 */
@Slf4j
@SpringBootApplication
public class Bootstrap {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		checkCommandArgs(args);
		new SpringApplication(Bootstrap.class).run(args);
	}

	@PostConstruct
	public void init() {
		log.info("默认环境参数：{}", Arrays.toString(environment.getDefaultProfiles()));
	}

	@PreDestroy
	public void destroy() {
		log.info("应用关闭中...");
	}

	/**
	 * 检查入参，如果不满足条件，阻止启动
	 * @param args
	 */
	private static void checkCommandArgs(String[] args) {
		//获取请求参数，转换为properties
		SimpleCommandLinePropertySource commandLineArgs = new SimpleCommandLinePropertySource(args);
		log.info("启动参数：{}", Arrays.toString(commandLineArgs.getPropertyNames()));
	}
}
