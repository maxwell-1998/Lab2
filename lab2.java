//Maxwell Sylvestre 

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class lab2 {

	public static void main(String[] args) throws Exception {
		final int MAX = 1000;
		String artists[] = new String[MAX];
		int Count[] = new int[MAX];
		String line="";
		int Index=0;      
		int totalSong=0;
		//read data from a file
		Scanner sc  = new Scanner(new File("viral-us-daily-latest.txt")); 
		PrintWriter outputFile = new PrintWriter("Lab2Output.txt");

		while(sc.hasNextLine()){
			line = sc.nextLine();
			String columns[] = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");              
			String temp = columns[2];
			
			// this will remove quotes from the line
			temp = temp.replaceAll("\"", "");
			for(String pos : temp.split(",")){
				boolean found = false;
				for(int i=0;i<Index;i++){
					if(pos.equalsIgnoreCase(artists[i])){
						Count[i]++;
						found = true;
						break;
					}
				}
				if(!found){
					artists[Index] = pos;
					Count[Index]=1;
					Index++;
				}
			}
			totalSong++;
		}

		outputFile.println("Total songs  : "+totalSong);
		outputFile.println("Total artists : "+Index);
		outputFile.printf("%-19s%s\n","Artists","count");
		for(int i=0;i<Index;i++){
			outputFile.printf("%-21s%s\n",artists[i],Count[i]);
		}
		sc.close();
		outputFile.close();
	}

}
