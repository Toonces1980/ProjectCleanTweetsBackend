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

    private static class AnalyzedTwitterRowMapper implements RowMapper<AnalyzedTwitterHandle>{
        @Override
        public AnalyzedTwitterHandle mapRow(ResultSet resultSet, int i) throws SQLException {
            AnalyzedTwitterHandle handle = new AnalyzedTwitterHandle();
            handle.setId(resultSet.getInt("id"));
            handle.setTwitterHandle(resultSet.getString("twitter_handle"));
            handle.setPostiveScore(resultSet.getInt("positive_score"));
            handle.setNegativeScore(resultSet.getInt("negative_score"));
            return handle;
        }
    }

    @Override
    public Collection<AnalyzedTwitterHandle> getAllAnalyzedTwitterHandles() {
        //SELECT column_name FROM table_name
        final String sql = "SELECT id, twitter_handle, positive_score, negative_score FROM analyzedTwitterHandles";
        List<AnalyzedTwitterHandle> handleList = jdbcTemplate.query(sql, new AnalyzedTwitterRowMapper());
        return handleList;
    }

    @Override
    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByID(int id) {
        //SELECT column_name FROM table_name WHERE column = value
        final String sql = "SELECT id, twitter_handle, positive_score, negative_score FROM analyzedTwitterHandles WHERE id = ?";
        AnalyzedTwitterHandle handle = jdbcTemplate.queryForObject(sql, new AnalyzedTwitterRowMapper());
        return handle;
    }

    @Override
    public AnalyzedTwitterHandle getAnalyzedTwitterHandleByHandle(String twitter_handle) {
        //SELECT column_name FROM table_name WHERE column = value
        final String sql = "SELECT id, twitter_handle, positive_score, negative_score FROM analyzedTwitterHandles WHERE twitter_handle = ?";
        AnalyzedTwitterHandle outputHandle = jdbcTemplate.queryForObject(sql, new AnalyzedTwitterRowMapper());
        return outputHandle;
    }

    @Override
    public void removeHandleByID(int id) {
        //DELETE FROM table_name WHERE some_column = some_value
        final String sql = "DELETE FROM analyzedTwitterHandles WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void removeHandleByHandle(String handle) {

    }

    @Override
    public void insertHandle(AnalyzedTwitterHandle handle) {

    }
}
