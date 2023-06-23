package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.SubjectGrade;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.SubjectGradeEntity;
import mz.academy.store.jpa.repository.SubjectGradeRepository;
import mz.common.exception.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SubjectGradeJpaStore implements BaseStore<SubjectGrade> {

	private final SubjectGradeRepository subjectGradeRepository;

	@Override
	public String create(SubjectGrade subjectGrade) {

		SubjectGradeEntity subjectGradeEntity = new SubjectGradeEntity(subjectGrade);
		subjectGradeRepository.save(subjectGradeEntity);
		return subjectGrade.getId();
	}

	@Override
	public void update(SubjectGrade subjectGrade) {

		Optional<SubjectGradeEntity> optSubjectGradeEntity = subjectGradeRepository.findById(subjectGrade.getId());
		if(optSubjectGradeEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		SubjectGradeEntity savingEntity = optSubjectGradeEntity.get();
		BeanUtils.copyProperties(subjectGrade, this);
		subjectGradeRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		subjectGradeRepository.deleteById(id);
	}

	@Override
	public SubjectGrade findAcademy(String id) {

		Optional<SubjectGradeEntity> optSubjectGradeEntity = subjectGradeRepository.findById(id);
		if(optSubjectGradeEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optSubjectGradeEntity.get().toDomain();
	}

	@Override
	public List<SubjectGrade> findAll() {
		return SubjectGradeEntity.toDomains(subjectGradeRepository.findAll());
	}
}
