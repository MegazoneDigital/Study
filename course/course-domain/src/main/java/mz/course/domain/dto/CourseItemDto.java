package mz.course.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import mz.course.domain.entity.CourseItem;

@Getter
@Setter
public class CourseItemDto {

	private String courseId;

	private int courseDay;

	private String coursePeriod;

	private String startTime;

	private String endTime;

	private int minNumber;

	private int maxNumber;

	public CourseItem toDomain() {
		return new CourseItem(courseId, courseDay, coursePeriod, startTime, endTime, minNumber,
				maxNumber);
	}
}
