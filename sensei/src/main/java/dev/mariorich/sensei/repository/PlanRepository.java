package dev.mariorich.sensei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dev.mariorich.sensei.domain.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

}
