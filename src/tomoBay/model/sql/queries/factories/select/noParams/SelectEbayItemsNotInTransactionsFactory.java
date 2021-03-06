package tomoBay.model.sql.queries.factories.select.noParams;
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
import tomoBay.model.sql.framework.queryFactories.AbstractSelectNoParamsQueryFactory;
import tomoBay.model.sql.framework.queryTypes.select.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.queries.concreteQueries.select.noParams.SelectEbayItemsNotInTransactions;
/**
 * creates a SelectEbayItemsNotInTransactions
 * @see {@link tomoBay.model.sql.queries.concreteQueries.select.noParams.SelectEbayItemsNotInTransactions}
 * @author Jan P.C. Hanson
 *
 */
public final class SelectEbayItemsNotInTransactionsFactory implements AbstractSelectNoParamsQueryFactory
{
	/**
	 * default ctor
	 */
	public SelectEbayItemsNotInTransactionsFactory()
	{super();}
	
	/**
	 * make the query
	 * @return the query
	 */
	public AbstractSelectNoParamsQuery make()
	{return new SelectEbayItemsNotInTransactions();}
}