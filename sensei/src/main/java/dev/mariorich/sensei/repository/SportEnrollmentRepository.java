package dev.mariorich.sensei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.mariorich.sensei.domain.SportEnrollment;

@Repository
public interface SportEnrollmentRepository extends JpaRepository<SportEnrollment, Long> {

}
