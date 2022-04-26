package nl.camiel.novi.backend.TechItEasy.repositories;

import nl.camiel.novi.backend.TechItEasy.domain.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TelevisionRepository extends JpaRepository <Television, Long> {

}
