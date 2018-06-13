/*****************************************************
 *  HISTORY
 *  FileName:TimerTest.java
 *  Package:com.example.demo.contorller
 *  Project:1803-springTest-8
 *  Version:1.0
 *  Date:2018年6月13日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.example.demo.contorller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年6月13日
 */
@SpringBootApplication
@EnableScheduling
public class TimerTest {
	public static void main(String[] args) {
		SpringApplication.run(TimerTest.class, args);
	}
}
