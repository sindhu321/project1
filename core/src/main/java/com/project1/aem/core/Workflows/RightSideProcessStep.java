package com.project1.aem.core.Workflows;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
import com.project1.aem.core.FirstService;

@Component(immediate=true,metatype=true)
@Service(value=RightSideProcessStep.class)

public class RightSideProcessStep implements WorkflowProcess{
	@Reference
	 FirstService fs;

	
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	@Override
	public void execute(WorkItem item, WorkflowSession session, MetaDataMap args) throws WorkflowException {
		WorkflowData wddata = item.getWorkflowData();
		String path = wddata.getPayload().toString();	
		log.info("path triggred");
		fs.addNodeFromService(path, "right");
		
	}

}
