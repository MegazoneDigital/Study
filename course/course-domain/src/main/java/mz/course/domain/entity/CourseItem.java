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
public class CourseItem extends DomainEntity {

	private String courseId;

	private String courseDay;

	private String coursePeriod;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private int minNumber;

	private int maxNumber;

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "courseId":
					this.courseId = value;
					break;
				case "courseDay":
					this.courseDay = value;
					break;
				case "coursePeriod":
					this.coursePeriod = value;
					break;
				case "startTime":
					this.startTime = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "endTime":
					this.endTime = LocalDateTime.parse(value,
							DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
					break;
				case "minNumber":
					this.minNumber = Integer.parseInt(value);
					break;
				case "maxNumber":
					this.maxNumber = Integer.parseInt(value);
					break;
			}
		}
	}
}
