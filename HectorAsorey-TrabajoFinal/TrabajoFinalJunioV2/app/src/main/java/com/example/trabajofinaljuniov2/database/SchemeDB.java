package com.example.trabajofinaljuniov2.database;

public interface SchemeDB {

    int VERSION = 1;
    String DB_NAME = "MYGAMES";
    String TAB_GAMES = "GAMES";
    String TAB_CARRITO = "SHOPPINGCART";
    String TAB_USUARIOS = "USERS";
    String COL_GAMES_ID = "_id";
    String COL_GAMES_NAME = "NAME";
    String COL_GAMES_PRICE = "PRICE";
    String COL_GAMES_IMAGE = "IMAGE";
    String COL_GAMES_PLATFORM = "PLATFORM";
    String COL_SHOPPINGCART_USERNAME = "USER";
    String COL_USERS_USERNAME = "USERNAME";
    String COL_USERS_EMAIL = "EMAIL";
    String COL_USERS_PASSWORD = "PASSWORD";

}
