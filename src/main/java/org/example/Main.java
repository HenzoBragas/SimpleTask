package org.example;

import org.example.service.TaskManager;
import org.example.ui.Menu;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Menu menu = new Menu(manager);
        menu.showMenu();


    }
}