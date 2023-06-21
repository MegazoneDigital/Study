package mz.usergate.store.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.usergate.domain.entity.Account;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Account")
public class AccountEntity extends DomainEntityJpo {

	@Column(unique = true)
	private String loginId;

	private String password;

	private String email;

	public AccountEntity(Account account) {

		BeanUtils.copyProperties(account, this);
	}

	public Account toDomain() {
		Account account = new Account();
		BeanUtils.copyProperties(this, account);
		return account;
	}
}
