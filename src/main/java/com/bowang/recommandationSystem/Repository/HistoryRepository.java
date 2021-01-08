package com.bowang.recommandationSystem.Repository;

import com.bowang.recommandationSystem.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, String> {
}
