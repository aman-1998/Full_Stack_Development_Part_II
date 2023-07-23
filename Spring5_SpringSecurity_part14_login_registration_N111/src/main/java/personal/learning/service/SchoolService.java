package personal.learning.service;

import java.util.List;

import personal.learning.model.School;
import personal.learning.web.view.SchoolTopperSummaryView;

public interface SchoolService {
	
	School getSchoolInfo();
	
	String getSchoolName() throws Exception;
	
	List<SchoolTopperSummaryView> getToppersList();
}
