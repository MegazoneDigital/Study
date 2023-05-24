package mz.study.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.SubjectGrade;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "subject_grade")
public class SubjectGradeEntity extends DomainEntityJpo {

	private String subjectId;

	private int gradle;

	public SubjectGradeEntity(SubjectGrade subjectGrade) {
		this.subjectId = subjectGrade.getSubjectId();
		this.gradle = subjectGrade.getGrade();
	}

	public SubjectGrade toDomain() {

		return new SubjectGrade(this.subjectId, this.gradle);
	}
}
