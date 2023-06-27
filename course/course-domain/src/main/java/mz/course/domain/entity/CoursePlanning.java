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
public class CoursePlanning extends DomainEntity {

	private String academyId;

	private String title;

	private String planningYear;

	private LocalDateTime courseOpenDate;

	private LocalDateTime courseCloseDate;

	private String remarks;

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "academyId":
					this.academyId = value;
					break;
				case "title":
					this.title = value;
					break;
				case "planningYear":
					this.planningYear = value;
					break;
				case "courseOpenDate":
					this.courseOpenDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "courseCloseDate":
					this.courseCloseDate = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "remarks":
					this.remarks = value;
					break;
			}
		}
	}
}
