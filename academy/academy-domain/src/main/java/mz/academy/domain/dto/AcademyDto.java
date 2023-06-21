package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.Academy;

@Getter
@Setter
public class AcademyDto {

    private String name;

    private String email;

    private String phone;

    public Academy toDomain() {

        return new Academy(name, email, phone);
    }
}
