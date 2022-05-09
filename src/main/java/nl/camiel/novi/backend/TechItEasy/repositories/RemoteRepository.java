package nl.camiel.novi.backend.TechItEasy.repositories;

import nl.camiel.novi.backend.TechItEasy.domain.entity.Remote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemoteRepository extends JpaRepository <Remote, Long> {
}
