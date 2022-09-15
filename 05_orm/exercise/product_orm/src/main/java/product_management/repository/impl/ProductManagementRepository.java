package product_management.repository.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.ConnectionUtil;
import product_management.repository.IProductManagementRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductManagementRepository implements IProductManagementRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if(session != null){
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
//        Session session  = ConnectionUtil.sessionFactory.openSession();
//        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
//        TypedQuery<Product> query = session.createQuery(queryStr, Product.class);
//        query.setParameter("id", id);
//        return query.getSingleResult();

        Session session = null;
        Product product;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :id").setParameter("id",id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        Session session = null;

        Product product = findById(id);

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productSearch = new ArrayList<>();
        List<Product> productList = findAll();

        for (Product item : productList) {
            if (item.getName().contains(name)) {
                productSearch.add(item);
            }
        }

        return productSearch;
    }
}