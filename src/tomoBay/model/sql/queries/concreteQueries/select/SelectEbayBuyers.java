package tomoBay.model.sql.queries.concreteQueries.select;
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.sql.queries.AbstractSelectQueryNoParams;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectEbayBuyers extends AbstractSelectQueryNoParams
{
	/**SQL query string**/
	private final String query ="SELECT * FROM ebay_buyers ORDER BY name ASC";
	
	/**
	 * default constructor
	 */
	public SelectEbayBuyers()
	{super();}
	
	/**
	 * execute the query
	 * @param NOTUSED
	 * @return List<String[]> representing the results of the query. Each element in the list
	 * represents a row of the database and each element of the String[] represents a field.
	 * 
	 * The available fields for each element of the string[] are:
	 * - String[0] = buyerID
	 * - String[1] = name
	 * - String[2] = street1
	 * - String[3] = street2
	 * - String[4] = county
	 * - String[5] = city
	 * - String[6] = postcode
	 * - String[7] = email
	 * - String[8] = phone no
	 * 
	 * @throws SQLException
	 */
	public List<String[]> execute(String[] NOTUSED) throws SQLException
	{
		super.initQuery(this.query);
		ResultSet rs = super.statement_M.executeQuery();
		
		List<String[]> selectResults = this.format(rs);

		super.cleanup();
		
		return selectResults;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractSelectQueryNoParams#format(java.sql.ResultSet)
	 */
	@Override
	protected List<String[]> format(ResultSet resultSet) throws SQLException
	{
		List<String[]> rows = new ArrayList<String[]>();
		while (resultSet.next())
		{
			String[] cols = new String[9];
			cols[0] = resultSet.getString("buyerID");
			cols[1] = resultSet.getString("name");
			cols[2] = resultSet.getString("street1");
			cols[3] = resultSet.getString("street2");
			cols[4] = resultSet.getString("county");
			cols[5] = resultSet.getString("city");
			cols[6] = resultSet.getString("postcode");
			cols[7] = resultSet.getString("email");
			cols[8] = resultSet.getString("phoneNo");
			rows.add(cols);
		}
		return rows;
	}
}