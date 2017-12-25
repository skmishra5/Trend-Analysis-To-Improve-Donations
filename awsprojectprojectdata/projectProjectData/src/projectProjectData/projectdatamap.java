package projectProjectData;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class projectdatamap extends Mapper<Text, Text, Text, Text> {
	
	//private final static IntWritable word = new IntWritable(1);
	private Text word = new Text();
	StringBuffer sb=new StringBuffer();
	private String line=null;
	private String pid=null;
	private String state=null;
	private String sch_id=null;
	private String values=null;
	private String[] str=null;
	private String donation=null;
	private String primary_focus=null;private String secondary_focus=null;
	private String status=null;
	 private Text key = new Text();
		private String token, delimiter = " `<>+.!,?;:_()[]$-@~/*#&\"0123456789''%= ";
		 public void map(Text key, Text value, Context context) throws IOException,   InterruptedException {
				try{ 
			 String line = key.toString();
			 line.trim();
			 if(line.startsWith("\""))
			 {
				str = (line.toString()).split(",");
				pid=str[0].toString();
				sch_id=str[2].toString();
				
				if(str[7].toString().length() < 4)
				{
					str[7].toString().replaceAll("\"\"", "");
					state = "\"NA\"";
				}
				else{
					state=str[7].toString();
				}
				primary_focus=str[22].toString();
				

				if(str[24].toString().length() < 3)
				{
					str[24].toString().replaceAll("\"\"", "");
					secondary_focus = "\"NA\"";
				}
				else{
					secondary_focus=str[24].toString();
				}
				
			
				status=str[39].toString();
				donation=str[35].toString();
				
			 }		
			 
			  //value is returned as NULL. Hence will parse the Key to read value
		//	  StringTokenizer tokenizer = new StringTokenizer(line,",");
			//  pid=str[0].toString().toLowerCase().replaceAll("[^a-zA-Z]"," ");
			 // String strKey = tokenizer.nextToken();
			//  String strkey="";
			//  key.set(pid);
			 values= sch_id +"\t"+state+"\t"+ primary_focus+ "\t"+secondary_focus +"\t"+status+"\t"+donation;
			  word.set(values);
			  context.write(new Text(pid), word);
			 
				
			}catch(Exception e){

			}  
		 }
			
	
}

