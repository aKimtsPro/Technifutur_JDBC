package be.bstorm.akimts.dao.impl;

import be.bstorm.akimts.ConnectionFactory;
import be.bstorm.akimts.dao.SupplierDAO;
import be.bstorm.akimts.models.Product;
import be.bstorm.akimts.models.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SupplierDAOImpl implements SupplierDAO {

    // INSERTINTO
    @Override
    public void insert(Supplier entity) {
        String sql = "INSERT INTO suppliers (supplier_id, company_name, contact_name, contact_title, address, city, region, postal_code, country, phone, fax, homepage)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection co = ConnectionFactory.createConnection();
                PreparedStatement stmt = co.prepareStatement( sql );
        ) {
            stmt.setLong( 1, entity.getId() );
            stmt.setString( 2, entity.getCompany() );
            stmt.setString( 3, entity.getContactName() );
            stmt.setString( 4, entity.getContactTitle() );
            stmt.setString( 5, entity.getAddress() );
            stmt.setString( 6, entity.getCity() );
            stmt.setString( 7, entity.getRegion() );
            stmt.setString( 8, entity.getPostalCode() );
            stmt.setString( 9, entity.getCountry() );
            stmt.setString( 10, entity.getPhone() );
            stmt.setString( 11, entity.getFax() );
            stmt.setString( 12, entity.getHomepage() );

            stmt.executeUpdate();
        }
        catch (SQLException ex){
            throw new RuntimeException("insert impossible", ex);
        }
    }

    @Override
    public List<Supplier> getAll() {
        String sql = """
                SELECT *
                FROM suppliers
                """;

        try (
                Connection co = ConnectionFactory.createConnection();
                Statement stmt = co.createStatement();
                ResultSet rs = stmt.executeQuery( sql );
        ) {

            List<Supplier> products = new ArrayList<>();

            while( rs.next() )
                products.add( Converter.convert(rs, Supplier.class) );

            return products;

        }
        catch (SQLException ex) {
            throw new RuntimeException("error in data access", ex);
        }
    }



    @Override
    public Optional<Supplier> getOne(Long id) {
        String sql = """
                SELECT *
                FROM suppliers
                WHERE supplier_id =
                """ + id;

        try (
                Connection co = ConnectionFactory.createConnection();
                Statement stmt = co.createStatement();
                ResultSet rs = stmt.executeQuery( sql );
        ) {

            if( rs.next() )
                return Optional.of( Converter.convert(rs, Supplier.class) );
            else
                return Optional.empty();

        }
        catch ( SQLException ex ){
            throw new RuntimeException("error in data access", ex);
        }
    }

    @Override
    public void update(Long id, Supplier entity) {

    }

    @Override
    public void delete(Long id) {

    }


}
