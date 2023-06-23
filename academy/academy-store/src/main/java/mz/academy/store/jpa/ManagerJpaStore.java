package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.Manager;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.ManagerEntity;
import mz.academy.store.jpa.repository.ManagerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ManagerJpaStore implements BaseStore<Manager> {

	private final ManagerRepository managerRepository;

	@Override
	public String create(Manager manager) {

		ManagerEntity managerEntity = new ManagerEntity(manager);
		managerRepository.save(managerEntity);
		return manager.getId();
	}

	@Override
	public void update(Manager manager) {

		Optional<ManagerEntity> optManagerEntity = managerRepository.findById(manager.getId());
		if(optManagerEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		ManagerEntity savingEntity = optManagerEntity.get();
		BeanUtils.copyProperties(manager, this);
		managerRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		managerRepository.deleteById(id);
	}

	@Override
	public Manager findAcademy(String id) {

		Optional<ManagerEntity> optManagerEntity = managerRepository.findById(id);
		if(optManagerEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}

		return optManagerEntity.get().toDomain();
	}

	@Override
	public List<Manager> findAll() {
		return ManagerEntity.toDomains(managerRepository.findAll());
	}
}
