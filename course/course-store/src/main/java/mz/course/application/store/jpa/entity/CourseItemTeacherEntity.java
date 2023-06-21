package mz.course.application.store.jpa.entity;

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

	public CourseItemTeacher toDomain() {

		return new CourseItemTeacher(this.courseItemId, this.teacherId);
	}
}
