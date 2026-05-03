package dev.mariorich.sensei.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

/*
CREATE TABLE sport_enrollments (
    id BIGSERIAL PRIMARY KEY,
    enrollment_id BIGINT NOT NULL REFERENCES enrollments(id) ON DELETE CASCADE,
    sport_id BIGINT NOT NULL REFERENCES sports(id) ON DELETE CASCADE,
    graduation_id BIGINT NOT NULL REFERENCES graduations(id) ON DELETE CASCADE,
    plan_id BIGINT NOT NULL REFERENCES enrollment_plans(id) ON DELETE CASCADE,
    start_date DATE NOT NULL DEFAULT CURRENT_DATE,
    end_date DATE,
    UNIQUE (enrollment_id, sport_id)
);

*/
@Entity
@Table(name = "sport_enrollments")
public class SportEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @ManyToMany
    @JoinColumn(name = "sport_id")
    private Sport sport;

    @ManyToMany
    @JoinColumn(name = "graduation_id")
    private Graduation graduation;

    @ManyToMany
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @Column(name = "start_date")
    private LocalDateTime startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;

    @PrePersist
    public void prePersist() {
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Graduation getGraduation() {
        return graduation;
    }

    public void setGraduation(Graduation graduation) {
        this.graduation = graduation;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    
}
