package dev.mariorich.sensei.service;

import org.springframework.stereotype.Service;
import dev.mariorich.sensei.domain.Student;
import dev.mariorich.sensei.dto.StudentRequest;
import dev.mariorich.sensei.dto.StudentResponse;
import dev.mariorich.sensei.exception.BusinessRuleException;
import dev.mariorich.sensei.repository.StudentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse createStudent(StudentRequest request) {
        if (request.email() != null && studentRepository.existsByEmail(request.email())) {
            throw new BusinessRuleException("Email already exists");
        }
        Student student = request.toEntity();
        Student savedStudent = studentRepository.save(student);
        return StudentResponse.fromEntity(savedStudent);
    }

    public Page<StudentResponse> list(Pageable pageable) {
        return studentRepository.findAll(pageable).map(StudentResponse::fromEntity);
    }

    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new BusinessRuleException("Student not found"));
        return StudentResponse.fromEntity(student);
    }

    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new BusinessRuleException("Student not found"));
        request.fill(student);
        studentRepository.save(student);
        return StudentResponse.fromEntity(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
