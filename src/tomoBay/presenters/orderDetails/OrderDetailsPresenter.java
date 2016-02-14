package tomoBay.presenters.orderDetails;
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
import java.util.HashMap;
import java.util.Map;

import tomoBay.presenters.AbstractPresenter;
import tomoBay.presenters.presenterActions.AllowedPresenterActions;
import tomoBay.presenters.presenterActions.PresenterActionFactory;
import tomoBay.presenters.presenterActions.factories.AbstractPresenterActionFactory;
import tomoBay.presenters.presenterActions.factories.OrderInfoFactory;
import tomoBay.view.AbstractView;
import tomoBay.view.ViewFactory;
/**
 *
 * @author Jan P.C. Hanson
 *
 */
public final class OrderDetailsPresenter implements AbstractPresenter
{
	/**maps the type string to an action**/
	@SuppressWarnings("serial")
	private static final Map<String, AbstractPresenterActionFactory> actionMap_M
				= new HashMap<String, AbstractPresenterActionFactory>()
				{{
					put("OrderInfo", new OrderInfoFactory());
				}};
	
	private static final AllowedPresenterActions allowedList
				= new AllowedPresenterActions()
				{{
					add(PresenterActionFactory.PresenterActions.ORDER_INFO);
				}};
				
	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#present(tomoBay.view.AbstractView)
	 */
	@Override
	public String present(AbstractView view, String type, String data)
	{return OrderDetailsPresenter.actionMap_M.get(type).make().execute(data);}

	/* (non-Javadoc)
	 * @see tomoBay.presenters.AbstractPresenter#accept(tomoBay.view.ViewFactory)
	 */
	@Override
	public AbstractView accept(ViewFactory viewFactory)
	{return viewFactory.visit(this);}

}
