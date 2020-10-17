package ui;

import model.Championship;
import java.util.Scanner;

public class Main{
	public static Scanner sc =new Scanner(System.in);
	
	public static void main (String[] args) {
		//Atributes
			
	boolean stop=false;
	int countPilots=0;
	String answer="";
		
	Championship championship1= registerChampionship();
	
	

	while(!stop &&countPilots<15){
		
		if(countPilots==0){
			System.out.println("Would you like to register a pilot? yes or not");
			answer=sc.nextLine();
			if(answer.equalsIgnoreCase("yes")){
				registerPilot(championship1);
				countPilots++;
			}else{
				stop=true;
			}
		}else{
			System.out.println("Would you like to register another pilot? yes or not");
			answer=sc.nextLine();
			if(answer.equalsIgnoreCase("yes")){
				registerPilot(championship1);
				countPilots++;
				if(countPilots==14){
					stop=true;
					System.out.println("You cannot register more pilots");
				}
			}else if(answer.equalsIgnoreCase("not")){
				stop=true;
			}
		}
		
		
	}
			
			showAvTime(championship1);
		
	
	
	}//end main
	
	public static Championship registerChampionship(){
		System.out.println("Type the year of the championship");
		int year=sc.nextInt();
		sc.nextLine();
		System.out.println("Type the amount of races in this championship");
		int races=sc.nextInt();
		sc.nextLine();
		
		Championship championshipx= new Championship(year, races);
		return championshipx;
	}//end Championship
	
	public static void registerPilot(Championship championshipx){
		int scores[]= new int[championshipx.getRaces()];
		
		System.out.println("Type the full name of the pilot");
		String name=sc.nextLine();
		System.out.println("Type the age of the pilot");
		int age=sc.nextInt(); sc.nextLine();
		System.out.println("Type the team the pilot belongs to");
		String team=sc.nextLine();
		
		for(int i=0;i<championshipx.getRaces();i++){
			System.out.println("Type the score on the race "+(i+1));
			scores[i]=sc.nextInt(); sc.nextLine();
		}
		championshipx.addPilot(name, age, team, scores);	
	}// end registerPilot
	
	public static void findPilot(Championship championshipx){
		System.out.println("Type the full name of the pilot you are looking for");
		String name=sc.nextLine();
		
		championshipx.findPilot(name);
	}
	
	public static void showAvTime(Championship championshipx){
		String messagex;
		
		System.out.println("------------------------------------------------------- \n");
		System.out.println("RESULTS:");
		for(int i=0;i<15;i++){
			messagex=championshipx.showAvearageTime(i);
			System.out.println(messagex);	
		}

	}
	
	
}