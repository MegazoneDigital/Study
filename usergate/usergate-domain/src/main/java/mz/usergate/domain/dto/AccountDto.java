package mz.usergate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.usergate.domain.entity.Account;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

	private String loginId;

	private String password;

	private String email;

	public Account toDomain() {

		return new Account(loginId, password, email);
	}
}
