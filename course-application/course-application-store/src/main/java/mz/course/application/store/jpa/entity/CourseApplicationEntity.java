package mz.course.application.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.course.application.domain.entity.CourseApplication;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_application")
public class CourseApplicationEntity extends DomainEntityJpo {

	private String studentId;

	private String courseItemTeacherId;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;

	public CourseApplicationEntity(CourseApplication courseApplication) {

		BeanUtils.copyProperties(courseApplication, this);
	}

	public CourseApplication toDomain() {
		CourseApplication courseApplication = new CourseApplication();
		BeanUtils.copyProperties(this, courseApplication);
		return courseApplication;
	}
}
