package mz.study.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseItemTeacher extends DomainEntity {

	private String courseItemId;

	private String teacherId;
}
