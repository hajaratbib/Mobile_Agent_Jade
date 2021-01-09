import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Client {
	public Client() throws StaleProxyException {
		ContainerController container = new Plateforme().getAContainer();
		
		Object[] params=new Object[2]; params[0]="livre UML2"; params[1]=Double.valueOf(250.0);

		AgentController ac = container.createNewAgent("A", A.class.getName(), params) ;
		ac.start();
}
	
	
public static void main(String[] args) throws StaleProxyException { new Client(); }

}