package com.project1.aem.core.wcmusepojo;

import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

public class UsePojoClass extends WCMUsePojo {
	protected final org.slf4j.Logger log=LoggerFactory.getLogger(this.getClass());

	private String text;
	private String path;
	private String componnet;
	public String getText() {
		return text;
	}
	public String getPath() {
		return path;
	}
	public String getComponnet() {
		return componnet;
	}
	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		text=getProperties().get("./text", "null");
		path=getProperties().get("./path", "null");
		componnet=getComponent().getName();
		log.info("text:="+text);
		log.info("current componrnt::"+componnet);
		log.info("text:="+path);
		
	}

}
