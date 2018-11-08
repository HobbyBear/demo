package com.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.demo.annotations.MyAnnotation;

/**
 * 
 * @Desciption 统一日志处理
 * @author HobbyBear
 * @date 2018年11月7日 下午8:03:18
 */
@Component
@Aspect
public class LogAspectJAdvise {
	/**
	 * 对service的方法进行日志记录
	 */
	// @Pointcut("within(com.demo.service..*) && @annotation(myAnnotation)")
	// private void serviceMethod() {
	//
	// }
	//
	// @Pointcut("within(com.demo.controller..*) && @annotation(myAnnotation)")
	// private void controllerMethod() {
	//
	// }

	@Before("within(com.demo.controller..*) && @annotation(myAnnotation)")
	public void beforeController(JoinPoint joinPoint, MyAnnotation myAnnotation) {
		String des = getMethodNameAndArgs(joinPoint);
		Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
		if (!des.equals("")) {
			logger.info("控制层方法描述:" + myAnnotation.desc() + " 开始");
		}
		logger.info(des);
	}

	@After("within(com.demo.controller..*) && @annotation(myAnnotation)")
	public void afterController(JoinPoint joinPoint, MyAnnotation myAnnotation) {
		String des = getMethodNameAndArgs(joinPoint);
		if (!des.equals("")) {
			Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
			logger.info("控制层方法描述:" + myAnnotation.desc() + " 结束");
		}

	}

	@Before("within(com.demo.service..*) && @annotation(myAnnotation)")
	public void beforeService(JoinPoint joinPoint, MyAnnotation myAnnotation) {
		String des = getMethodNameAndArgs(joinPoint);
		Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
		if (!des.equals("")) {
			logger.info("业务层方法描述:" + myAnnotation.desc() + " 开始");
		}
		logger.info(des);
	}

	@After("within(com.demo.service..*) && @annotation(myAnnotation)")
	public void afterService(JoinPoint joinPoint, MyAnnotation myAnnotation) {
		String des = getMethodNameAndArgs(joinPoint);
		if (!des.equals("")) {
			Logger logger = Logger.getLogger(joinPoint.getTarget().getClass());
			logger.info("业务层方法描述:" + myAnnotation.desc() + " 结束");
		}

	}

	/**
	 * 获取方法名和参数
	 * 
	 * @param joinPoint
	 * @return
	 */
	public static String getMethodNameAndArgs(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		StringBuffer sBuffer = new StringBuffer("请求方法");
		sBuffer.append(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "(");
		for (int i = 0; i < args.length; i++) {
			sBuffer.append("arg[" + i + "]:" + args[i] + ",");
		}
		if (args.length > 0) {
			sBuffer.deleteCharAt(sBuffer.length() - 1);
		}
		sBuffer.append(")");
		return sBuffer.toString();
	}

}
