package ra.com.reposistory.imp;

import ra.com.entity.Categories;
import ra.com.reposistory.CategoriesRepository;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesRepositoryImp implements CategoriesRepository {
    @Override
    public List<Categories> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Categories> listCategories = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_categories()}");
            ResultSet rs = callSt.executeQuery();
            listCategories = new ArrayList<>();
            while (rs.next()) {
                Categories categories = new Categories();
                categories.setCatalogId(rs.getInt("catalog_id"));
                categories.setCatalogName(rs.getString("catalog_name"));
                categories.setDescription(rs.getString("catalog_description"));
                categories.setStatus(rs.getBoolean("catalog_status"));
                listCategories.add(categories);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listCategories;
    }
}
