package mz.study.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "course_planning")
public class CoursePlanningEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_planning_seq", nullable = false)
	private long coursePlanningSeq;

	private long academySeq;

	private String title;

	private String planningYear;

	private LocalDateTime courseOpenDate;

	private LocalDateTime courseCloseDate;

	private String remarks;
}
