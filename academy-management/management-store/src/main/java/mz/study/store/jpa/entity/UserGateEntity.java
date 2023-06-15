package mz.study.store.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.UserGate;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_gate")
public class UserGateEntity extends DomainEntityJpo {

	@Column(unique = true)
	private String loginId;

	private String password;

	private String email;

	public UserGateEntity(UserGate userGate) {

		BeanUtils.copyProperties(userGate, this);
	}

	public UserGate toDomain() {
		UserGate userGate = new UserGate();
		BeanUtils.copyProperties(this, userGate);
		return userGate;
	}
}
