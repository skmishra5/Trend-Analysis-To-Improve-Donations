package donationdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class donationmap extends Mapper<Text, Text, Text, Text> {
	
	//private final static IntWritable word = new IntWritable(1);
	private Text word = new Text();
	StringBuffer sb=new StringBuffer();
	private String line=null;
	private String pid=null;
	private String state=null;
	private String donationAmt=null;
	private String values=null;
	private String[] str=null;
	 private Text key = new Text();
		private String token, delimiter = " `<>+.!,?;:_()[]$-@~/*#&\"0123456789''%= ";
		 public void map(Text key, Text value, Context context) throws IOException,   InterruptedException {
				try{ 
			 String line = key.toString();
			 line.trim();
			 if(line.startsWith("\""))
			 {
				str = (line.toString()).split(",");
				pid=str[1].toString();
				if(str[5].toString().length() < 4)
				{
					str[5].toString().replaceAll("\"\"", "");
					state = "\"NA\"";
				}
				else{
					state=str[5].toString();
				}
				donationAmt=str[11].toString();
			 }		
			 
			  //value is returned as NULL. Hence will parse the Key to read value
		//	  StringTokenizer tokenizer = new StringTokenizer(line,",");
			//  pid=str[0].toString().toLowerCase().replaceAll("[^a-zA-Z]"," ");
			 // String strKey = tokenizer.nextToken();
			//  String strkey="";
			//  key.set(pid);
			 values= state + "\t" + donationAmt;
			  word.set(values);
			  context.write(new Text(pid), word);
			 
				
			}catch(Exception e){

			}  
		 }
			
	
}

