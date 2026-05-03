package dev.mariorich.sensei.dto;

import java.time.LocalDate;
import dev.mariorich.sensei.domain.enums.StudentGender;
import dev.mariorich.sensei.domain.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record StudentRequest(
    @NotBlank(message = "Name is required")
    @Size(max = 150, message = "Name must be at most 150 characters")
    String name,
    
    @Past(message = "Birth date must be in the past")
    LocalDate birthDate,
    
    @Size(max = 1, message = "Gender must be a single character")
    StudentGender gender,

    @Size(max = 20, message = "Phone must be at most 20 characters")
    String phone,

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Size(max = 150, message = "Email must be at most 150 characters")
    String email,
    
    String observations,
    
    @Size(max = 150, message = "Address must be at most 150 characters")
    String address,
    
    @Size(max = 20, message = "Number must be at most 20 characters")
    String number,
    
    @Size(max = 100, message = "Complement must be at most 100 characters")
    String complement,
    
    @Size(max = 100, message = "Neighborhood must be at most 100 characters")
    String neighborhood,
    
    @Size(max = 100, message = "City must be at most 100 characters")
    String city,
    
    @Size(max = 2, message = "State must be at most 2 characters")
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
