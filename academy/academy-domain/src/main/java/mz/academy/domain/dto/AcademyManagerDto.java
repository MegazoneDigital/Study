package mz.academy.domain.dto;

import lombok.Getter;
import lombok.Setter;
import mz.academy.domain.entity.AcademyManager;

@Getter
@Setter
public class AcademyManagerDto {

    private String managerId;

    private String academyId;

    public AcademyManager toDomain() {
        return new AcademyManager(managerId, academyId);
    }
}
