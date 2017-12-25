package donationdata;


import java.io.IOException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;



public class donationreduce extends Reducer<Text,Text,Text,Text> {


	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{

		for (Text val : values) {
			context.write(key, val);

		}
	}
}

