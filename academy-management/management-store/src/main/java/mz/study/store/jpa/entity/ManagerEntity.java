package mz.study.store.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.study.domain.entity.Manager;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "manager")
public class ManagerEntity extends DomainEntityJpo {

	private String name;

	private String email;

	private String phone;

	private String roleCode;

	private boolean deleteFlag;

	public ManagerEntity(Manager manager) {

		BeanUtils.copyProperties(manager, this);
	}

	public Manager toDomain() {
		Manager manager = new Manager();
		BeanUtils.copyProperties(this, manager);
		return manager;
	}
}
