package tomoBay.helpers;
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
import java.util.ArrayList;
import java.util.List;

import tomoBay.model.dataTypes.heteroTypeContainer.ClassRef;
import tomoBay.model.dataTypes.heteroTypeContainer.HeteroFieldContainer;
import tomoBay.model.sql.schema.ordersTable.OrdersTable;
import tomoBay.presenters.helpers.pickeability.PickeableStatus;
/**
 * This class contains functionality for performing a category based sorting algorithm first 
 * ordering the data passed in by shipping type and the now sorted data by Pickeability. this 
 * leads to data that is first displayed by pickeability then within each pickability type it 
 * is then sorted by shipping type.
 * 
 * each element of the list passed should be of the form:
 * [orderID, buyerID, salesRecNo, shippingType, createdTime, picked, packed, shipped, invoiced]
 * 
 * @see {@link tomoBay.helpers.ShippingPriority}
 * @author Jan P.C. Hanson
 *
 */
public class SortOrders
{
	/**
	 * default ctor
	 */
	public SortOrders()
	{super();}
	
	/**
	 * sort an input list of Strings i.e. the results of an eBay orders query, by shipping type
	 * and then by date.
	 * @param rows
	 * @return sorted list of strings.
	 */
	public List<HeteroFieldContainer> sortDefault(List<HeteroFieldContainer> rows)
	{return this.sortByPickeability(this.sortByShipping(rows));}
	
	/**
	 * sort the list<String> by Invoice status descending (see InvoiceableStatus enum)
	 * @param input list of strings unordered
	 * @return List<String> sorted by date descending
	 */
	private List<HeteroFieldContainer> sortByPickeability(List<HeteroFieldContainer> input)
	{
		List<List<HeteroFieldContainer>> categoryList = new ArrayList<List<HeteroFieldContainer>>(PickeableStatus.size());
		
		for(int i = 0 ; i < PickeableStatus.size() ; ++i) {categoryList.add(new ArrayList<HeteroFieldContainer>());}
		
		for (int i = 0 ; i < input.size() ; ++i)
		{
			categoryList.get(input.get(i).get(OrdersTable.INVOICED, ClassRef.INTEGER))
						.add(input.get(i));
		}
		return reAssembleCategories(categoryList, PickeableStatus.size());
	}
	
	/**
	 * sort the List<String> by shipping type descending (see ShippingPriority enum)
	 * @param input list of strings sorted by date descending.
	 * @return List<String> sorted by ShippingPriority then date
	 */
	private List<HeteroFieldContainer> sortByShipping(List<HeteroFieldContainer> input)
	{
		List<List<HeteroFieldContainer>> categoryList = new ArrayList<List<HeteroFieldContainer>>(ShippingPriority.size());
		
		for(int i = 0 ; i < ShippingPriority.size() ; ++i) {categoryList.add(new ArrayList<HeteroFieldContainer>());}
		
		for (int i = 0 ; i < input.size() ; ++i)
		{
			categoryList.get( ShippingPriority.valueOf(input.get(i).get(OrdersTable.SHIPPING_TYPE, ClassRef.STRING)).getPriority() )
						.add(input.get(i));
		}
		return reAssembleCategories(categoryList, ShippingPriority.size());
	}
	
	/**
	 * reassemble the categories into one list
	 * @param input List<List<String[]>>  the list of catagories
	 * @param size the size of the shipping priority enum
	 * @return category sorted list of strings with previous sort order preserved
	 */
	private List<HeteroFieldContainer> reAssembleCategories(List<List<HeteroFieldContainer>> input, int size)
	{
		List<HeteroFieldContainer> result = new ArrayList<HeteroFieldContainer>();
		
		for (int i = 0 ; i < size ; ++i)
		{
			result.addAll(input.get(i));
		}
		return result;
	}
}
