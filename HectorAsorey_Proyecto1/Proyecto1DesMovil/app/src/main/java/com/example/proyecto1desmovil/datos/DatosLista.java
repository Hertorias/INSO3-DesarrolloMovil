package com.example.proyecto1desmovil.datos;

import com.example.proyecto1desmovil.R;
import com.example.proyecto1desmovil.utils.Desarrollador;
import com.example.proyecto1desmovil.utils.Juego;

import java.util.ArrayList;

public class DatosLista {

    private ArrayList<Juego> juegos;
    private ArrayList<Desarrollador> desarrolladores;

    public DatosLista(){
        juegos = new ArrayList<>();
        desarrolladores = new ArrayList<>();
    }

    public void instanciarJuegos(){
        juegos.add(new Juego("Halo 3","Bungie", "Microsoft Game Studios", "First Person Shooter", "2007", "Xbox 360", R.drawable.halo3));
        juegos.add(new Juego("Halo 3 ODST","Bungie", "Microsoft Game Studios", "First Person Shooter", "2008", "Xbox 360", R.drawable.haloodst));
        juegos.add(new Juego("Halo Reach","Bungie", "Microsoft Game Studios", "First Person Shooter", "2010", "Xbox 360", R.drawable.haloreach));
        juegos.add(new Juego("Destiny","Bungie", "Activision", "Massive Multiplayer Online", "2014", "Xbox 360, Xbox One, PS3, PS4", R.drawable.destiny));
        juegos.add(new Juego("Destiny 2","Bungie", "Activision", "Massive Multiplayer Online", "2017", "Xbox One, Xbox Series, PS4, PS5, PC", R.drawable.destiny2));
        juegos.add(new Juego("Halo 4", "343 Industries", "Microsoft Game Studios", "First Person Shooter", "2012", "Xbox 360", R.drawable.halo4));
        juegos.add(new Juego("Halo 5", "343 Industries", "Microsoft Game Studios", "First Person Shooter", "2015","Xbox One", R.drawable.halo5));
        juegos.add(new Juego("Halo Infinite", "343 Industries", "Microsoft Game Studios", "First Person Shooter", "2021", "Xbox One, Xbox Series, PC", R.drawable.haloinfinite));
        juegos.add(new Juego("Dark Souls", "From Software", "Bandai Namco", "Action RPG", "2011", "Xbox 360, PS3, PC", R.drawable.darksouls));
        juegos.add(new Juego("Dark Souls 2", "From Software", "Bandai Namco", "Action RPG", "2014", "Xbox 360, PS3, PC", R.drawable.darksouls2));
        juegos.add(new Juego("Bloodborne", "From Software", "Sony", "Action RPG", "2015", "PS4", R.drawable.bloodborne));
        juegos.add(new Juego("Dark Souls 3", "From Software", "Bandai Namco", "Action RPG", "2016", "Xbox One, PS4, PC", R.drawable.darksouls3));
        juegos.add(new Juego("Elden Ring", "From Software", "Bandai Namco", "Action RPG", "2022", "Xbox One, Xbox Series, PS4, PS5, PC", R.drawable.eldenring));
        juegos.add(new Juego("The Legend of Zelda Breath of the Wild", "Nintendo", "Nintendo", "Aventura", "2017", "Wii U, Nintendo Switch", R.drawable.zeldabotw));
        juegos.add(new Juego("Super Mario Odyssey", "Nintendo", "Nintendo", "Plataformas", "2017", "Nintendo Switch", R.drawable.marioodyssey));
        juegos.add(new Juego("Metroid Dread", "Nintendo", "Nintendo", "Accion", "2021", "Nintendo Switch", R.drawable.metroiddread));
        juegos.add(new Juego("Kirby y la Tierra Olvidada", "Nintendo", "Nintendo", "Plataformas", "2022", "Nintendo Switch",R.drawable.kirby));

    }

    public void instanciarDesarrolladores(){
        desarrolladores.add(new Desarrollador("Bungie", R.drawable.bungie));
        desarrolladores.add(new Desarrollador("343 Industries", R.drawable.a));
        desarrolladores.add(new Desarrollador("From Software", R.drawable.fromsoftware));
        desarrolladores.add(new Desarrollador("Nintendo", R.drawable.nintendo));
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public ArrayList<Desarrollador> getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(ArrayList<Desarrollador> desarrolladores) {
        this.desarrolladores = desarrolladores;
    }
}
