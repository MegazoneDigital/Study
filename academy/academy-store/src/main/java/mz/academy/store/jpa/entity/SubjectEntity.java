package mz.academy.store.jpa.entity;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.academy.domain.entity.Subject;
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

	public static List<Subject> toDomains(List<SubjectEntity> subjectEntities) {
		return subjectEntities.stream().map(SubjectEntity::toDomain)
				.collect(Collectors.toList());
	}
}
