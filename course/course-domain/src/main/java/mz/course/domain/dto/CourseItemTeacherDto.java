package mz.course.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.course.domain.entity.CourseItemTeacher;

@Getter
@Setter
public class CourseItemTeacherDto {

	private String courseItemId;

	private String teacherId;

	public CourseItemTeacher toDomain() {
		return new CourseItemTeacher(courseItemId, teacherId);
	}
}
