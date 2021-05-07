package Business;

public interface BaseService<T> {
	
	public void add(T entity);
	public void delete(T entity);
	public void update(T entity);
	
}
