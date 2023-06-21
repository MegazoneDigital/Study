package mz.course.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseApplication extends DomainEntity {

	private String studentId;

	private String courseItemTeacherId;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;
}
