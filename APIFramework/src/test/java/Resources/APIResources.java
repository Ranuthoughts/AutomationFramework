package Resources;

// enum is a special class in java 	which has collection of constants and methods.

public enum APIResources {

	Fetchviraccount("/ecms_portal/enterprise/v1/fetchVirAccDetails"),
	getallteammembersTB("/ecms_portal/team/members/getAllTeamMembersTB");

	private String resource;

	APIResources(String resource) {
		
		this.resource= resource;

	}

	public String getresource() {  
		return resource;
	}

}
