package projectpidcount;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class projectpidcountreduce extends Reducer<Text,Text,Text,Text> {
	private Text word = new Text();
	String buffered_total ="Total Number of PID Count:" + " ";
	String buffer = "";
	Set<String> T = new TreeSet<String>();

	public void reduce(Text key, Iterable<Text> values, Context context ) throws IOException, InterruptedException {
		for (Text val : values) {
			T.add(val.toString());
		}
		buffer = Integer.toString(T.size());
		word.set(buffered_total);
		context.write(word, new Text(buffer));
	}
}