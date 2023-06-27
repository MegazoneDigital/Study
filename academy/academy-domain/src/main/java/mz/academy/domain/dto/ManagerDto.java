package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.Manager;

import java.util.UUID;

@Getter
@Setter
public class ManagerDto {

    private String name;

    private String email;

    private String phone;

    private String roleCode;

    private boolean deleteFlag;

    public Manager toDomain() {
        return new Manager(UUID.randomUUID().toString(), name, email, phone, roleCode, deleteFlag);
    }
}
