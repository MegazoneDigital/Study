package mz.study.domain.entity;

import java.time.LocalDate;
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
@Entity(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_seq", nullable = false)
	private long studentSeq;

	private long academySeq;

	private String name;

	private int gradle;

	private LocalDate birthday;

	private String email;

	private String phone;

	private String parentName;

	private String parentPrimaryPhone;

	private String parentSecondaryPhone;

	private LocalDateTime registrationDate;

	private boolean registrationStatus;
}
