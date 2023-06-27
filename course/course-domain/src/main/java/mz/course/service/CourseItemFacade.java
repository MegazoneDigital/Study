package mz.course.service;

import java.util.List;
import mz.common.api.ApiResponse;
import mz.common.domain.NameValueList;
import mz.course.domain.dto.CourseItemDto;
import mz.course.domain.entity.CourseItem;

public interface CourseItemFacade {

	ApiResponse<String> registerCourseItem(CourseItemDto courseItemDto);

	ApiResponse<Void> modifyCourseItem(String id, NameValueList nameValues);

	ApiResponse<Void> removeCourseItem(String id);

	ApiResponse<CourseItem> findCourseItem(String id);

	ApiResponse<List<CourseItem>> findAllCourseItem();
}
