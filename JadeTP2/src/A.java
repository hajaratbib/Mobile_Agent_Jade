
import jade.core.Agent;
import jade.wrapper.ControllerException;
import jade.core.behaviours.*;

public class A extends Agent {
	protected void setup() { //au démarrage de l’agent
		//System.out.println("Agent cree : "+getLocalName());
		System.out.println("Agent "+getLocalName()+ " : créé");
		Object[]args= getArguments();
		final String livre = (String)args[0] ; 			// title en arguments
		final Double prix = (Double) args[1];
		addBehaviour(new Behaviour() {
			public boolean done() { return true; }//en fait OneShotBehaviour
			public void action() {
			 System.out.println("Agent "+ myAgent.getLocalName()+" : mission=> acheter "+ livre +" a "+ prix +" dhs"); }
			});
		addBehaviour(new TickerBehaviour(this,1000) {
			protected void onTick() {
			System.out.println("Agent "+myAgent.getLocalName()+" : cherche vendeur. tick="+getTickCount());
			}
			 });
		addBehaviour(new WakerBehaviour(this, 5000) {
			protected void onWake() {
			System.out.println("Agent "+myAgent.getLocalName()+": Bye...");
			myAgent.doDelete();
			}
			});
	}
	
	
	protected void takeDown() { //à la terminaison de l’agent
		System.out.println("Agent detruit : "+getLocalName());
	}
	
	protected void beforeMove() { //au niveau du container de départ
		try {
			System.out.println("Agent (" +getLocalName()+") part de : "+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void afterMove() { // au niveau du container d’arrivée
		try {
			System.out.println("Agent (" +getLocalName()+") arrive à : "+getContainerController().getContainerName());
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}