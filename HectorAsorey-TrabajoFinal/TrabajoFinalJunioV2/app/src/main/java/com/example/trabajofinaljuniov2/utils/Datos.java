package com.example.trabajofinaljuniov2.utils;

import com.example.trabajofinaljuniov2.R;

import java.util.ArrayList;

public class Datos {

    private ArrayList<Juego> juegosXbox;
    private ArrayList<Juego> juegosPS4;
    private ArrayList<Juego> juegosSwitch;
    private ArrayList<Juego> todosLosJuegos;

    public Datos(){
        juegosXbox = new ArrayList<>();
        juegosPS4 = new ArrayList<>();
        juegosSwitch = new ArrayList<>();
        todosLosJuegos = new ArrayList<>();
    }

    public void instanciarJuegos(){
        juegosXbox.add(new Juego("Halo 3", 60.00, R.drawable.halo3, "XBOX"));
        juegosXbox.add(new Juego("Halo 3 ODST", 60.00, R.drawable.haloodst, "XBOX"));
        juegosXbox.add(new Juego("Halo Reach", 60.00, R.drawable.haloreach, "XBOX"));
        juegosXbox.add(new Juego("Halo 4", 40.00, R.drawable.halo4, "XBOX"));
        juegosXbox.add(new Juego("Halo 5", 30.00, R.drawable.halo5, "XBOX"));
        juegosXbox.add(new Juego("Halo Infinite", 60.00, R.drawable.haloinfinite, "XBOX"));
        juegosXbox.add(new Juego("Destiny", 40.00, R.drawable.destiny, "XBOX"));
        juegosXbox.add(new Juego("Destiny 2", 60.00, R.drawable.destiny2, "XBOX"));
        juegosXbox.add(new Juego("Gears of War 2", 30.00, R.drawable.gow2, "XBOX"));
        juegosXbox.add(new Juego("Gears of War 3", 30.00, R.drawable.gow3, "XBOX"));
        juegosXbox.add(new Juego("Gears of War Judgement", 60.00, R.drawable.gowjudgement, "XBOX"));
        juegosXbox.add(new Juego("Gears of War", 20.00, R.drawable.gearsofwar, "XBOX"));
    }

    public void instanciarJuegosPS4(){
        juegosPS4.add(new Juego("Metal Gear Rising", 20.00, R.drawable.metalgearrising, "PS4"));
        juegosPS4.add(new Juego("Devil May Cry V", 30.00, R.drawable.devilmaycryv, "PS4"));
        juegosPS4.add(new Juego("Elden Ring", 60.00, R.drawable.eldenring, "PS4"));
        juegosPS4.add(new Juego("Bloodborne", 20.00, R.drawable.bloodborne, "PS4"));
        juegosPS4.add(new Juego("Dark Souls", 40.00, R.drawable.darksouls, "PS4"));
        juegosPS4.add(new Juego("Dark Souls II", 20.00, R.drawable.darksouls2, "PS4"));
        juegosPS4.add(new Juego("Dark Souls III", 40.00, R.drawable.darksouls3, "PS4"));
    }

    public void instanciarJuegosSwitch(){
        juegosSwitch.add(new Juego("Super Mario Odyssey", 60.00, R.drawable.marioodyssey, "Switch"));
        juegosSwitch.add(new Juego("Metroid Dread", 40.00, R.drawable.metroiddread, "Switch"));
        juegosSwitch.add(new Juego("The Legend of Zelda Breath of the Wild", 60.00, R.drawable.zeldabotw, "Switch"));
        juegosSwitch.add(new Juego("Kirby and the Forgotten Land", 60.00, R.drawable.kirby, "Switch"));
    }

