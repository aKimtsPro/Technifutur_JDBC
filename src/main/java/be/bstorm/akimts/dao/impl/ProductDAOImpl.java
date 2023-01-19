package be.bstorm.akimts.dao.impl;

import be.bstorm.akimts.ConnectionFactory;
import be.bstorm.akimts.dao.ProductDAO;
import be.bstorm.akimts.models.Product;
import be.bstorm.akimts.models.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public void insert(Product entity) {

    }

    @Override
    public List<Product> getAll() {
        String sql = """
                SELECT *
                FROM products JOIN suppliers s
                    ON products.supplier_id = s.supplier_id
                """;

        try (
                Connection co = ConnectionFactory.createConnection();
                Statement stmt = co.createStatement();
                ResultSet rs = stmt.executeQuery( sql );
        ) {

            List<Product> products = new ArrayList<>();

            while( rs.next() )
                products.add( Converter.convert(rs, Product.class) );

            return products;

        }
        catch (SQLException ex) {
            throw new RuntimeException("error in data access", ex);
        }
    }

    @Override
    public Optional<Product> getOne(Long id) {

        String sql = """
                SELECT *
                FROM products
                WHERE product_id=
                """ + id;

        try (
                Connection co = ConnectionFactory.createConnection();
                Statement stmt = co.createStatement();
                ResultSet rs = stmt.executeQuery( sql );
        ) {

            if( rs.next() )
                return Optional.of( Converter.convert(rs, Product.class) );
            else
                return Optional.empty();

        }
        catch ( SQLException ex ){
            throw new RuntimeException("error in data access", ex);
        }
    }

    @Override
    public void update(Long id, Product entity) {

    }

    @Override
    public void delete(Long id) {

    }


}
