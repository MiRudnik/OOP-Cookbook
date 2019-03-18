package Application.Model;

public class IllegalValueException extends Exception{
    IllegalValueException(){
        super("Value must be greater than zero.");
    }
}
