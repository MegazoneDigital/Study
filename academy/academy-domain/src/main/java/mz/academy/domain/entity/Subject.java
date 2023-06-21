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
public class Subject extends DomainEntity {

	private String academyId;

	private String name;

	private String subjectType;

	private String description;

	private boolean useFlag;

	private String remarks;
}
