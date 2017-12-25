package projectStatusCompleted;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class StatusCompletedReducer extends Reducer<IntWritable, Text,Text, Text>{
	
	IntWritable word = new IntWritable();
	
	public void reduce(IntWritable key, Iterable<Text> values,
            Context context
            ) throws IOException, InterruptedException {
	
	for (Text val : values) {
		String[] valsplit = val.toString().split("\t");
		if(valsplit[5].equals("\"completed\"")){
			context.write(new Text(key.toString()), new Text(valsplit[0] + "\t" + valsplit[1] + "\t" + valsplit[2] + "\t" + valsplit[3] + "\t" + valsplit[4] + "\t" + valsplit[5]));
			}
		}
	}
}
