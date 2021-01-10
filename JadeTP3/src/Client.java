import java.util.List;

import jade.core.Location;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Client {
	public Client() throws StaleProxyException {
		ContainerController container = new Plateforme().getAContainer();
		List<Location> itinerary= new Plateforme().getitinerary();
		Object[] params=new Object[2];
		params[0]= (ContainerController) itinerary;
		params[1]= itinerary;
		
	
		

		AgentController ac = container.createNewAgent("MA", MA.class.getName(), params) ;
		ac.start();
}
	
	
public static void main(String[] args) throws StaleProxyException { new Client(); }

}