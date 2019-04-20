package com.project1.aem.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.installer.api.info.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;

public class SlingModelEx 
{
	 @Model(adaptables = Resource.class)
	 public class TestModel {
	    
	  // Injects currentPage using ScriptVariable annotation
//	     @ScriptVariable(name="currentPage",injectionStrategy=InjectionStrategy.REQUIRED)
//	     Page page;
//	     
//
//	     public String getPagePath() {
//	         return  page.getPath();
//	     }
		 @Inject @Default(values="enter any text")
		 public String text;
		 @Inject
		 @Named("sling:resourceType")
		 public String resourceType;
		 @Inject
		 @Named("jcr:title")
		 @Default(values="enter any text")
		 public String title;
		 
		 @PostConstruct
	     protected void init()
	     {
	    	this.title=title+"message"; 
	     }
	     
		 
		 public String getText()
		 {
			 return text; 
		 }
	     public String getTitle()
	     {
	    	 return title;
	     }
	     
	    
	 }
}
