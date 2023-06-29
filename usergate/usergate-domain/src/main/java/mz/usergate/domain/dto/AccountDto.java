package mz.usergate.domain.dto;

import lombok.*;
import mz.common.util.json.JsonSerializable;
import mz.usergate.domain.entity.Account;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto implements JsonSerializable, Serializable {

	private String id;

	private String loginId;

	private String password;

	private String email;

	public Account toDomain() {

		return new Account(id, loginId, password, email);
	}
}
