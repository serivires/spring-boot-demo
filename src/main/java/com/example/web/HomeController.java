/*
 * @(#)HomeController.java $version 2016. 4. 26.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author serivires
 */
@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("message", "hello!");

		return mav;
	}
}