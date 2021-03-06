package tomoBay.model.services.reScanBuyerService;

import tomoBay.model.services.AbstractConfiguration;
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
public final class ReScanBuyerServiceConfig implements AbstractConfiguration<String>
{
	private String buyerID_M;

	/**
	 * default ctor
	 */
	public ReScanBuyerServiceConfig()
	{super();}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractConfiguration#configure(java.lang.Object)
	 */
	@Override
	public AbstractConfiguration<String> configure(String value)
	{
		this.buyerID_M = value;
		return this;
	}

	/* (non-Javadoc)
	 * @see tomoBay.model.services.AbstractConfiguration#configure()
	 */
	@Override
	public String configure()
	{return this.buyerID_M;}

}
