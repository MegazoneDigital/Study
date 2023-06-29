package mz.course.application.domain.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseApplicationDto {

	private String studentId;

	private String courseItemTeacherId;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;
}
