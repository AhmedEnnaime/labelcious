package com.labelvie.lablecious.backend.repository;

import com.labelvie.lablecious.backend.models.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
