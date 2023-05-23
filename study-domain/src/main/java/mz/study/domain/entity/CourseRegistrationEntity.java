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
@Entity(name = "course_registration")
public class CourseRegistrationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_registration_seq", nullable = false)
	private long courseRegistrationSeq;

	private long studentSeq;

	private long courseItemTeacherSeq;

	private LocalDateTime receiptDate;

	private String receiptStatus;

	private int waitNumber;
}
