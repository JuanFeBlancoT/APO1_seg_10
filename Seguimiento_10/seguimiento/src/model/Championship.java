package model;

	//public final int MAX_PILOTS=15;
	
public class Championship{
	
	//Attributes
	private int year;
	private int races;
	
	//Relations
	public Pilot[] pilots;
	
	
	

	
	
	
	//Methods
	public Championship(int year, int races){
		this.year=year;
		this.races=races;
		pilots=new Pilot[15];
		
		for(int i=0;i<pilots.length;i++){
			pilots[i]=null;
		}
	}
	
	public void addPilot(String name, int age, String team, double[] scores){
		boolean stop=false;
		
		for(int i=0;i<pilots.length && !stop;i++){
			if(pilots[i]==null){
				stop=true;
				pilots[i]=new Pilot(name, age, team, scores);
			}
		}
	}//end addPilot
	
	public boolean findPilot(String name){
		boolean found=false;
		
		for(int i=0;i<pilots.length && !found;i++){
			if(pilots[i]!=null && name.equalsIgnoreCase(pilots[i].getName())){
				found=true;
			}
		}
		return found;
	}
	public String showAvearageTime(int i){
		int avearage[]=new int[3];
		String message="";
		String name="";

			if(pilots[i]!=null){
				avearage=pilots[i].calculateAvearage();
				name=pilots[i].getName();
				message="The avearage score of "+ name + ", is: "+ avearage[0]+":"+avearage[1]+":"+avearage[2];
			}else{
				message="";	
			}
			
		
		
		return message;
	}		
	
	
	public int getRaces(){
		return races;
	}

}