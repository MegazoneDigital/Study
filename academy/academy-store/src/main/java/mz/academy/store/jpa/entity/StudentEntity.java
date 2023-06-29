package mz.academy.store.jpa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.academy.domain.entity.Student;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student")
public class StudentEntity extends DomainEntityJpo {

	private String academyId;

	private String name;

	private int grade;

	private LocalDate birthday;

	private String email;

	private String phone;

	private String parentName;

	private String parentPrimaryPhone;

	private String parentSecondaryPhone;

	private LocalDateTime registrationDate;

	private boolean registrationStatus;

	public StudentEntity(Student student){

		BeanUtils.copyProperties(student, this);
	}

	public Student toDomain() {
		Student student = new Student();
		BeanUtils.copyProperties(this, student);
		return student;
	}

	public static List<Student> toDomains(List<StudentEntity> studentEntities) {
		return studentEntities.stream().map(StudentEntity::toDomain)
				.collect(Collectors.toList());
	}
}
