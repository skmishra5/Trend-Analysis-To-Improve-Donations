package essaypreprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class preprocess {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String projID = "";
		File inpFile = new File("opendata_essays.csv");
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");

		FileReader fr = new FileReader(inpFile);
		BufferedReader br = new BufferedReader(fr);
		String s = "";
		boolean eof = false;

		// String pattern = "\".*?\",\"";
		String pattern = "\".{32}?\".*";
		String pattern1 = "\".*?\"";
		Pattern r = Pattern.compile(pattern);
		while (!eof) {
			s = br.readLine();
			if (s == null) {
				eof = true;
				break;
			}
			if (s.matches(pattern)) {
				projID = s.substring(1, 33);
//				System.out.println(" ==> Before " + s );
				s = s.replaceFirst(pattern1, "");
				s = s.replaceFirst(pattern1, "");
				s=s.replaceAll("\\p{P}", " ").toLowerCase();
//				s = s.replaceAll(pattern1, "");
//				System.out.println(" ==> REplaced " + s );
//				System.out.println("===>Print the proj ID - " + projID);
			}
			s=s.replaceAll("\\p{P}", "").toLowerCase();
			s=s.replaceAll("\\s+", " ").toLowerCase();
			s=s.replaceAll("<.*?>", " ").toLowerCase();

			if (!s.isEmpty()){
				writer.println(projID + "@--@" + s);
//				System.out.println(projID + "@--@" + s);

			}
		}
		writer.close();


	}

}