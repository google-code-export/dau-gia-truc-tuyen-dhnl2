package com.google.api.services.samples.dailymotion.cmdline;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class UserAccountUrl extends GenericUrl {
	@Key
	private String fields;

	public UserAccountUrl(String encodedUrl) {
		super(encodedUrl);
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
}
