package model;

public class Pilot{
	
	//Attributes
	private String name;
	private int age;
	private int[] scores;
	private String team;


	enum Team{SCUDERIA_FERRARI, MCLAREN_F1_TEAM, RED_BULL_RACING, MERCEDES_AMG, RACING_POINT, ALFA_ROMERO, RENAULT, WILLIAMS};
	
	
	//Methods
	public Pilot(String name, int age, String team, int[] scores){
		this.name=name;
		this.age=age;
		this.team=team;
		this.scores=scores;
	
		
	}
	
	public int[] calculateAvearage(){
		int tot=0;
		int av=0;
		for(int i=0;i<scores.length;i++){
			tot+=scores[i];
		}
		av=tot/scores.length;
		//time calculation
		int time[] = new int [3];

		
		if(av>=360){
			int hours=(int)Math.floor(av/360);
			av-=(hours*360);
			time[0]=(int)hours;
		}
		if(av>=60){
			int mins=(int)Math.floor(av/60);
			av-=(mins*60);
			time[1]=(int)mins;
		}
		time[2]=(int)av;
		
		
		return time;
	}
	
	public String getName(){
		return name;
	}
	
	public int[] getScores(){
		return scores;
	}
	
	public void showScores(){
		for(int i=0;i<scores.length;i++){
			System.out.println(scores[i]);
		}

	}
}