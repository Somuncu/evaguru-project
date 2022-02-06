package com.eva.project.repo;

import com.eva.project.entity.Portfolio;
import com.eva.project.entity.Share;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository  extends JpaRepository<Portfolio, Long> {
}
