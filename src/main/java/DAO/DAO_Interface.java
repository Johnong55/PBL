package DAO;

import java.util.List;

public interface DAO_Interface<T> {
	public List<T> selectall();
	public T selectbyid(T t);
	public boolean insert(T t);
	public boolean update(T t);
	public boolean deletebyid(T t);
}
