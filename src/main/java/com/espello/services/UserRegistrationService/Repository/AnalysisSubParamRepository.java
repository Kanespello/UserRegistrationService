package com.espello.services.UserRegistrationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.AnalysisSubParam;

@Repository
public interface AnalysisSubParamRepository extends JpaRepository<AnalysisSubParam, Integer> {
	List<AnalysisSubParam> findAllAnalysisSubParamByAnalysisParamIdIn(List<Integer> analysisParamIds);
}

