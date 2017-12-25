package projectTop10;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class Top10Mapper extends Mapper<LongWritable, Text, IntWritable, Text>{
	
	IntWritable word = new IntWritable();
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		
		String[] line = value.toString().split("\t");
		
		String donTotal = line[1];
		word.set(Integer.parseInt(donTotal));
		
		context.write(word, new Text(line[0]));
	}
}
