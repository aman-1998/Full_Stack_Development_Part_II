package personal.learning.model.entity;

import java.time.Instant;

public class ResponseInfo {
	private Instant currentTime;
	private String status;
	
	public ResponseInfo(Instant currentTime, String status) {
		this.currentTime = currentTime;
		this.status = status;
	}

	public ResponseInfo(String status) {
		this.status = status;
	}

	public Instant getCurrentTime() {
		return currentTime;
	}

	public String getStatus() {
		return status;
	}
}
