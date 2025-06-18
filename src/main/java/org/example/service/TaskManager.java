package org.example.service;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();


    // Cria tarefa
    public void addTask(String name, String description, String isCompletedInput) {
        boolean completedStatus;

        if(isCompletedInput != null && isCompletedInput.trim().equalsIgnoreCase("s")) {
            completedStatus = true;
        } else {
            completedStatus = false;
        }
        Task newTask = new Task(name, description, completedStatus);
        tasks.add(newTask);
        System.out.println("Tarefa '" + name + "' adicionada com sucesso! \nStatus inicial: " + (completedStatus ? "Concluída" : "Não Concluída"));
    }

    //Metodo para processor e exibir tarefas
    private void processAndDisplayTasks(String header, Predicate<Task> filter, Consumer<Task> displayLogic, String noTasksMessage) {
        System.out.println(header);
        boolean found = false;
        for (Task task : tasks) {
            if (filter.test(task)) {
                displayLogic.accept(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println(noTasksMessage);
        }
    }

    private Consumer<Task> getDefaultTaskDisplayLogic() {
        return task -> {
            System.out.println("ID: " + task.getId());
            System.out.println("Nome: " + task.getName());
            System.out.println("Descrição: " + task.getDescription());
            System.out.println("Concluída: " + (task.isCompleted() ? "Sim" : "Não"));
            System.out.println("------------------------");
        };
    }

    // lista todas as tarefas
    public void listTask() {
        processAndDisplayTasks(
                "=== Todas as tarefas ===",
                task -> true,
                getDefaultTaskDisplayLogic(),
                "Nenhuma tarefa encontrada"
        );
    }

    // listar todas tarefas concluidas
    public void listCompletedTasks() {
       processAndDisplayTasks(
               "=== Tarefas Concluídas ===",
               Task::isCompleted,
               getDefaultTaskDisplayLogic(),
               "Nenhuma tarefa concluída encontrada"
       );
    }

    // listar todas as tarefas não concluídas
    public void listIsNotCompletedTasks() {
       processAndDisplayTasks(
               "=== Tarefas pendentes",
               task -> !task.isCompleted(),
               getDefaultTaskDisplayLogic(),
               "Nenhuma tarefa pendente encontrada"
       );
    }

    //Edita as tarefas
    public void editTask(String name, String newName, String newDescription, String isCompleted) {
        boolean edit = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDescription(newDescription);
                if (task.getName().equals(name)) {
                    if (isCompleted.toLowerCase().equals("s")) {
                        task.markAsCompleted();
                        break;
                    } else if (isCompleted.toLowerCase().equals("n")) {
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
            } else {
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
