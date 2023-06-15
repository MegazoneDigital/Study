package mz.study.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
public class Teacher extends DomainEntity {

	private String academyId;

	private String name;

	private String subjectType;

	private String email;

	private String phone;

	private boolean deleteFlag;

	public Teacher(String id, String academyId, String name, String subjectType, String email, String phone) {
		super(id);
		this.academyId = academyId;
		this.name = name;
		this.subjectType = subjectType;
		this.email = email;
		this.phone = phone;
		this.deleteFlag = false;
	}
}
