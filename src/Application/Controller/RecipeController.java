package Application.Controller;

import Application.Model.IllegalValueException;
import Application.Model.Product;
import Application.Model.Recipe;
import Application.Model.Unit;
import Application.View.BasicViews;
import Application.View.ProgramViews;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class RecipeController extends GeneralController implements IChosenCommands  {

    RecipeController (Pointer pointer){
        super(pointer);
    }

    @Override
    protected void doSpecifiedCommand(ArrayList<String> commands){
        switch(commands.get(0)) {
            case "showRecipe": {
                printRecipe();
                break;
            }
            case "addProduct": {
                addProduct(commands);
                break;
            }
            case "addStep": {
                addStep(commands);
                break;
            }
            case "setTimeNeeded": {
                setTimeNeeded(commands);
                break;
            }
            case "back":{
                pointer.setCurrentContext(pointer.getPreviousContext());
                break;
            }
            default: {
                System.out.println("Wrong command.\nType HELP for list of commands");
            }
        }
    }

    @Override
    protected void printHelp(){
        ProgramViews programViewer = new ProgramViews();
        programViewer.showGeneralHelp();
        programViewer.showRecipeHelp();
    }

    private void printRecipe(){
        BasicViews basicViewer = new BasicViews();
        Recipe recipe = (Recipe) pointer.getCurrentContext();
        basicViewer.showRecipe(recipe);
    }

    private void addProduct(ArrayList<String> commands){
        try {
            Recipe recipe = (Recipe) pointer.getCurrentContext();
            String name = commands.get(1);
            if(commands.size() == 2) {
                recipe.addProduct(new Product(name));
            }
            else if(commands.size() == 3) {
                int value = parseInt(commands.get(2));
                recipe.addProduct(new Product(name, value));
            }
             else {
                int value = parseInt(commands.get(2));
                String unitString = commands.get(3);
                Unit unit = Unit.fromString(unitString);
                recipe.addProduct(new Product(name, value, unit));
            }
        }
        catch (IllegalValueException e){
            System.out.println("Value must be greater than zero.");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Parameters weren't provided.");
        }
    }

    private void addStep(ArrayList<String> commands) {
        try {
            Recipe recipe = (Recipe) pointer.getCurrentContext();
            String step = "";
            for(String word : commands) {
                step = step + " " + word;
            }
            recipe.addStep(step);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Name not provided.");
        }
    }

    private void setTimeNeeded(ArrayList<String> commands){
        try {
            Recipe recipe = (Recipe) pointer.getCurrentContext();
            int time = parseInt(commands.get(1));
            recipe.setTimeNeeded(time);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Name not provided.");
        }
    }
}
