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
		teamsreq.setGroupId("GRP07BD6F6578D24492B2EB8B58445085C9");
		teamsreq.setMobileNumber(null);
		teamsreq.setPageNo(1);
		teamsreq.setstoreId("STACF1F77E3495F34F8398BA62C05CC26FFD");
		teamsreq.setPageSize(10);
		return teamsreq;
	}

	
}
