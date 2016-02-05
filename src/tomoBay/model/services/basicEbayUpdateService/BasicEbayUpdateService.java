package tomoBay.model.services.basicEbayUpdateService;
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
import tomoBay.exceptions.ServiceException;
import tomoBay.model.services.AbstractConfiguration;
import tomoBay.model.services.AbstractService;
/**
 * This class represents the start of the execution flow for the eBay Service, The service 
 * quereies the eBay API for Order and Item information and 
 * @author Jan P.C. Hanson
 *
 */
public final class BasicEbayUpdateService extends AbstractService
{
	/* (non-Javadoc)
	 * @see openDMS.model.services.AbstractService#setConfig(openDMS.model.services.AbstractConfiguration)
	 */
	@Override
	public <E> void setConfig(AbstractConfiguration<E> config)
	{}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onRunning()
	 */
	@Override
	protected String onRunning() throws ServiceException
	{return new OnRunning().execute();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onPaused()
	 */
	@Override
	protected String onPaused() throws ServiceException
	{return this.onRunning();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onStopped()
	 */
	@Override
	protected String onStopped() throws ServiceException
	{return "Stopped";}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractService#onError()
	 */
	@Override
	protected String onError() throws ServiceException
	{return "Error";}
}
