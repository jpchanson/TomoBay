package tomoBay.model.sql.queries.concreteQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.ConnectionManager;
import tomoBay.model.sql.queries.AbstractDBQuery;
/** Copyright(C) 2015 Jan P.C. Hanson & Tomo Motor Parts Limited
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class UpdateEbayBuyer implements AbstractDBQuery
{
	/**reference to the JDBC Statement**/
	private PreparedStatement selectStatement_M = null;
	/**reference to the JDBC Database connection**/
	private Connection connection_M = null;
	/**SQL query string**/
	private String query = "UPDATE ebay_buyers SET name=?,street1=?,street2=?, city=?,county=?,"
							+ "postcode=?, email=?, phoneNo=? WHERE buyerID=?;";
	//
	/**
	 * default constructor
	 */
	public UpdateEbayBuyer()
	{super();}
	
	/**
	 * execute the query
	 * @param parameter 8 element array 
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - col[0] = resultCode
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] parameter) throws SQLException
	{
		this.initQuery();
		this.selectStatement_M.setString(1, parameter[1]);
		this.selectStatement_M.setString(2, parameter[2]);
		this.selectStatement_M.setString(3, parameter[3]);
		this.selectStatement_M.setString(4, parameter[4]);
		this.selectStatement_M.setString(5, parameter[5]);
		this.selectStatement_M.setString(6, parameter[6]);
		this.selectStatement_M.setString(7, parameter[7]);
		this.selectStatement_M.setString(8, parameter[8]);
		this.selectStatement_M.setString(9, parameter[0]);
		int resultCode = this.selectStatement_M.executeUpdate();

		this.connection_M.commit();
		this.cleanup();
		
		List<String[]> res = new ArrayList<String[]>();
		res.add(new String[] {resultCode+""});
		
		return res;
	}
	
	/**
	 * initialise the connection and statement and set transaction variables.
	 * @throws SQLException
	 */
	private void initQuery() throws SQLException
	{
		this.connection_M = ConnectionManager.instance().getConnection();
		this.connection_M.setAutoCommit(false);
		this.selectStatement_M = this.connection_M.prepareStatement(query);
	}
	
	/**
	 * do cleanup after the query has been executed
	 * @throws SQLException
	 */
	private void cleanup() throws SQLException
	{
		if (this.selectStatement_M != null) {this.selectStatement_M.close();}
		if (connection_M != null) {connection_M.close();}
	}
}