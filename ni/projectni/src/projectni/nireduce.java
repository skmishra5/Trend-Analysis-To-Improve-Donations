package projectni;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class nireduce extends Reducer<Text,Text,Text,IntWritable> {
//	private IntWritable word = new IntWritable();
	String s="";
	private Text word = new Text();
	private String keys=null;
	private String pid=null;
	public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
		int sum=0;
		Set<String> T = new TreeSet<String>();

		for (Text val : values) {
			T.add(val.toString());
			sum +=1;
		}
		for(String val : T){
			String[] valsplit = val.split("\t");
			pid=valsplit[0].replaceAll("\"","");
		//word.set(sum);  			//calculate sum of values from mapper
		keys = pid + "\t" + key;
		}
		context.write(new Text(keys), new IntWritable (T.size()));
	}
}


