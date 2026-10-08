package persistence;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    public void save(T entity);
    public void update(T entity);
    public void delete(K key);
    public Optional<T> findBy(K key);
    public List<T> getAll();
}
