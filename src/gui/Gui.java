package gui;

import database.Database;
import game.Game;
import game.Timer;

import javax.swing.*;
import java.util.concurrent.ScheduledExecutorService;



public class Gui {
    private static Gui gui;
    private Frame frame;

    public Frame getFrame(){
        return frame;
    }

    public static Gui getGuiInstance(){
        if(gui == null){
            gui = new Gui();
        }
        return gui;
    }
    private Gui() {

    }

    public void createComponents() {
        Game.getGameInstance();
        frame = new Frame();
        frame.initPanels();
        frame.setVisible(true);
    }

}