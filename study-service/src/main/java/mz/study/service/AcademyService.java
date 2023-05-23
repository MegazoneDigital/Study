package mz.study.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.study.domain.dto.AbstractDto;
import mz.study.domain.dto.AcademyDto;
import mz.study.domain.repository.AcademyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService implements SimpleServiceFacade {

    private final AcademyRepository academyRepository;

    @Override
    public AcademyDto find(long seq) {
        return academyRepository.findById(seq)
                .map(entity -> AbstractDto.toDto(AcademyDto.class, entity))
                .orElse(new AcademyDto());
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public void delete(long seq) {

    }
}
