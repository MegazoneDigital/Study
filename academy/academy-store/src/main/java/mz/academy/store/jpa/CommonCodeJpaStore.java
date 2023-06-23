package mz.academy.store.jpa;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mz.academy.domain.entity.CommonCode;
import mz.academy.store.BaseStore;
import mz.academy.store.jpa.entity.CommonCodeEntity;
import mz.academy.store.jpa.repository.CommonCodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommonCodeJpaStore implements BaseStore<CommonCode> {

	private final CommonCodeRepository commonCodeRepository;

	@Override
	public String create(CommonCode commonCode) {

		CommonCodeEntity commonCodeEntity = new CommonCodeEntity(commonCode);
		commonCodeRepository.save(commonCodeEntity);
		return commonCodeEntity.getId();
	}

	@Override
	public void update(CommonCode commonCode) {
		Optional<CommonCodeEntity> optCommonCodeEntity = commonCodeRepository.findById(
				commonCode.getId());
		if (optCommonCodeEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		CommonCodeEntity savingEntity = optCommonCodeEntity.get();
		BeanUtils.copyProperties(commonCode, this);
		commonCodeRepository.save(savingEntity);
	}

	@Override
	public void delete(String id) {

		commonCodeRepository.deleteById(id);
	}

	@Override
	public CommonCode findAcademy(String id) {
		Optional<CommonCodeEntity> optCommonCodeEntity = commonCodeRepository.findById(id);
		if (optCommonCodeEntity.isEmpty()) {
			throw new EntityNotFoundException();
		}
		return optCommonCodeEntity.get().toDomain();
	}

	@Override
	public List<CommonCode> findAll() {
		return CommonCodeEntity.toDomains(commonCodeRepository.findAll());
	}
}
