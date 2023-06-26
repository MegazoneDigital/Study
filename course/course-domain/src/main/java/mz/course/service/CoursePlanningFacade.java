package mz.course.service;

import java.util.List;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CoursePlanningDto;
import mz.course.domain.entity.CoursePlanning;

public interface CoursePlanningFacade {

	ApiResponse<String> registerCoursePlanning(CoursePlanningDto coursePlanningDto);

	ApiResponse<Void> modifyCoursePlanning(String id, NameValueList nameValues);

	ApiResponse<Void> removeCoursePlanning(String id);

	ApiResponse<CoursePlanning> findCoursePlanning(String id);

	ApiResponse<List<CoursePlanning>> findAllCoursePlanning();
}
