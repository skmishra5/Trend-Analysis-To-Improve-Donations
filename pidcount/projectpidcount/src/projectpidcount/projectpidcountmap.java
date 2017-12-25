package projectpidcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class projectpidcountmap extends Mapper<LongWritable, Text, Text, Text>  {	
	
	private Text word = new Text();
	private String pid = new String("");
	String buffered = "";
	private String line=null;
	private String[] str=null;	
	private Text word1 = new Text();
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {		
	
		line  = value.toString();
		if(line.contains("\t")) {			
				str = (value.toString()).split("\t");				//split input line by tab
				pid = str[0].toString().replaceAll("\"","");					//get anuthor name
				word.set(pid);
				buffered = "one";									//value=author
				word1.set(buffered);				
				context.write(new Text(buffered), new Text(pid));	   				
		}			
	}
	
}	
	
