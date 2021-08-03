package kannon.aaron.classes;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ {

	public static volatile SingularAttribute<Aluno, Integer> idade;
	public static volatile SingularAttribute<Aluno, Curso> curso;
	public static volatile SingularAttribute<Aluno, String> nome;
	public static volatile SingularAttribute<Aluno, Integer> id;

	public static final String IDADE = "idade";
	public static final String CURSO = "curso";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

