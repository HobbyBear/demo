package com.demo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(GoodsException.class)
	public ModelAndView handGoodException(GoodsException e) {
		ModelAndView model = new ModelAndView();
		model.addObject("errorMsg", e.getMessage());
		model.setViewName("error");
		return model;
	}
}
