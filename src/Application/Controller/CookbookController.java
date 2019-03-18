package Application.Controller;

import Application.Model.Cookbook;
import Application.Model.Recipe;
import Application.View.BasicViews;
import Application.View.ProgramViews;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CookbookController extends GeneralController implements IChosenCommands {

    CookbookController(Pointer pointer){
        super(pointer);
    }

    @Override
    protected void doSpecifiedCommand(ArrayList<String> commands){
        switch(commands.get(0)) {
            case "showRecipes": {
                printRecipes();
                break;
            }
            case "addRecipe": {
                addRecipe(commands);
                break;
            }
            case "deleteRecipe": {
                deleteRecipe(commands);
                break;
            }
            case "openRecipe": {
                openRecipe(commands);
                break;
            }
            case "back":{
                pointer.setCurrentContext(null);
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
        programViewer.showCookbookHelp();
    }

    private void printRecipes(){
        BasicViews basicViewer = new BasicViews();
        Cookbook cookbook = (Cookbook) pointer.getCurrentContext();
        basicViewer.showRecipeList(cookbook);
    }

    private void addRecipe(ArrayList<String> commands){
        try{
            String name = commands.get(1);
            Cookbook cookbook = (Cookbook) pointer.getCurrentContext();
            cookbook.addRecipe(new Recipe(name));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Name not provided.");
        }
    }

    private void deleteRecipe(ArrayList<String> commands){
        try {
            int index = parseInt(commands.get(1));
            index = index - 1;
            Cookbook cookbook = (Cookbook) pointer.getCurrentContext();
            cookbook.removeRecipe(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index not provided.");
        }
    }

    private void openRecipe(ArrayList<String> commands){
        try {
            int index = parseInt(commands.get(1));
            index = index - 1;
            Cookbook cookbook = (Cookbook) pointer.getCurrentContext();
            Recipe context = cookbook.getRecipes().get(index);
            pointer.setCurrentContext(context);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index not provided.");
        }
    }

}
