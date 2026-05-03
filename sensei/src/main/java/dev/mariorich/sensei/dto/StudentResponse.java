package dev.mariorich.sensei.dto;

import java.time.LocalDateTime;
import java.time.LocalDate;

import dev.mariorich.sensei.domain.Student;
import dev.mariorich.sensei.domain.enums.StudentGender;

public record StudentResponse(
    Long id,
    String name,
    LocalDate birthDate,
    StudentGender gender,
    String phone,
    String email,
    String city,
    String state,
    LocalDateTime createdAt
) {
    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(
            student.getId(),
            student.getName(),
            student.getBirthDate(),
            student.getGender(),
            student.getPhone(),
            student.getEmail(),
            student.getCity(),
            student.getState(),
            student.getCreatedAt()
        );
    }

}
