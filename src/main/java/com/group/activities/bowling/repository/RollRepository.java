package com.group.activities.bowling.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group.activities.bowling.entity.implementation.Roll;


public interface RollRepository extends JpaRepository<Roll, Long> {

}
