package org.example;

import org.example.service.TaskManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.taskAdd("Estudar java", "Estudando Pilares POO");
        manager.taskAdd("Estudar Java11", "Estudando encapsulamento");


        manager.taskList();
        manager.taskListCompleted();
        manager.taskListIsNotCompleted();

        manager.editTask("Estudar java", "Estudar Python", "Estudando coleções", true);
        manager.taskList();
        manager.taskListCompleted();
        manager.taskListIsNotCompleted();

        manager.removeTask("Estudar Java11");


        manager.taskList();

        manager.completedTask("Estudar Python", "n");
        manager.taskList();
    }
}