package mz.study.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.Teacher;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "teacher")
public class TeacherEntity extends DomainEntityJpo {

	private long academyId;

	private String name;

	private String subjectType;

	private String email;

	private String phone;

	private boolean deleteFlag;

	public TeacherEntity(Teacher teacher) {

		BeanUtils.copyProperties(this, teacher);
	}

	public Teacher toDomain() {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(this, teacher);
		return teacher;
	}
}
