package projectTopStateMaxDonation;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class TopStateMaxDonationMapper extends Mapper<LongWritable, Text, Text, Text>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String[] parse = value.toString().split("\t");
		String state = null;
		if(parse[1].contains("\\"))
		{
			state = parse[1].replaceAll("\\\\", "");
		}
		else
		{
			state = parse[1];
		}
		
		context.write(new Text(state.replaceAll("\"", "")), new Text(parse[2].replaceAll("\"", "")));
	}
}
