package tomoBay.model.sql.queries.factories.select.noParams;

import tomoBay.model.sql.queries.AbstractSelectNoParamsQuery;
import tomoBay.model.sql.queries.AbstractSelectNoParamsQueryFactory;
import tomoBay.model.sql.queries.concreteQueries.select.noParams.SelectInvoicedOrders;

/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class SelectInvoicedOrdersFactory implements AbstractSelectNoParamsQueryFactory
{

	/* (non-Javadoc)
	 * @see tomoBay.model.sql.queries.AbstractQueryFactory#make()
	 */
	@Override
	public AbstractSelectNoParamsQuery make()
	{
		return new SelectInvoicedOrders();
	}

}
