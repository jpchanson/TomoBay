package tomoBay.model.sql.queries.factories.insert;
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
import tomoBay.model.sql.framework.queryFactories.AbstractModifyQueryParamsFactory;
import tomoBay.model.sql.framework.queryTypes.modify.AbstractModifyQueryParams;
import tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayTransactions;
/**
 * creates an InsertEbayTransactions query object
 * @see {@link tomoBay.model.sql.queries.concreteQueries.insert.InsertEbayTransactions}
 * @author Jan P.C. Hanson
 *
 */
public final class InsertEbayTransactionsFactory implements AbstractModifyQueryParamsFactory
{
	/**
	 * default ctor
	 */
	public InsertEbayTransactionsFactory()
	{super();}
	
	/**
	 * make the query
	 * @return the query
	 */
	public AbstractModifyQueryParams make()
	{return new InsertEbayTransactions();}
}