import jade.core.Agent;
import jade.wrapper.ControllerException;
public class A extends Agent {
//cycle de vie de l�agent
protected void setup() { //au d�marrage de l�agent
System.out.println("Agent cree : "+getLocalName());
}
protected void takeDown() { //� la terminaison de l�agent
System.out.println("Agent detruit : "+getLocalName());
}
protected void beforeMove() { //au niveau du container de d�part
try {
	System.out.println("Agent (" +getLocalName()+") part de : "
	+getContainerController().getContainerName());
} catch (ControllerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
protected void afterMove() { // au niveau du container d�arriv�e
try {
	System.out.println("Agent (" +getLocalName()+") arrive � : "
	+getContainerController().getContainerName());
} catch (ControllerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}