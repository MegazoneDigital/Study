package mz.academy.store.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.academy.domain.entity.CommonCode;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "common_code")
public class CommonCodeEntity extends DomainEntityJpo {

	@Column(unique = true)
	private String code;

	private String mainCode;

	private String codeName;

	private boolean useFlag;

	private String remarks;

	public CommonCodeEntity(CommonCode commonCode) {

		BeanUtils.copyProperties(commonCode, this);
	}

	public CommonCode toDomain() {
		CommonCode commonCode = new CommonCode();
		BeanUtils.copyProperties(this, commonCode);
		return commonCode;
	}
}
