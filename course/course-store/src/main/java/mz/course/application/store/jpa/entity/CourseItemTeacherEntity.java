package mz.course.application.store.jpa.entity;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.course.domain.entity.CourseItemTeacher;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_item_teacher")
public class CourseItemTeacherEntity extends DomainEntityJpo {

	private String courseItemId;

	private String teacherId;

	public CourseItemTeacherEntity(CourseItemTeacher courseItemTeacher) {
		this.courseItemId = courseItemTeacher.getCourseItemId();
		this.teacherId = courseItemTeacher.getTeacherId();
	}

	public static List<CourseItemTeacher> toDomains(
			List<CourseItemTeacherEntity> itemTeacherEntities) {
		return itemTeacherEntities.stream().map(CourseItemTeacherEntity::toDomain)
				.collect(Collectors.toList());
	}

	public CourseItemTeacher toDomain() {

		return new CourseItemTeacher(this.courseItemId, this.teacherId);
	}
}
