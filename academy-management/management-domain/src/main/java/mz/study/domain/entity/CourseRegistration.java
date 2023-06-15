package mz.study.domain.entity;

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
public class CourseRegistration extends DomainEntity {

	private String studentId;

	private String courseItemTeacherId;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;
}
