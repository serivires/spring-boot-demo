/*
 * @(#)YamlDemoController.java $version 2016. 4. 27.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Recaptcha2Properties;
import com.example.domain.Recaptcha3Properties;
import com.example.domain.RecaptchaProperties;

/**
 * @author serivires
 */
@Controller
@RequestMapping("yaml")
public class YamlDemoController {
	@Autowired
	RecaptchaProperties recaptchaProperties;

	@Autowired
	Recaptcha2Properties recaptcha2Properties;

	@Autowired
	Recaptcha3Properties recaptcha3Properties;

	@RequestMapping("/1")
	@ResponseBody
	public String test1() {
		return recaptchaProperties.toString();
	}

	@RequestMapping("/2")
	@ResponseBody
	public String test2() {
		return recaptcha2Properties.toString();
	}

	@RequestMapping("/3")
	@ResponseBody
	public String test3() {
		return recaptcha3Properties.toString();
	}
}
