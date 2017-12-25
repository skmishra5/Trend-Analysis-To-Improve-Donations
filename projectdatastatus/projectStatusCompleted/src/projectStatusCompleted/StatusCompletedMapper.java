package projectStatusCompleted;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class StatusCompletedMapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	
	IntWritable word = new IntWritable();
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String[] parse = value.toString().split("\t");	
		
		String don = parse[6].replaceAll("\"", "");
		word.set(Integer.parseInt(don));
		
		context.write(word, new Text(parse[0] + "\t" + parse[1] + "\t" + parse[2] + "\t" + parse[3] + "\t" + parse[4] + "\t" + parse[5]));
	}
}