    public void instanciarTodo(){
        todosLosJuegos.add(new Juego("Halo 3", 60.00, R.drawable.halo3, "XBOX"));
        todosLosJuegos.add(new Juego("Halo 3 ODST", 60.00, R.drawable.haloodst, "XBOX"));
        todosLosJuegos.add(new Juego("Halo Reach", 60.00, R.drawable.haloreach, "XBOX"));
        todosLosJuegos.add(new Juego("Halo 4", 40.00, R.drawable.halo4, "XBOX"));
        todosLosJuegos.add(new Juego("Halo 5", 30.00, R.drawable.halo5, "XBOX"));
        todosLosJuegos.add(new Juego("Halo Infinite", 60.00, R.drawable.haloinfinite, "XBOX"));
        todosLosJuegos.add(new Juego("Destiny", 40.00, R.drawable.destiny, "XBOX"));
        todosLosJuegos.add(new Juego("Destiny 2", 60.00, R.drawable.destiny2, "XBOX"));
        todosLosJuegos.add(new Juego("Titanfall 2", 60.00, R.drawable.titanfall2, "XBOX"));
        todosLosJuegos.add(new Juego("Gears of War", 20.00, R.drawable.gearsofwar, "XBOX"));
        todosLosJuegos.add(new Juego("Gears of War 2", 30.00, R.drawable.gow2, "XBOX"));
        todosLosJuegos.add(new Juego("Gears of War 3", 30.00, R.drawable.gow3, "XBOX"));
        //todosLosJuegos.add(new Juego("Gears of War Judgement", 60.00, R.drawable.gowjudgement, "XBOX"));

        todosLosJuegos.add(new Juego("Metal Gear Rising", 20.00, R.drawable.metalgearrising, "PS4"));
        todosLosJuegos.add(new Juego("Devil May Cry V", 30.00, R.drawable.devilmaycryv, "PS4"));
        //todosLosJuegos.add(new Juego("Call of Duty MW2", 60.00, R.drawable.mw2, "PS4"));
        todosLosJuegos.add(new Juego("Elden Ring", 60.00, R.drawable.eldenring, "PS4"));
        todosLosJuegos.add(new Juego("Bloodborne", 20.00, R.drawable.bloodborne, "PS4"));
        todosLosJuegos.add(new Juego("Dark Souls", 40.00, R.drawable.darksouls, "PS4"));
        todosLosJuegos.add(new Juego("Dark Souls II", 20.00, R.drawable.darksouls2, "PS4"));
        todosLosJuegos.add(new Juego("Dark Souls III", 40.00, R.drawable.darksouls3, "PS4"));
        todosLosJuegos.add(new Juego("God of War", 20.00, R.drawable.godofwar, "PS4"));

        todosLosJuegos.add(new Juego("Super Mario Odyssey", 60.00, R.drawable.marioodyssey, "Switch"));
        todosLosJuegos.add(new Juego("Metroid Dread", 40.00, R.drawable.metroiddread, "Switch"));
        todosLosJuegos.add(new Juego("The Legend of Zelda Breath of the Wild", 60.00, R.drawable.zeldabotw, "Switch"));
        todosLosJuegos.add(new Juego("The Legend of Zelda Links Awakening", 60.00, R.drawable.linksawakening, "Switch"));
        todosLosJuegos.add(new Juego("Kirby and the Forgotten Land", 60.00, R.drawable.kirby, "Switch"));

    }

    public ArrayList<Juego> getJuegosXbox() {
        return juegosXbox;
    }

    public void setJuegosXbox(ArrayList<Juego> juegos) {
        this.juegosXbox = juegos;
    }

    public ArrayList<Juego> getJuegosPS4() {
        return juegosPS4;
    }

    public void setJuegosPS4(ArrayList<Juego> juegosPS4) {
        this.juegosPS4 = juegosPS4;
    }

    public ArrayList<Juego> getJuegosSwitch() {
        return juegosSwitch;
    }

    public void setJuegosSwitch(ArrayList<Juego> juegosSwitch) {
        this.juegosSwitch = juegosSwitch;
    }

    public ArrayList<Juego> getTodosLosJuegos() {
        return todosLosJuegos;
    }

    public void setTodosLosJuegos(ArrayList<Juego> todosLosJuegos) {
        this.todosLosJuegos = todosLosJuegos;
    }

}
