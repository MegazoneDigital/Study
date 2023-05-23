package mz.study.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.study.domain.entity.AcademyEntity;
import mz.study.domain.repository.AcademyRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService {

	private final AcademyRepository academyRepository;

	public void test() {
		List<AcademyEntity> all = academyRepository.findAll();
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 호출 테스트");
		log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> {}", all);
	}
}
