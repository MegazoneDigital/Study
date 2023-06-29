package mz.academy.store.jpa.entity;


import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.academy.domain.entity.AcademyManager;
import mz.common.domain.entity.DomainEntityJpo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "academy_manager")
public class AcademyManagerEntity extends DomainEntityJpo {

	private String managerId;

	private String academyId;

	public AcademyManagerEntity(AcademyManager academyManager) {

		this.managerId = academyManager.getManagerId();
		this.academyId = academyManager.getAcademyId();
	}

	public AcademyManager toDomain() {

		return new AcademyManager(this.managerId, this.academyId);
	}

	public static List<AcademyManager> toDomains(List<AcademyManagerEntity> academyManagerEntities) {

		return academyManagerEntities.stream().map(AcademyManagerEntity::toDomain)
				.collect(Collectors.toList());
	}
}
