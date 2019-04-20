package com.project1.aem.core.servlets;


import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SuppressWarnings("serial")
@SlingServlet(
		paths="/project1/sindhu",
		methods="GET")

public class ProjectServlet extends SlingSafeMethodsServlet
{
	
	protected final Logger log=LoggerFactory.getLogger(this.getClass());

	 protected void doGet(SlingHttpServletRequest req,SlingHttpServletResponse res)
	 {
		 ResourceResolver resourceResolver = req.getResourceResolver();
		 Resource resource = resourceResolver.getResource("/content/dileepProject/jcr:content");
		 log.info("Path Info:"+resource.getPath());
		 log.info("Path Info:"+resource.getResourceType());
		 log.info("Path Info:"+resource.getResourceSuperType());
		 log.info("Parent Resource"+resource.getParent().toString());
		 Node node = resource.adaptTo(Node.class);
		 Session session = resourceResolver.adaptTo(Session.class);
		 try {
			log.info("Node Path::"+node.getPath());
			node.setProperty("backend", "Content");
			node.addNode("xyz", "cq:PageContent");
			session.save();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		log.info("from Servlet"); 
		 
		
	 }
}
