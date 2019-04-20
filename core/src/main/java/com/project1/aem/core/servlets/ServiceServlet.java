package com.project1.aem.core.servlets;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project1.aem.core.FirstService;

@SuppressWarnings("serial")
@SlingServlet(
		paths="/project1/service",
		methods="GET")

public class ServiceServlet extends SlingAllMethodsServlet
{
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	 @Reference
	 private FirstService fs;
	 
	 protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res)
	 {
		 log.info("entered serviceServlet");
		fs.addNodeFromService("/content/dileepProject/jcr:content", "service");
		log.info("added node");
		fs.addPropertyFromService("/content/dileepProject/jcr:content","service", "value");
		log.info("added");
	 }
		 
}
