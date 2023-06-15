package mz.study.store.jpa.entity;

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
import mz.study.domain.entity.Subject;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "subject")
public class SubjectEntity extends DomainEntityJpo {

	private String academyId;

	private String name;

	private String subjectType;

	@Column(columnDefinition = "TEXT")
	private String description;

	private boolean useFlag;

	private String remarks;

	public SubjectEntity(Subject subject) {

		BeanUtils.copyProperties(subject, this);
	}

	public Subject toDomain() {
		Subject subject = new Subject();
		BeanUtils.copyProperties(this, subject);
		return subject;
	}
}
