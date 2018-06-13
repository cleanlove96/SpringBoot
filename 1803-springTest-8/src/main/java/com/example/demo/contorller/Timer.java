/*****************************************************
 *  HISTORY
 *  FileName:Timer.java
 *  Package:com.example.demo.contorller
 *  Project:1803-springTest-8
 *  Version:1.0
 *  Date:2018年6月13日 zm创建文件
 **********修改记录*************
 * Date:          Author:
 *
 *******************************************************/
package com.example.demo.contorller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 
 * </p>
 * 
 * @Copyright (C),华清远见
 * @author zm
 * @Date:2018年6月13日
 */
@Component
public class Timer {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedDelay = 5000)
	public void run() {
		System.out.println("开始设置时间后执行：" + simpleDateFormat.format(new Date()));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Scheduled(cron = "0 31 15 ? * *")
	public void start() {
		System.out.println("在制定的时间执行：" + simpleDateFormat.format(new Date()));
	}
}
