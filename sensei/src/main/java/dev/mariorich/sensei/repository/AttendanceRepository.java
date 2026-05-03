package dev.mariorich.sensei.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.mariorich.sensei.domain.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
