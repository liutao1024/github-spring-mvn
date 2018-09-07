package cn.spring.mvn.base.util;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public class BaseUtilRepositoryImpl<T, PK extends Serializable> implements BaseUtilRepository<T, PK> {

	@Autowired
	private BaseUtilRepository<T, Serializable> baseUtilRepositoryImpl;
	
	// 从Repository中继承来的
	@Override
	public void deleteAllInBatch() {
		baseUtilRepositoryImpl.deleteAllInBatch();
	}

	@Override
	public void deleteInBatch(Iterable<T> arg0) {
		baseUtilRepositoryImpl.deleteInBatch(arg0);
	}

	@Override
	public List<T> findAll() {
		return baseUtilRepositoryImpl.findAll();
	}

	@Override
	public List<T> findAll(Sort arg0) {
		return baseUtilRepositoryImpl.findAll(arg0);
	}


	@Override
	public T getOne(Serializable arg0) {
		return baseUtilRepositoryImpl.getOne(arg0);
	}

//	@Override
//	public <S extends T> List<S> save(Iterable<S> arg0) {
//		return baseUtilRepositoryImpl.save(arg0);
//	}

	@Override
	public <S extends T> S saveAndFlush(S arg0) {
		return baseUtilRepositoryImpl.saveAndFlush(arg0);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		return baseUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public void delete(Serializable arg0) {
		baseUtilRepositoryImpl.delete(arg0);
	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		baseUtilRepositoryImpl.delete(arg0);
	}

	@Override
	public void deleteAll() {
		baseUtilRepositoryImpl.deleteAll();
	}

	@Override
	public boolean exists(Serializable arg0) {
		return baseUtilRepositoryImpl.exists(arg0);
	}

	@Override
	public T findOne(Serializable arg0) {
		return baseUtilRepositoryImpl.findOne(arg0);
	}

	@Override
	public long count(Specification<T> arg0) {
		return baseUtilRepositoryImpl.count(arg0);
	}

	@Override
	public List<T> findAll(Specification<T> arg0) {
		return baseUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public Page<T> findAll(Specification<T> arg0, Pageable arg1) {
		return baseUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAll(Specification<T> arg0, Sort arg1) {
		return baseUtilRepositoryImpl.findAll(arg0, arg1);
	}

//	@Override
//	public T findOne(Specification<T> arg0) {
//		return baseUtilRepositoryImpl.findOne(arg0);
//	}

	@Override
	public <S extends T> S save(S arg0) {
		return baseUtilRepositoryImpl.save(arg0);
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		baseUtilRepositoryImpl.flush();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.count();
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		baseUtilRepositoryImpl.delete(entity);
	}

	@Override
	public List<T> findAll(Iterable<PK> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findAll(arg0);
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public List<T> findAllById(Iterable<PK> arg0) {
		// TODO Auto-generated method stub
//		return baseUtilRepositoryImpl.findAllById(arg0);
		return null;
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.saveAll(arg0);
	}

	@Override
	public void deleteAll(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		baseUtilRepositoryImpl.deleteAll(arg0);
	}

	@Override
	public void deleteById(PK arg0) {
		// TODO Auto-generated method stub
		baseUtilRepositoryImpl.deleteById(arg0);
	}

	@Override
	public boolean existsById(PK arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.existsById(arg0);
	}

	@Override
	public Optional<T> findById(PK arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findById(arg0);
	}

	@Override
	public <S extends T> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.count(arg0);
	}

	@Override
	public <S extends T> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.exists(arg0);
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findAll(arg0, arg1);
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findOne(arg0);
	}

	@Override
	public Optional<T> findOne(Specification<T> arg0) {
		// TODO Auto-generated method stub
		return baseUtilRepositoryImpl.findOne(arg0);
	}
}
