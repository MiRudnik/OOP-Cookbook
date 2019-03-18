package Application.Model;

public class CookbookAlreadyExistsException extends Exception {
    CookbookAlreadyExistsException() {
        super("Cookbook with this name already exists.");
    }
}
