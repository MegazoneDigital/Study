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
import mz.study.domain.entity.CourseItem;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_item")
public class CourseItemEntity extends DomainEntityJpo {

	private String courseId;

	private String courseDay;

	private String coursePeriod;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private int minNumber;

	private int maxNumber;

	public CourseItemEntity(CourseItem courseItem) {

		BeanUtils.copyProperties(courseItem, this);
	}

	public CourseItem toDomain() {
		CourseItem courseItem = new CourseItem();
		BeanUtils.copyProperties(this, courseItem);
		return courseItem;
	}
}
