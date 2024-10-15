package org.eightbit.damdda.project.repository;


import org.eightbit.damdda.project.domain.ProjectPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PackageRepository extends JpaRepository<ProjectPackage,Long> {


}
