package Application.View;

import Application.Model.Cookbook;
import Application.Model.CookbookList;
import Application.Model.Product;
import Application.Model.Recipe;


public class BasicViews {

    public void showCookbookList(CookbookList cookbookList){
        if(cookbookList.getCookbooks().isEmpty() == true) System.out.println("There is no cookbooks.");
        else{
            System.out.println("Cookbooks: ");
            int i = 1;
            for (Cookbook cookbook : cookbookList.getCookbooks()) {
                System.out.println(i + "\t" + cookbook.getName());
                i++;
            }
        }
    }


    public void showRecipeList(Cookbook cookbook){
        if(cookbook.getRecipes().isEmpty() == true) System.out.println("This cookbook is empty.");
        else{
            System.out.println("Recipes: ");
            int i = 1;
            for(Recipe recipe : cookbook.getRecipes()){
                System.out.println(i + "\t" + recipe.getName());
                i++;
            }
        }
    }

    public void showRecipe(Recipe recipe){
        System.out.println(recipe.getName().toUpperCase());

        System.out.println("\nProducts: ");
        String productString;
        for(Product product : recipe.getProductList()){
            productString = product.getName();
            if(product.getValue() != -1) productString = productString + " " + product.getValue();
            if(product.getUnit() != null) productString = productString + " " + product.getUnit();
            System.out.println(productString);
        }

        int timeNeeded = recipe.getTimeNeeded();
        if(timeNeeded == -1) System.out.println("\nTime needed not specified");
        else System.out.println("\nTime needed: " + timeNeeded + "mins");

        System.out.println("\nSteps: ");
        int i = 1;
        for(String step : recipe.getSteps()){
            System.out.println(i + ". " + step);
            i++;
        }


    }

}
