package projectni;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class nimap extends Mapper<LongWritable, Text, Text, Text> {
	
	private String essay =null;
	private String keys=null;
	private String pid=null;
	private String[] str=null;
	private Text wordkey=new Text();  
	private final static IntWritable one = new IntWritable(1);
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		try{
													

				str = (value.toString()).split("\t");								
				pid=str[0].toString();	  		//get line
				essay = str[1].toString().toLowerCase().replaceAll("[^a-zA-Z]"," ");  //get author name
				StringTokenizer tokenizer = new StringTokenizer(essay);

				while (tokenizer.hasMoreTokens())
				{
					String token = tokenizer.nextToken().replaceAll("[^a-zA-Z]","");
					if(token.length() != 0) {
						context.write(new Text(token), new Text(pid));
					}


				}

			

		}catch(Exception e){

		}  
	}

}