package com.niq.assessment.repository;

import com.niq.assessment.domain.ShelfItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<ShelfItem,Long> {
}
