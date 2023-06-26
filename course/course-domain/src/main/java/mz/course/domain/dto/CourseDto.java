package mz.course.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import mz.course.domain.entity.Course;

@Getter
@Setter
public class CourseDto {

	private String coursePlanningId;

	private String subjectId;

	private String subjectGradeId;

	private String title;

	private String remarks;

	private LocalDateTime courseRegistrationStartDate;

	private LocalDateTime courseRegistrationEndDate;

	private LocalDateTime courseNewRegistrationStartDate;

	private LocalDateTime courseNewRegistrationEndDate;

	public Course toDomain() {
		return new Course(coursePlanningId, subjectId, subjectGradeId, title, remarks,
				courseRegistrationStartDate, courseRegistrationEndDate,
				courseNewRegistrationStartDate, courseNewRegistrationEndDate);
	}

}
