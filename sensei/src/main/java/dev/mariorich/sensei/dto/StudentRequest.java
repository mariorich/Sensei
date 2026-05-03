package dev.mariorich.sensei.dto;

import java.time.LocalDate;
import dev.mariorich.sensei.domain.enums.StudentGender;
import dev.mariorich.sensei.domain.Student;

public record StudentRequest(
    String name,
    LocalDate birthDate,
    StudentGender gender,
    String phone,
    String email,
    String observations,
    String address,
    String number,
    String complement,
    String neighborhood,
    String city,
    String state
) {
    public Student toEntity() {
        Student student = new Student();
        fill(student);
        return student;
    }
    public void fill(Student student) {
        student.setName(name);
        student.setBirthDate(birthDate);
        student.setGender(gender);
        student.setPhone(phone);
        student.setEmail(email);
        student.setObservations(observations);
        student.setAdress(address);
        student.setNumber(number);
        student.setComplement(complement);
        student.setNeighborhood(neighborhood);
        student.setCity(city);
        student.setState(state);

}
}
