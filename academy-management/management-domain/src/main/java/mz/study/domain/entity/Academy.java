package mz.study.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;
import mz.common.util.json.JsonUtils;
import mz.study.domain.dto.AcademyDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Academy extends DomainEntity {

	private String name;

	private String email;

	private String phone;

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "name":
					this.name = value;
					break;
				case "email":
					this.email = value;
					break;
				case "birthday":
					this.phone = value;
					break;
			}
		}
	}
}
