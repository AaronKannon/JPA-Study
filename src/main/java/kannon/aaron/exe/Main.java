package kannon.aaron.exe;

import kannon.aaron.classes.Aluno;
import kannon.aaron.classes.Aluno_;
import kannon.aaron.classes.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Exercicio 01 e 02
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Exerc02");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Curso cursoParaAdicionar = new Curso("Programação em Python", "30h");
//        Aluno alunoParaAdicionar = new Aluno("Daniel", 29, cursoParaAdicionar);
//
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(cursoParaAdicionar);
//        entityManager.persist(alunoParaAdicionar);
//
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//        entityManagerFactory.close();

        // Exercicio 03
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Exerc02");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Curso cursoParaAdicionar2 = new Curso("Programação em Javascript", "40h");
        entityManager.persist(cursoParaAdicionar2);
        entityManager.persist(new Curso("Angular JS", "60h"));
        entityManager.persist(new Aluno("Daniel", 29, cursoParaAdicionar2));
        entityManager.persist(new Aluno("Joao", 20, cursoParaAdicionar2));
        entityManager.persist(new Aluno("Pedro", 30, cursoParaAdicionar2));
        entityManager.getTransaction().commit();

        // Native SQL
        String sqlList = "SELECT * FROM Aluno";
        List<Aluno> alunoSQLList = entityManager
                .createNativeQuery(sqlList, Aluno.class)
                .getResultList();

        alunoSQLList.forEach(Aluno -> System.out.println("Consulta alunoSQLList: " + Aluno));

        // JPQL
        String jpqlList = "select a from Aluno a where a.curso = :curso";
        List<Aluno> alunoJPQLList = entityManager
                .createQuery(jpqlList, Aluno.class)
                .setParameter("curso", cursoParaAdicionar2)
                .getResultList();

        alunoJPQLList.forEach(Aluno -> System.out.println("Consulta alunoJPQLList: " + Aluno));

        // Criteria API
        CriteriaQuery<Aluno> criteriaQueryList = entityManager.getCriteriaBuilder().createQuery(Aluno.class);
        Root<Aluno> alunoRootList = criteriaQueryList.from(Aluno.class);
        List<Aluno> alunoAPICriteriaList = entityManager.createQuery(criteriaQueryList).getResultList();

        alunoAPICriteriaList.forEach(Aluno -> System.out.println("Consulta aluno APICriteriaList: " + Aluno));
    }
}
