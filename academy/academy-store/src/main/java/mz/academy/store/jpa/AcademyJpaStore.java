package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.Academy;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.AcademyEntity;
import mz.academy.store.jpa.repository.AcademyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AcademyJpaStore implements BaseStore<Academy> {

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
    public Academy findById(String id) {
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
