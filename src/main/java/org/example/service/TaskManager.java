package org.example.service;

import org.example.model.Task;

import java.util.ArrayList;


public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    // Cria tarefa
    public void addTask(String name, String description) {
        Task newTask = new Task(name, description);
        tasks.add(newTask);
    }

    // lista todas as tarefas
    public void listTask() {
        System.out.println("=== Todas as tarefas ===");
        boolean itFound = false;
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("Nome: " + task.getName());
            System.out.println("Descrição: " + task.getDescription());
            System.out.println("Concluída: " + (task.isCompleted() ? "Sim" : "Não"));
            System.out.println("------------------------");
            itFound = true;
        }
        if (!itFound)
            System.out.println("Nenhuma tarefa encontrada");
    }

    // listar todas tarefas concluidas
    public void listCompletedTasks() {
        System.out.println("=== Todas as tarefas concluídas ===");
        boolean itFound = false;
        for (Task task : tasks) {
            if (task.isCompleted() == true) {
                System.out.println("ID: " + task.getId());
                System.out.println("Nome: " + task.getName());
                System.out.println("Descrição: " + task.getDescription());
                System.out.println("Concluída: " + (task.isCompleted() ? "Sim" : "Não"));
                System.out.println("------------------------");
                itFound = true;
            }
        }
        if (!itFound)
            System.out.println("Nenhuma tarefa encontrada");
    }

    // listar todas as tarefas não concluídas
    public void listIsNotCompletedTasks() {
        System.out.println("=== Todas as tarefas não concluídas ===");
        boolean itFound = false;
        for (Task task : tasks) {
            if (task.isCompleted() == false) {
                System.out.println("ID: " + task.getId());
                System.out.println("Nome: " + task.getName());
                System.out.println("Descrição: " + task.getDescription());
                System.out.println("Concluída: " + (task.isCompleted() ? "Sim" : "Não"));
                System.out.println("------------------------");
                itFound = true;
            }
        }
        if (!itFound)
            System.out.println("Nenhuma tarefa encontrada");
    }

    //Edita as tarefas
    public void editTask(String name, String newName, String newDescription, String isCompleted) {
        boolean edit = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
                if (task.getName().equals(name)) {
                    if (isCompleted.toLowerCase().equals("sim")) {
                        task.markAsCompleted();
                        break;
                    } else if (isCompleted.toLowerCase().equals("nao")) {
                        task.unmarkAsCompleted();
                        break;
                    } else {
                        System.out.println("Opção inválida");
                        return;
                    }
                }
                edit = true;
                break;
            }
            if (!edit) {
                System.out.println("Tarefa não encontrada.");
            } else{
                System.out.println("Tarefa editada com sucesso. ");
            }
        }
    }
    //Marca como concluida ou não
    public void completedTask(String name, String isCompleted) {
        boolean completed = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                if (isCompleted.toLowerCase().equals("s")) {
                    task.markAsCompleted();
                    completed = true;
                    break;
                } else if (isCompleted.toLowerCase().equals("n")) {
                    task.unmarkAsCompleted();
                    completed = true;
                    break;
                } else {
                    System.out.println("Opção inválida");
                    return;
                }
            }
        }
        if (!completed) {
            System.out.println("Tarefa não encontrada.");
        }
    }

    //Remove as tarefas
    public void removeTask(String name) {
        boolean removed = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                tasks.remove(task);
                removed = true;
                System.out.println("Tarefa removida com sucesso.");
                break;
            }
        }
        if (!removed) {
            System.out.println("Tarefa não encontrada.");
        }
    }
}
