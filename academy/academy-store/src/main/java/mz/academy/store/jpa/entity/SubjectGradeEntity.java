package mz.academy.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.academy.domain.entity.SubjectGrade;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "subject_grade")
public class SubjectGradeEntity extends DomainEntityJpo {

	private String subjectId;

	private int grade;

	public SubjectGradeEntity(SubjectGrade subjectGrade) {
		this.subjectId = subjectGrade.getSubjectId();
		this.grade = subjectGrade.getGrade();
	}

	public SubjectGrade toDomain() {

		return new SubjectGrade(this.subjectId, this.grade);
	}
}
