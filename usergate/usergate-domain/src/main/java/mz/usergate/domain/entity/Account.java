package mz.usergate.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends DomainEntity {

	private String loginId;

	private String password;

	private String email;

	public Account(String id, String loginId, String password, String email) {
		super(id);
		this.loginId = loginId;
		this.password = password;
		this.email = email;
	}
}
