package br.senac.donc.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDAO <T, ID> {
    void salvarOuAlterar(T entidade, Session session) throws HibernateException;

    void remover(T entidade, Session session) throws HibernateException;
    
    T pesquisarPorId(ID id, Session session) throws  HibernateException;
    
    List<T> listarTodos(Session session) throws HibernateException;
}