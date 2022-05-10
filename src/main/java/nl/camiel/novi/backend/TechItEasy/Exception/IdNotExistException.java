package nl.camiel.novi.backend.TechItEasy.Exception;

public class IdNotExistException extends RuntimeException{
    public IdNotExistException(Long id){
        super(id + " not exist");
    }

}
