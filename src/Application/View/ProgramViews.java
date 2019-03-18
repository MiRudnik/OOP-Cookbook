package Application.View;

public class ProgramViews {

    public void showGeneralHelp(){
        System.out.println("HELP" +
                "\nBOOKS" +
                "\nWHEREAMI" +
                "\nSAVE" +
                "\nLOAD");
    }

    public void showCookbookListHelp(){
        System.out.println("addBook" +
                "\ndeleteBook" +
                "\nopenBook");
    }

    public void showCookbookHelp(){
        System.out.println("showRecipes" +
                "\naddRecipe" +
                "\ndeleteRecipe" +
                "\nopenRecipe" +
                "\nback");
    }

    public void showRecipeHelp(){
        System.out.println("showRecipe" +
                "\naddProduct" +
                "\naddStep" +
                "\nsetTimeNeeded" +
                "\nback");
    }
}
