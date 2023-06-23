package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.AcademyManager;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.AcademyManagerEntity;
import mz.academy.store.jpa.repository.AcademyManagerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AcademyManagerJpaStore implements BaseStore<AcademyManager> {

	private final AcademyManagerRepository academyManagerRepository;

	@Override
	public String create(AcademyManager academyManager) {

		AcademyManagerEntity academyManagerEntity = new AcademyManagerEntity(academyManager);
		academyManagerRepository.save(academyManagerEntity);
		return academyManagerEntity.getId();
	}

	@Override
	public void update(AcademyManager academyManager) {

		Optional<AcademyManagerEntity> optAcademyManagerEntity = academyManagerRepository.findById(
				academyManager.getId());
		if (optAcademyManagerEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		AcademyManagerEntity savingEntity = optAcademyManagerEntity.get();
		BeanUtils.copyProperties(academyManager, this);
		academyManagerRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		academyManagerRepository.deleteById(id);
	}

	@Override
	public AcademyManager findAcademy(String id) {
		//
		Optional<AcademyManagerEntity> optAcademyEntity = academyManagerRepository.findById(id);
		if (optAcademyEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optAcademyEntity.get().toDomain();
	}

	@Override
	public List<AcademyManager> findAll() {
		return AcademyManagerEntity.toDomains(academyManagerRepository.findAll());
	}
}
