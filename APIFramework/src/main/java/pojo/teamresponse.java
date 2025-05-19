package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class teamresponse {

	public String status;
	public String message;
	public List<Object> resultObj;
			
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getresultObj() {
		return resultObj;
	}

	public void setresultObj(List<Object> resultObj) {
		this.resultObj = resultObj;
	}

}
