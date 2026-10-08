package persistence;

import exceptions.EntityAlreadyExists;
import exceptions.FailedToPersistOnDatabase;
import exceptions.FailedToRemoveOfDatabase;
import jakarta.persistence.EntityManager;
import models.Aluno;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AlunoDAO implements DAO<Aluno, String>{
    private final EntityManager manager;

    public AlunoDAO(EntityManager entityManager){
        this.manager = entityManager;
    }

    @Override
    public void save(Aluno entity) {
        Optional<Aluno> aluno = findBy(entity.getNome());
        if(aluno.isPresent()) throw new EntityAlreadyExists("aluno já cadastrado na base de dados");
        try{
            manager.getTransaction().begin();
            manager.persist(entity);
            manager.getTransaction().commit();

        }
        catch (Exception e){
            manager.getTransaction().rollback();
            throw new FailedToPersistOnDatabase("falha ao salvar o aluno de id: "+entity.getId());
        }
    }

    @Override
    public void update(Aluno entity) {
        String sql = "update Aluno set nota1 = ?1, nota2 = ?2, nota3 = ?3,email = ?4 where nome=?5";
        try {
            manager.getTransaction().begin();
            manager.createQuery(sql)
                    .setParameter(1, entity.getNota1())
                    .setParameter(2, entity.getNota2())
                    .setParameter(3, entity.getNota3())
                    .setParameter(4, entity.getEmail())
                    .setParameter(5, entity.getNome())
                    .executeUpdate();
            manager.getTransaction().commit();
            manager.clear();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new FailedToPersistOnDatabase("falha ao atualizar o aluno de nome: "+entity.getNome());
        }
    }

    @Override
    public void delete(String key) {
        Optional<Aluno> aluno = findBy(key);
        if (aluno.isEmpty()) throw new NoSuchElementException("falha ao encontrar aluno");
        try {
            manager.getTransaction().begin();
            manager.remove(aluno.get());
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new FailedToRemoveOfDatabase("falha ao remover da base de dados");
        }
    }

    @Override
    public Optional<Aluno> findBy(String key) {
        return Optional.ofNullable(manager.createQuery("select a from Aluno a where a.nome = ?1", Aluno.class)
                .setParameter(1, key)
                .getSingleResultOrNull());
    }

    @Override
    public List<Aluno> getAll() {
        return  manager.createQuery("select a from Aluno a", Aluno.class)
                .getResultList();
    }
}
