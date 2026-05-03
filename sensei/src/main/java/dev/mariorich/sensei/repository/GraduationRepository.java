package dev.mariorich.sensei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.mariorich.sensei.domain.Graduation;

@Repository
public interface GraduationRepository extends JpaRepository<Graduation, Long> {

}
