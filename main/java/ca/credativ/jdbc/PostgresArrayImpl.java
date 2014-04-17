package ca.credativ.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.postgresql.jdbc4.Jdbc4Array;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by davec on 2014-04-16.
 */
@Transactional
@Repository
public class PostgresArrayImpl extends JdbcDaoSupport implements PostgresArray
{
    @Autowired
    public PostgresArrayImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public String [] get() throws Exception
    {
        SimpleJdbcCall call = new SimpleJdbcCall(this.getJdbcTemplate());
        call.withFunctionName("usecase01_get");
        call.withSchemaName("public");
        call.withoutProcedureColumnMetaDataAccess();

        call.declareParameters(new SqlOutParameter("testcolumn", java.sql.Types.ARRAY));
        MapSqlParameterSource map = new MapSqlParameterSource();

        Map<String, Object> result = call.execute(map);
        Jdbc4Array jdbc4Array = (Jdbc4Array)result.get("testcolumn");
        try {
            Object o  = jdbc4Array.getArray();
            Logger.getLogger(PostgresArrayImpl.class.getName()).log(Level.SEVERE, null, o);
            return (String [])o;

        } catch (SQLException ex) {
            Logger.getLogger(PostgresArrayImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }
}
