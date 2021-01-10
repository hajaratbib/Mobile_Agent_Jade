import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import jade.wrapper.StaleProxyException;
import java.util.List;
import jade.core.Location;
import jade.core.MainContainer;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Iterator;
import jade.util.leap.Properties;
import jade.core.behaviours.*;
import jade.wrapper.ContainerController;



public class MA extends Agent {
	
//cycle de vie de l’agent
	protected void setup() { //au démarrage de l’agent
		System.out.println(getLocalName()+": Created");
		System.out.println("Itinerary: C0 C2 C4");
		Object[]args= getArguments();
		int step=1;
		final List<Location> itinerary= (List<Location>) args[0] ;
		final  ContainerController mainContainer= (ContainerController) itinerary.get(0);
		Location destination;
		
		try {
			AgentController agent = mainContainer.createNewAgent(
					"MA", MA.class.getName(), new Object []{itinerary}) ;
			agent.start();
		} catch (StaleProxyException e) {}
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				Iterator iterator =  (Iterator) itinerary.listIterator();
				switch (step) {
				case 1:
					destination =(Location)iterator.next();
					iterator.remove();
					step++;
					myAgent.doMove(destination); //MOVE to the first container
					break ;
				case 2:
					destination =(Location)iterator.next();
					iterator.remove();
					step++;
					myAgent.doMove(destination); //MOVE to the next container
					break ;
				case 3:
					destination =(Location)iterator.next();
					iterator.remove();
					step++;
					myAgent.doMove(destination); //MOVE to the next container
					break;
				default: 
					System.out.println("Agent "+myAgent.getLocalName()+": Bye...");
					myAgent.doDelete();
				}
			}
		});
	}

	protected void takeDown() { //à la terminaison de l’agent
		System.out.println("Agent detruit : "+getLocalName());
	}
	protected void beforeMove() { //au niveau du container de départ
		try {
			System.out.println("Agent (" +getLocalName()+") leaves : "
					+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void afterMove() { // au niveau du container d’arrivée
		try {
			System.out.println("Agent (" +getLocalName()+") arrives in : "
					+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}