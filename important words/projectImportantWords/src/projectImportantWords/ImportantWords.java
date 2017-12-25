package projectImportantWords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ImportantWords {
	public static void main(String[] args) throws Exception{
		BufferedReader buf = new BufferedReader(new FileReader(args[0]));
		ArrayList L = new ArrayList();
		String readline;
		File file = new File("ImportantWords.txt");
		while ((readline = buf.readLine())!= null) 
		{
			L.add(readline);
		}

		int reverse = L.size()-2001;
		int j = L.size() -1;
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
			
		while(j > reverse){
			bw.write(L.get(j).toString());
			bw.write("\n");
			j--;
		}
		bw.close();
	}
}
