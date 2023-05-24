package mz.study.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.CourseRegistration;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_registration")
public class CourseRegistrationEntity extends DomainEntityJpo {

	private String studentId;

	private String courseItemTeacherId;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;

	public CourseRegistrationEntity(CourseRegistration courseRegistration) {

		BeanUtils.copyProperties(courseRegistration, this);
	}

	public CourseRegistration toDomain() {
		CourseRegistration courseRegistration = new CourseRegistration();
		BeanUtils.copyProperties(this, courseRegistration);
		return courseRegistration;
	}
}
