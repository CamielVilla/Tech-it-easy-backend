package nl.camiel.novi.backend.TechItEasy.repositories;

import nl.camiel.novi.backend.TechItEasy.domain.entity.CiModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiModuleRepository extends JpaRepository<CiModule, Long> {
}
