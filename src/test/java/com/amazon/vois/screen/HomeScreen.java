package com.amazon.vois.screen;

public class HomeScreen extends BaseScreen{
    private final Search search ;
    private final RobbinMenu robbinMenu;
    private final CartShoppingScreen cartShoppingScreen;

    private final LeftMenu leftMenu;
    public HomeScreen(){
        search = new Search();
        robbinMenu = new RobbinMenu();
        cartShoppingScreen = new CartShoppingScreen();
        leftMenu = new LeftMenu();
    }

    public Search getSearch() {
        return search;
    }

    public RobbinMenu getRobbinMenu() {
        return robbinMenu;
    }

    public CartShoppingScreen getCartShoppingScreen(){
        return cartShoppingScreen;
    }

    public LeftMenu getLeftMenu(){
        return leftMenu;
    }
}
