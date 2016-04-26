/*
 * @(#)SecretKey.java $version 2016. 4. 26.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author serivires
 */
public class SecretKey {
	private Long id;
	private String key;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
