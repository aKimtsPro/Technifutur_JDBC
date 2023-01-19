package be.bstorm.akimts;


import be.bstorm.akimts.dao.ProductDAO;
import be.bstorm.akimts.dao.SupplierDAO;
import be.bstorm.akimts.dao.impl.ProductDAOImpl;
import be.bstorm.akimts.dao.impl.SupplierDAOImpl;
import be.bstorm.akimts.models.Product;
import be.bstorm.akimts.models.Supplier;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAOImpl();
        SupplierDAO supplierDAO = new SupplierDAOImpl();

//        List<Product> products = productDAO.getAll();
//        products.forEach( System.out::println );

//        supplierDAO.getAll().forEach( System.out::println );
//        System.out.println(  supplierDAO.getOne(1L) );
        Supplier s = new Supplier();
        s.setId( 999 );
        s.setCompany("Oracle");

        supplierDAO.insert( s );

    }
}