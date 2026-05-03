package dev.mariorich.sensei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.mariorich.sensei.domain.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
