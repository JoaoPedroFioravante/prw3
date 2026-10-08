package models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "prontuario", length = 20, nullable = false)
    private String ra;
    private String email;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;

    protected Aluno(){}
    
    protected Aluno(  String nome, String ra, String email, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {

        this.nome = nome;
        this.ra = ra;
        this.email = email;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public static Aluno createAluno( String nome, String ra, String email, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3){
        if(nome == null || nome.isBlank()) throw new IllegalArgumentException("o nome do aluno deve ser uma string valida e não vazia");
        if(ra == null || ra.isBlank()) throw new IllegalArgumentException("o ra do aluno deve ser uma string valida e não vazia");
        if(email == null || email.isBlank()) throw new IllegalArgumentException("o email do aluno deve ser uma string valida e não vazia");
        if(nome.length() < 3) throw new IllegalArgumentException("o nome do aluno deve possuir ao menos 3 caracteres");
        if(nota1 == null || nota2 == null || nota3 == null) throw new IllegalArgumentException("notas não podem ser nulas");
        if(nota1.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 1 não pode ser negativa");
        if(nota2.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 2 não pode ser negativa");
        if(nota3.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("nota 3 não pode ser negativa");
        return new Aluno( nome, ra, email, nota1, nota2, nota3);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(this == o) return true;
        if(!(o instanceof Aluno aluno)) return false;
        return  this.ra.equals(aluno.ra);
    }

    @Override
    public int hashCode() {
        return Objects.hash( ra );
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    @Override
    public String toString() {
        return  "Nome: "+nome+
                "\nRA: "+ra+
                "\nemail: "+email+
                "\nnota 1: "+nota1+
                "\nnota 2: "+nota2+
                "\nnota 3: "+nota3;
    }

    public String statusAprovacao(){
        String status = "aprovado";
        BigDecimal media = (nota1.add(nota2.add(nota3)))
                .divide(BigDecimal.valueOf(3), RoundingMode.HALF_EVEN);
        if(media.compareTo(BigDecimal.valueOf(4)) < 0 ) status = "reprovado";
        else if(media.compareTo(BigDecimal.valueOf(6)) < 0) status = "recuperação";
        return "--------------------\n"+toString()+"\nstatus: "+status+"\n------------------------";
    }


}
