package nl.camiel.novi.backend.TechItEasy.repositories;

import nl.camiel.novi.backend.TechItEasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface TelevisionRepository extends JpaRepository <Television, Long> {

}
