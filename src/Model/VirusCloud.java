package Model;

import java.util.ArrayList;

public class VirusCloud {

	///////////////////// ATTRIBUTES /////////////////////////
	ArrayList<Virus> virusCloud;

	/* jets that are displayed on the window */
	private ListJet listJet;

	///////////////////// CONSTRUCTOR ///////////////////////
	public VirusCloud() {
		virusCloud = new ArrayList<Virus>();
		listJet = new ListJet();
	}


	///////////////////// METHODS ///////////////////////
	public void addVirus(Virus virus) { virusCloud.add(virus); }
	public void removeVirus(int i) { virusCloud.remove(i); }
	public void remove() { virusCloud.remove(virusCloud.size()-1); }

	public int getSize() { return virusCloud.size(); }

	public Virus getVirus(int i) { return virusCloud.get(i); }

	public ListJet getListJet() { return listJet; }
	
	public void addVirusCloud(VirusCloud vc) { 
		for(int i = 0; i < vc.getSize(); i++) {
			virusCloud.add(vc.getVirus(i)); 
		}
	}
}
