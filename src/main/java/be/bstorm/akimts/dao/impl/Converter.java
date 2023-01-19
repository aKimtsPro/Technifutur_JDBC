package be.bstorm.akimts.dao.impl;

import be.bstorm.akimts.models.Product;
import be.bstorm.akimts.models.Supplier;

import java.sql.ResultSet;
import java.sql.SQLException;

abstract class Converter {

    static <T> T convert(ResultSet rs, Class<T> resultClass) throws SQLException {
        if( resultClass.equals( Product.class ) )
            return (T)convertProduct(rs);
        else if (resultClass.equals( Supplier.class ))
            return (T)convertSupplier(rs);

        throw new IllegalArgumentException("resultClass invalid");
    }

    private static Product convertProduct(ResultSet rs) throws SQLException {
        Product prod = new Product();

        prod.setId( rs.getLong( "product_id" ) );
        prod.setName( rs.getString( "product_name" ) );
        prod.setStock( rs.getInt( "units_in_stock" ) );
        prod.setUnitPrice( rs.getDouble( "unit_price" ) );
        prod.setQttPerUnit( rs.getString( "quantity_per_unit" ) );
        prod.setDiscontinued( rs.getBoolean( "discontinued" ) );

        if( rs.getObject("supplier_id") != null )
            prod.setSupplier( convertSupplier( rs ) );

        return prod;
    }

    private static Supplier convertSupplier(ResultSet rs) throws SQLException {

        Supplier supplier = new Supplier();

        supplier.setId( rs.getLong("supplier_id") );
        supplier.setCity( rs.getString("city") );
        supplier.setAddress( rs.getString("address") );
        supplier.setPostalCode( rs.getString("postal_code") );
        supplier.setCity( rs.getString("city") );
        supplier.setCountry( rs.getString("country") );
        supplier.setRegion( rs.getString("region") );
        supplier.setCompany( rs.getString("company_name") );
        supplier.setContactTitle( rs.getString("contact_title") );
        supplier.setContactName( rs.getString("contact_name") );
        supplier.setPhone( rs.getString("phone") );
        supplier.setFax( rs.getString("fax") );
        supplier.setHomepage( rs.getString("homepage") );

        return supplier;
    }

}
