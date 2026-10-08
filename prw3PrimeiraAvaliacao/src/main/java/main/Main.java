package main;


import models.Aluno;
import persistence.AlunoDAO;
import utils.JPAUtils;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final AlunoDAO alunoDAO = new AlunoDAO(JPAUtils.getEntityManager());
    public static void main(String[] args) {

            int option;
        do{
            Scanner scanner = new Scanner(System.in);
            menu();
            System.out.printf("digite sua opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    cadastro(scanner);
                    break;
                case 2:
                    excluir(scanner);
                    break;
                case 3:
                    atualizar(scanner);
                    break;
                case 4:
                    buscarPeloNome(scanner);
                    break;
                case 5:
                    exibirTodos();
                    break;
                case 6:
                    System.out.println("saindo .....");
                    break;
                default:
                    System.out.println("opção invalida");
                    break;
            }
        }
        while(option != 6);

    }

    public static void cadastro(Scanner scanner){
        System.out.println("digite o nome: ");
        String nome = scanner.nextLine().trim().toLowerCase();
        System.out.println("digite o email: ");
        String email = scanner.nextLine().trim().toLowerCase();
        System.out.println("digite o ra: ");
        String ra = scanner.nextLine().trim().toLowerCase();
        System.out.println("digite a nota 1: ");
        BigDecimal nota1 = scanner.nextBigDecimal();
        System.out.println("digite a nota 2: ");
        BigDecimal nota2 = scanner.nextBigDecimal();
        System.out.println("digite a nota 3: ");
        BigDecimal nota3 = scanner.nextBigDecimal();
        Aluno novoAluno = Aluno.createAluno(nome, ra, email, nota1, nota2, nota3);
        try {
            alunoDAO.save(novoAluno);
            System.out.println("sucesso ao criar aluno");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void excluir(Scanner scanner){
        System.out.println("digite o nome: ");
        String nome = scanner.nextLine().trim().toLowerCase();
        try{
            alunoDAO.delete(nome);
            System.out.println("sucesso ao excluir");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void atualizar(Scanner scanner){
        System.out.println("digite o nome do aluno: ");
        String nome = scanner.nextLine().trim().toLowerCase();
        Optional<Aluno> aluno = alunoDAO.findBy(nome);
        if(aluno.isEmpty()){
            System.out.println("aluno não encontrado");
            return;
        }
        System.out.println("campos do aluno");
        System.out.println(aluno.get().toString());
        Aluno aluno1 = aluno.get();
        System.out.println("novos campos");
        System.out.println("digite o nome: ");
        aluno1.setNome(scanner.nextLine().trim().toLowerCase());
        System.out.println("digite o email: ");
        aluno1.setEmail(scanner.nextLine().trim().toLowerCase());
        System.out.println("digite o RA: ");
        aluno1.setRa(scanner.nextLine().trim().toLowerCase());
        System.out.println("digite o nota1: ");
        aluno1.setNota1(scanner.nextBigDecimal());
        System.out.println("digite o nota2: ");
        aluno1.setNota2(scanner.nextBigDecimal());
        System.out.println("digite o nota3: ");
        aluno1.setNota3(scanner.nextBigDecimal());
        try{
            alunoDAO.update(aluno1);
            System.out.println("alterado com sucesso");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public static void buscarPeloNome(Scanner scanner){
        System.out.println("digite o nome do aluno: ");
        String nome = scanner.nextLine().trim().toLowerCase();
        Optional< Aluno > aluno= alunoDAO.findBy(nome);
        if(aluno.isEmpty()){
            System.out.println("aluno não encontrado");
            return;
        }
        System.out.println(aluno.get().toString());

    }

    public static void exibirTodos(){
        System.out.println("=================exibindo com status de aprovação=================");
        var listaAlunos = alunoDAO.getAll();
        if(listaAlunos.isEmpty()){
            System.out.println("não há alunos para exibir");
            System.out.println("====================================================================");
            return;
        }
        listaAlunos.forEach((aluno -> {
            System.out.println(aluno.statusAprovacao());
        }));
        System.out.println("====================================================================");
    }

    public static void menu(){
        System.out.println("==============CADASTRO==DE==ALUNOS===============");
        System.out.println("======================OPÇÕES=====================");
        System.out.println("1=================CADASTRAR==ALUNO===============");
        System.out.println("2=================EXCLUIR==ALUNO=================");
        System.out.println("3=================ATUALIZAR==ALUNO===============");
        System.out.println("4=============BUSCAR==ALUNO==PELO==NOME==========");
        System.out.println("5=============EXIBIR==ALUNOS==COM==STATUS========");
        System.out.println("6======================SAIR======================");
    }
}
