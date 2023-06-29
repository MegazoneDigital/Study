package mz.course.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.NameValue;
import mz.common.domain.NameValueList;
import mz.common.domain.entity.DomainEntity;

import java.time.DayOfWeek;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseItem extends DomainEntity {

	private String courseId;

	private DayOfWeek courseDay;

	private String coursePeriod;

	private String startTime;

	private String endTime;

	private int minNumber;

	private int maxNumber;


	public CourseItem(String courseId, int courseDay, String coursePeriod,
					  String startTime, String endTime, int minNumber, int maxNumber) {
		this.courseId = courseId;
		this.courseDay = DayOfWeek.of(courseDay);
		this.coursePeriod = coursePeriod;
		this.startTime = startTime;
		this.endTime = endTime;
		this.minNumber = minNumber;
		this.maxNumber = maxNumber;
	}

	public void modifyValues(NameValueList nameValues) {
		for (NameValue nameValue : nameValues.list()) {
			String value = nameValue.getValue();
			switch (nameValue.getName()) {
				case "courseId":
					this.courseId = value;
					break;
				case "courseDay":
					this.courseDay = DayOfWeek.of(Integer.parseInt(value));
					break;
				case "coursePeriod":
					this.coursePeriod = value;
					break;
				case "startTime":
					this.startTime = value;
					break;
				case "endTime":
					this.endTime = value;
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
