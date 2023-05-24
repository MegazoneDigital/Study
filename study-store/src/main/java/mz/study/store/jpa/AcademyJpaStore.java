package mz.study.store.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.study.domain.entity.Academy;
import mz.study.store.AcademyStore;
import mz.study.store.jpa.entity.AcademyEntity;
import mz.study.store.jpa.repository.AcademyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AcademyJpaStore implements AcademyStore {

    private final AcademyRepository academyRepository;

    @Override
    public String create(Academy academy) {

        AcademyEntity academyEntity = new AcademyEntity(academy);
        academyRepository.save(academyEntity);
        return academyEntity.getId();
    }

    @Override
    public void update(Academy academy) {

        Optional<AcademyEntity> optAcademyEntity = academyRepository.findById(academy.getId());
        if(optAcademyEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        AcademyEntity savingEntity = optAcademyEntity.get();
        BeanUtils.copyProperties(academy, this);
        academyRepository.save(savingEntity);
    }

    @Override
    public void delete(String id) {

        academyRepository.deleteById(id);
    }

    @Override
    public Academy findAcademy(String id) {
        //
        Optional<AcademyEntity> optAcademyEntity = academyRepository.findById(id);
        if(optAcademyEntity.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return optAcademyEntity.get().toDomain();
    }

    @Override
    public List<Academy> findAll() {

        return AcademyEntity.toDomains(academyRepository.findAll());
    }
}
