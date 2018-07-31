package com.abdo.project.repositery;

import com.abdo.project.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepositery extends JpaRepository<Insurance,Long> {
}
