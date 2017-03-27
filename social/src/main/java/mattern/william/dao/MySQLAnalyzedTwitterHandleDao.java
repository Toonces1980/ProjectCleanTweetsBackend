package mattern.william.dao;

import mattern.william.dao.AnalyzedTwitterHandleDao;
import mattern.william.entity.AnalyzedTwitterHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by williammattern on 3/27/17.
 */

@Repository("mysql")
public class MySQLAnalyzedTwitterHandleDao implements AnalyzedTwitterHandleDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        //SELECT column_name FROM table_name
        final String sql = "SELECT id, twitter_handle, positive_score, negative_score FROM analyzedTwitterHandles";
        List<AnalyzedTwitterHandle> handleList = jdbcTemplate.query(sql, new RowMapper<AnalyzedTwitterHandle>() {
            @Override
            public AnalyzedTwitterHandle mapRow(ResultSet resultSet, int i) throws SQLException {
                AnalyzedTwitterHandle handle = new AnalyzedTwitterHandle();
                handle.setId(resultSet.getInt("id"));
                handle.setTwitterHandle(resultSet.getString("twitter_handle"));
                handle.setPostiveScore(resultSet.getInt("positive_score"));
                handle.setNegativeScore(resultSet.getInt("negative_score"));
                return handle;
            }
        });
        return handleList;
    }

    @Override
    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByID(int id) {
        return null;
    }

    @Override
    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByHandle(String handle) {
        return null;
    }

    @Override
    public void removeHandleByID(int id) {

    }

    @Override
    public void removeHandleByHandle(String handle) {

    }

    @Override
    public void insertHandle(AnalyzedTwitterHandle handle) {

    }
}
