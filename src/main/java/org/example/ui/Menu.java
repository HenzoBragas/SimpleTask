package org.example.ui;

import org.example.model.Task;
import org.example.service.TaskManager;

import java.util.Scanner;

public class Menu {

    private Scanner sc;
    private TaskManager manager;

    public Menu(TaskManager manager) {
        this.manager = manager;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--Menu do To do List--");
            System.out.println("1. Cadastrar nova tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Listar todas as tarefas não concluídas");
            System.out.println("4. Listar todas as tarefas concluídas");
            System.out.println("5. Editar tarefa");
            System.out.println("6. Concluir tarefa");
            System.out.println("7. Remover tarefa");
            System.out.println("8. Sair do programa");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> showAddTasK();
                case 2 -> manager.listTask();
                case 3 -> manager.listIsNotCompletedTasks();
                case 4 -> manager.listCompletedTasks();
                case 5 -> showEditTasks();
                case 6 -> showCompleteTasks();
                case 7 -> showRemoveTasks();
                case 8 -> System.out.println("Saindo programa..");
                default -> System.out.println("Opção invalida");
            }
        } while (option != 8);
    }

    public void showAddTasK() {
        System.out.println("\n --Adicionar uma nova tarefa--");
        System.out.println("Nome da tarefa");
        String name = sc.nextLine();

        System.out.println("Descrição da tarefa");
        String description = sc.nextLine();


        Task task = new Task(name, description);
        manager.addTask(name, description);
    }

    public void showEditTasks() {
        System.out.println("--Editar tarefa");
        System.out.println("Digite o nome da tarefa que deseja editar");
        String name = sc.nextLine();
        System.out.println("Renomeia o nome da tarefa: ");
        String newName = sc.nextLine();
        System.out.println("Nova descrição: ");
        String newDescription = sc.nextLine();
        System.out.println("Status da tarefa: (SIM/NAO) ");
        String isCompleted = sc.nextLine();

        manager.editTask(name, newName, newDescription, isCompleted);
    }

    public void showCompleteTasks() {
        System.out.println("--Concluir Tarefa");
        System.out.println("Digite o nome da tarefa que deseja concluir ou desconcluir");
        String name = sc.nextLine();
        System.out.println("Status da tarefa: (SIM/NAO) ");
        String isCompleted = sc.nextLine();

        manager.completedTask(name, isCompleted);
    }

    public void showRemoveTasks() {
        System.out.println("--Deletar Tarefa");
        System.out.println("Digite o nome da tarefa que deseja excluir");
        String name = sc.nextLine();

        manager.removeTask(name);
    }
}