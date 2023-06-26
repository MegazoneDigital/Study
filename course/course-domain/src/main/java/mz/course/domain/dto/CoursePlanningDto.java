package mz.course.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import mz.course.domain.entity.CoursePlanning;

@Getter
@Setter
public class CoursePlanningDto {

	private String academyId;

	private String title;

	private String planningYear;

	private LocalDateTime courseOpenDate;

	private LocalDateTime courseCloseDate;

	private String remarks;

	public CoursePlanning toDomain() {
		return new CoursePlanning(academyId, title, planningYear, courseOpenDate, courseCloseDate,
				remarks);
	}
}
