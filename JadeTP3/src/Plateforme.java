
import java.util.List;

import jade.core.Location;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.ContainerController;


public class Plateforme {
	public ContainerController mainContainer,C0,C1,C2,C3,C4,C5;
	public  List<Location> locations;
	public List<Location> itinerary;
	public Plateforme() {
			Runtime rt = Runtime.instance(); //Créer une instance de la MV
			Properties p = new ExtendedProperties(); //fixer quelques propriétés
			p.setProperty("gui", "true"); //… le –gui entre autres
			ProfileImpl profile = new ProfileImpl(p);
			mainContainer = rt.createMainContainer(profile);
			profile = new ProfileImpl(false); // Ce n’est pas un main-container.
			// Associé au main-container démarré sur localhost
			profile.setParameter(ProfileImpl.MAIN_HOST, "localhost");
			C0 = rt.createAgentContainer(profile);
			C1 = rt.createAgentContainer(profile);
			C2 = rt.createAgentContainer(profile);
			C3 = rt.createAgentContainer(profile);
			C4 = rt.createAgentContainer(profile);
			C5 = rt.createAgentContainer(profile);
			locations.add((Location) C0);
			locations.add((Location) C1);
			locations.add((Location) C2);
			locations.add((Location) C3);
			locations.add((Location) C4);
			locations.add((Location) C5);
			itinerary.add((Location) C0);
			itinerary.add((Location) C2);
			itinerary.add((Location) C4);
		}
	public ContainerController getMainContainer(){ return mainContainer;}
	public ContainerController getAContainer(){ return (ContainerController) C0;}
	public List<Location> getitinerary(){return itinerary;}
	
	
}
