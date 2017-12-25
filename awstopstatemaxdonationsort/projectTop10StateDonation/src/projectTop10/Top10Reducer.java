package projectTop10;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class Top10Reducer extends Reducer<IntWritable,Text,Text,Text>{
	Text token = new Text();	
	public void reduce(IntWritable key, Iterable<Text> values,Context context) throws IOException, InterruptedException {

		for(Text val : values){
			token.set(val.toString());
		}
		context.write(new Text(key.toString()), new Text(token));
	}
}
