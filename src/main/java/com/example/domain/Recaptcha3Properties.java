/*
 * @(#)Recaptcha3Properties.java $version 2016. 4. 26.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author serivires
 */
@Component
@ConfigurationProperties(locations = {"classpath:recaptcha3-properties.yml"}, prefix = "recaptcha")
public class Recaptcha3Properties {
	private List<Recaptcha2Properties> configs = new ArrayList<>();

	public List<Recaptcha2Properties> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Recaptcha2Properties> configs) {
		this.configs = configs;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
