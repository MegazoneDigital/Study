package mz.course.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseItemTeacher extends DomainEntity {

	private String courseItemId;

	private String teacherId;

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "courseItemId":
					this.courseItemId = value;
					break;
				case "teacherId":
					this.teacherId = value;
					break;
			}
		}
	}
}
