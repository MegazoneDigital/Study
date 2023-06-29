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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "uxAccountLoginIdPassword",
				columnNames = { "loginId", "password" }) })
@Entity(name = "Account")
public class AccountEntity extends DomainEntityJpo {

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

	public static List<Account> toDomains(List<AccountEntity> accountEntities) {

		return accountEntities.stream().map(AccountEntity::toDomain).collect(Collectors.toList());
	}
}
