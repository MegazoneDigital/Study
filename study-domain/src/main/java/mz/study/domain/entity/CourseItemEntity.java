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
@Entity(name = "course_item")
public class CourseItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_item_seq", nullable = false)
	private long courseItemSeq;

	private long courseSeq;

	private String courseDay;

	private String coursePeriod;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	private int minNumber;

	private int maxNumber;
}
