package projectTopStateMaxDonation;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class TopStateMaxDonationReducer extends Reducer<Text, Text,Text, Text>{
	
	
	IntWritable word = new IntWritable();
	
	public void reduce(Text key, Iterable<Text> values,
            Context context
            ) throws IOException, InterruptedException {
		int sum = 0;
		
		for (Text val : values) {
			sum = sum + 1;
		}
		//word.set(sum);
		context.write(key, new Text(String.valueOf(sum)));
	}
}
