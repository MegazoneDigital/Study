package mz.study.store.jpa.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.Academy;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "academy")
public class AcademyEntity extends DomainEntityJpo {

	private String name;

	private String email;

	private String phone;

	public AcademyEntity(Academy academy) {

		BeanUtils.copyProperties(academy, this);
	}

	public Academy toDomain() {

		Academy academy = new Academy();
		BeanUtils.copyProperties(this, academy);
		return academy;
	}

	public static List<Academy> toDomains(List<AcademyEntity> academyEntities) {

		return academyEntities.stream().map(AcademyEntity::toDomain)
				.collect(Collectors.toList());
	}
}
