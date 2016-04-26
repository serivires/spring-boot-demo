/*
 * @(#)RecaptchaProperties.java $version 2016. 4. 26.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.example.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author serivires
 */
@Component
@ConfigurationProperties(locations = {"classpath:recaptcha-properties.yml"}, prefix = "recaptcha")
public class RecaptchaProperties {
	private String siteKey;
	private String secretKey;
	private String verifyingUri;

	public String getSiteKey() {
		return siteKey;
	}

	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getVerifyingUri() {
		return verifyingUri;
	}

	public void setVerifyingUri(String verifyingUri) {
		this.verifyingUri = verifyingUri;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
