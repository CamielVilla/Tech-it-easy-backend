package nl.camiel.novi.backend.TechItEasy.Exception;

public class PriceInvalidException extends RuntimeException{
    public PriceInvalidException(){
        super("Price has to be bigger then 0");
    }
}
