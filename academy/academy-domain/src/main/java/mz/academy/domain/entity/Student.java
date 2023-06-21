package mz.academy.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.common.domain.entity.DomainEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Student extends DomainEntity {

	private String academyId;

	private String name;

	private int grade;

	private LocalDate birthday;

	private String email;

	private String phone;

	private String parentName;

	private String parentPrimaryPhone;

	private String parentSecondaryPhone;

	private LocalDateTime registrationDate;

	private boolean registrationStatus;

	public Student(String id, String academyId, String name, int grade, LocalDate birthday, String email,
				   String phone, String parentName, String parentPrimaryPhone, String parentSecondaryPhone,
				   LocalDateTime registrationDate, boolean registrationStatus) {

		super(id);
		this.academyId = academyId;
		this.name = name;
		this.grade = grade;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.parentName = parentName;
		this.parentPrimaryPhone = parentPrimaryPhone;
		this.parentSecondaryPhone = parentSecondaryPhone;
		this.registrationDate = registrationDate;
		this.registrationStatus = registrationStatus;
	}
}
