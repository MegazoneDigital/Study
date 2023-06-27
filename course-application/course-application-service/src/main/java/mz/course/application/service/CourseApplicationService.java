package mz.course.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.course.application.domain.dto.CourseApplicationDto;
import mz.course.application.domain.entity.CourseApplication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseApplicationService {



	// TODO 카프카 PUB 처리
	public void registerCourseApplication(CourseApplicationDto courseApplicationDto) {

	}

	public CourseApplication findCourseApplication(String id) {
		return null;
	}

	public CourseApplication getCourseApplicationResult(String id, String studentId) {
		return null;
	}
}
