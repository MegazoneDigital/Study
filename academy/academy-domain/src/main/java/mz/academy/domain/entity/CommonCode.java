package mz.academy.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCode extends DomainEntity {

	private String code;

	private String mainCode;

	private String codeName;

	private boolean useFlag;

	private String remarks;
}
