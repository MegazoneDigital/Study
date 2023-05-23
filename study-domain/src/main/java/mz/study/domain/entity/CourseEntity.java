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
@Entity(name = "course")
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_seq", nullable = false)
	private long courseSeq;

	private long coursePlanningSeq;

	private long subjectSeq;

	private long subjectGradleSeq;

	private String title;

	private String remarks;

	private LocalDateTime courseRegistrationStartDate;

	private LocalDateTime courseRegistrationEndDate;

	private LocalDateTime courseNewRegistrationStartDate;

	private LocalDateTime courseNewRegistrationEndDate;
}
