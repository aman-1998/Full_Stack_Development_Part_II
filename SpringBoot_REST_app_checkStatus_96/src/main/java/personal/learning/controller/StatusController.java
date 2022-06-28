package personal.learning.controller;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import personal.learning.model.entity.ResponseInfo;
import personal.learning.model.entity.StatusInfo;

@RestController
public class StatusController {
	
	@RequestMapping("/checkStatus")
	@ResponseBody
	public ResponseEntity checkStatus(@RequestParam("format") String format) {
		if(format == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		switch(format) {
		case "small":
			return ResponseEntity.ok(new StatusInfo("OK"));
		case "big":
			Instant now = Instant.now();
			return ResponseEntity.ok(new ResponseInfo(now, "OK"));
		default:
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
