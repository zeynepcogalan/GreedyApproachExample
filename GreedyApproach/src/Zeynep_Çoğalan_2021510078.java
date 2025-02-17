import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zeynep_Çoğalan_2021510078 {

	public static void Greedy(int[] PSalary, int[] PDemand, int n, int p, int c) {
		int total = 0;
		for(int i = 1; i <= n; i++) {
			if(PDemand[i] <= p) {
				System.out.print("|Total cost in "+i+" year "+total+ " |");
				System.out.print(" |Keep "+ 0 + " player in the squad|");
				System.out.print(" |Hire " + 0 + " caoches|");
			}
			else {
				total += (PDemand[i] - p)*c;
				System.out.print("|Total cost in "+i+" year "+total+ " |");
				System.out.print(" |Keep "+ 0 + " player in the squad|");
				System.out.print(" |Hire " + (PDemand[i] - p) + " caoches|");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		File P_Salary = new File("players_salary.txt");
		File P_Demand = new File("yearly_player_demand.txt");
		int[] PSalary = new int[10000];
		int[] PDemand = new int[10000];
		int n = 50; // year
	    int p = 5; //promote player
	    int c = 10;  //Coach price 
		int num = 0;
		
		try {
			Scanner in = new Scanner(P_Demand);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if (line != null) {
					if(num != 0) {
						String[] st = line.split("	");
						PDemand[num] = Integer.parseInt(st[1]);  
					}
					num++;
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		num = 0;
		try {
			Scanner in = new Scanner(P_Salary);
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if (line != null) {
					if(num != 0) {
						String[] st = line.split("	");
						PSalary[num] = Integer.parseInt(st[1]); 
					}
					else 
						PSalary[num] = 0;
					num++;
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Greedy(PSalary, PDemand, n, p, c);
	}

}
