package mz.usergate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.util.json.JsonSerializable;
import mz.usergate.domain.entity.Account;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements JsonSerializable, Serializable {

	private String loginId;

	private String password;

	private String email;

	public Account toDomain() {

		return new Account(loginId, password, email);
	}
}
