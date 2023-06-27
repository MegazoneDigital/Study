package mz.academy.store.jpa.entity;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.academy.domain.entity.Teacher;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teacher")
public class TeacherEntity extends DomainEntityJpo {

	private String academyId;

	private String name;

	private String subjectType;

	private String email;

	private String phone;

	private boolean deleteFlag;

	public TeacherEntity(Teacher teacher) {

		BeanUtils.copyProperties(this, teacher);
	}

	public static List<Teacher> toDomains(List<TeacherEntity> teacherEntities) {
		return teacherEntities.stream().map(TeacherEntity::toDomain)
				.collect(Collectors.toList());
	}

	public Teacher toDomain() {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(this, teacher);
		return teacher;
	}
}
