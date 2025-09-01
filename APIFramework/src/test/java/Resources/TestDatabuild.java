package Resources;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import pojo.teamsrequest;

public class TestDatabuild {

	public static teamsrequest teamspayload()
			throws JsonProcessingException { 
		teamsrequest teamsreq = new teamsrequest();
		teamsreq.getEmpId();
		teamsreq.getEndDate();
		teamsreq.getFirstName();
		teamsreq.getGroupId();
		teamsreq.getMobileNumber();
		teamsreq.getPageNo();
		teamsreq.getPageSize();
		teamsreq.getSearchParam();
		teamsreq.getStartDate();
		teamsreq.getstoreId();
		teamsreq.setEmpId(null);
		teamsreq.setEndDate(null); 
		teamsreq.setFirstName(null);
		teamsreq.setGroupId(null);
		teamsreq.setMobileNumber(null);
		teamsreq.setPageNo(1);
		teamsreq.setstoreId(null);
		teamsreq.setPageSize(30);
		return teamsreq;
	}

	
}
