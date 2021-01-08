package com.bowang.recommandationSystem.Repository;

import com.bowang.recommandationSystem.entity.KeyWordPair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyWordPairRepository extends JpaRepository<KeyWordPair, Long> {
}
