package simpleroute;

import org.apache.camel.impl.DefaultCamelContext;

public class Main {

	public static void main(String[] args) {

		var context = new DefaultCamelContext();

		try{
			context.addRoutes(new SimpleRoute());

			context.start();

			Thread.sleep(2000);

			context.stop();

		}catch(Exception e){
			System.out.println("Inside Exception : " + e);
		}
	}
}