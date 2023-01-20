package be.bstorm.akimts;


import be.bstorm.akimts.dao.ProductDAO;
import be.bstorm.akimts.dao.SupplierDAO;
import be.bstorm.akimts.dao.impl.ProductDAOImpl;
import be.bstorm.akimts.dao.impl.SupplierDAOImpl;
import be.bstorm.akimts.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws SQLException {

        ProductDAO productDAO = new ProductDAOImpl();
        SupplierDAO supplierDAO = new SupplierDAOImpl();

        Connection co = ConnectionFactory.createConnection();

        ResultSet rs = co.createStatement()
                .executeQuery("SELECT * FROM customers");



//        List<Product> products = productDAO.getAll();
//        products.forEach( System.out::println );

//        supplierDAO.getAll().forEach( System.out::println );
//        System.out.println(  supplierDAO.getOne(1L) );
//        Supplier s = new Supplier();
//        s.setId( 999 );
//        s.setCompany("Oracle");
////
//        supplierDAO.insert( s );
//
//        Supplier toCopy = supplierDAO.getOne(1L)
//                .orElseThrow();
//
//        supplierDAO.update(999L, toCopy);
        supplierDAO.delete(999L);


    }
}