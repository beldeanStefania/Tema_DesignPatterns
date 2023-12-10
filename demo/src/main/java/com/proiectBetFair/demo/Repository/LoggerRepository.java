package com.proiectBetFair.demo.Repository;

import com.proiectBetFair.demo.Domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
