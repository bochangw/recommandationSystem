package com.bowang.recommandationSystem.Repository;

import com.bowang.recommandationSystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
