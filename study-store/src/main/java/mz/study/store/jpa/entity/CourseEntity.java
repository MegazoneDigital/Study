package mz.study.store.jpa.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.Course;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course")
public class CourseEntity extends DomainEntityJpo {

	private String coursePlanningId;

	private String subjectId;

	private String subjectGradeId;

	private String title;

	private String remarks;

	private LocalDateTime courseRegistrationStartDate;

	private LocalDateTime courseRegistrationEndDate;

	private LocalDateTime courseNewRegistrationStartDate;

	private LocalDateTime courseNewRegistrationEndDate;

	public CourseEntity(Course course) {

		BeanUtils.copyProperties(course, this);
	}

	public Course toDomain() {
		Course course = new Course();
		BeanUtils.copyProperties(this, course);
		return course;
	}

}
