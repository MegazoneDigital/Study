package mz.course.domain.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class Course extends DomainEntity {

	private String coursePlanningId;

	private String subjectId;

	private String subjectGradeId;

	private String title;

	private String remarks;

	private LocalDateTime courseRegistrationStartDate;

	private LocalDateTime courseRegistrationEndDate;

	private LocalDateTime courseNewRegistrationStartDate;

	private LocalDateTime courseNewRegistrationEndDate;

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "coursePlanningId":
					this.coursePlanningId = value;
					break;
				case "subjectId":
					this.subjectId = value;
					break;
				case "subjectGradeId":
					this.subjectGradeId = value;
					break;
				case "title":
					this.title = value;
					break;
				case "remarks":
					this.remarks = value;
					break;
				case "courseRegistrationStartDate":
					this.courseRegistrationStartDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "courseRegistrationEndDate":
					this.courseRegistrationEndDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "courseNewRegistrationStartDate":
					this.courseNewRegistrationStartDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "courseNewRegistrationEndDate":
					this.courseNewRegistrationEndDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
			}
		}
	}
}
