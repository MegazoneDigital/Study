package mz.academy.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
public class Manager extends DomainEntity {

    private String name;

    private String email;

    private String phone;

    private String roleCode;

    private boolean deleteFlag;

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
                case "phone":
                    this.phone = value;
                    break;
                case "roleCode":
                    this.roleCode = value;
                    break;
                case "deleteFlag":
                    this.deleteFlag = Boolean.parseBoolean(value);
                    break;
            }
        }
    }

    public Manager(String id, String name, String email, String phone, String roleCode, boolean deleteFlag) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roleCode = roleCode;
        this.deleteFlag = deleteFlag;
    }
}
