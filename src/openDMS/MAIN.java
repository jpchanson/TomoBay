package openDMS;
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
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import openDMS.model.services.ServiceFactory;
import openDMS.model.services.ServiceScheduler;
import openDMS.model.services.TriggerService;
import openDMS.model.services.stockUpdate.PartList;
import openDMS.view.HttpServer;
/**
 * The entry point into the program
 * 
 * @author Jan P.C. Hanson
 *
 */
public class MAIN
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
		
//		ServiceScheduler services = new ServiceScheduler(2);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.TEST_SERVICE), 0, 1);
//		services.add(ServiceFactory.make(ServiceFactory.ServiceType.EBAY_SERVICE), 0, 10);
//		
//		HttpServer uiServer = new HttpServer();
//		uiServer.start(Integer.parseInt(args[0]));
//		
//		services.start();
		
		TriggerService.start(ServiceFactory.make(ServiceFactory.ServiceType.STOCK_UPDATE_SERVICE));
		
//		PartList parts = new PartList("37968(1)");
//		for(int i = 0 ; i < parts.size() ; ++i)
//		{System.out.println(parts.getPartNumber(i) + " : " + parts.getPartQty(i));}
	}
}
