package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

 class DAOScore extends DAOEntity<Score> {

	 /**
     * Instantiates a new DAO Load Map.
     *
     * @param connection
     *          the connection
     * @throws SQLException
     *           the SQL exception
     */
    public DAOScore(final Connection connection) throws SQLException {
        super(connection);
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#create(model.Entity)
     */
    @Override
    public boolean create(final Score entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#delete(model.Entity)
     */
    @Override
    public boolean delete(final Score entity) {
        // Not implemented
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#update(model.Entity)
     */
    @Override
    public boolean update(final Score entity) {
        // Not implemented
        return false;
    }	

    /*
     * (non-Javadoc)
     *
     * @see model.DAOEntity#SaveScore(java.lang.String)
     */
public void SaveScore (final String name, int score) {
	int id=0;
	try {
		final String sql = "{call Insert_score(?, ?, ?)}";
		final CallableStatement call = this.getConnection().prepareCall(sql);
		call.setInt(1, id);
		call.setString(2, name);
		call.setInt(3, score);
		call.execute();
		final ResultSet resultSet = call.getResultSet();
		
	} catch (final SQLException e) {
		e.printStackTrace();
	}
}

@Override
public Score find(String key) {
	// TODO Auto-generated method stub
	return null;
}

}
