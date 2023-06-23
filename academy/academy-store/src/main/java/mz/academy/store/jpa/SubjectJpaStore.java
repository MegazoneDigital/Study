package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.Subject;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.SubjectEntity;
import mz.academy.store.jpa.repository.SubjectRepository;
import mz.common.exception.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SubjectJpaStore implements BaseStore<Subject> {

	private final SubjectRepository subjectRepository;

	@Override
	public String create(Subject subject) {

		SubjectEntity subjectEntity = new SubjectEntity(subject);
		subjectRepository.save(subjectEntity);
		return subject.getId();
	}

	@Override
	public void update(Subject subject) {

		Optional<SubjectEntity> optSubjectEntity = subjectRepository.findById(subject.getId());
		if(optSubjectEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		SubjectEntity savingEntity = optSubjectEntity.get();
		BeanUtils.copyProperties(subject, this);
		subjectRepository.save(savingEntity);
 	}

	@Override
	public void delete(String id) {

		subjectRepository.deleteById(id);
	}

	@Override
	public Subject findAcademy(String id) {

		Optional<SubjectEntity> optSubjectEntity = subjectRepository.findById(id);
		if(optSubjectEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optSubjectEntity.get().toDomain();
	}

	@Override
	public List<Subject> findAll() {
		return SubjectEntity.toDomains(subjectRepository.findAll());
	}
}
