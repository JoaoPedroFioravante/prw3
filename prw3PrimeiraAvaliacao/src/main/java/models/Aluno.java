package models;

import java.math.BigDecimal;

public class Aluno {
    private Long id;
    private String nome;
    private String ra;
    private String email;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;


    private Aluno(Long id, String nome, String ra, String email, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public static Aluno createAluno(Long id, String nome, String ra, String email, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3){
        if(id < 0) throw new IllegalArgumentException("id do aluno não pode ser negativo");
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("o nome do aluno deve ser uma string valida e não vazia");
        if(ra == null || ra.isBlank()) throw new IllegalArgumentException("o ra do aluno deve ser uma string valida e não vazia");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("o email do aluno deve ser uma string valida e não vazia");
        if(nome.length() < 3) throw new IllegalArgumentException("o nome do aluno deve possuir ao menos 3 caracteres");
        if(nota1 == null || nota2 == null || nota3 == null) throw new IllegalArgumentException("notas não podem ser nulas");
        if(nota1.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 1 não pode ser negativa");
        if(nota2.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 2 não pode ser negativa");
        if(nota3.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 3 não pode ser negativa");
        return new Aluno(id, nome, ra, email, nota1, nota2, nota3);
    }

}
