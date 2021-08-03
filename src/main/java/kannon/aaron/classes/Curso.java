package kannon.aaron.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String duracaoHoras;

    @OneToMany(
            mappedBy = "curso",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Aluno> alunos = new ArrayList<>();

    public Curso(String nome, String duracaoHoras){
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String nome, String duracaoHoras, List<Aluno> alunos){
        this.nome = nome;
        this.duracaoHoras = duracaoHoras;
        this.alunos = alunos;
    }

    public Curso(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(String duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", duracaoHoras=").append(duracaoHoras);
        sb.append(", alunos=").append(alunos);
        sb.append('}');
        return sb.toString();
    }
}
