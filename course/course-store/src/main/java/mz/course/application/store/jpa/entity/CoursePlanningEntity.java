package mz.course.application.store.jpa.entity;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntityJpo;
import mz.course.domain.entity.CoursePlanning;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_planning")
public class CoursePlanningEntity extends DomainEntityJpo {

	private String academyId;

	private String title;

	private String planningYear;

	private LocalDateTime courseOpenDate;

	private LocalDateTime courseCloseDate;

	private String remarks;

	public CoursePlanningEntity(CoursePlanning coursePlanning) {

		BeanUtils.copyProperties(this, coursePlanning);
	}

	public static List<CoursePlanning> toDomains(List<CoursePlanningEntity> planningEntities) {
		return planningEntities.stream().map(CoursePlanningEntity::toDomain)
				.collect(Collectors.toList());
	}

	public CoursePlanning toDomain() {
		CoursePlanning coursePlanning = new CoursePlanning();
		BeanUtils.copyProperties(this, coursePlanning);
		return coursePlanning;
	}
}
