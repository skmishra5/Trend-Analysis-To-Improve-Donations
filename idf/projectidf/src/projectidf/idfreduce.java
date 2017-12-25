package projectidf;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class idfreduce extends Reducer<Text,Text,Text,Text>{
	
	double maximum_cnt = 0;
	private DoubleWritable word = new DoubleWritable();
	private String keys=null;
	String res = null;
	public void reduce(Text key, Iterable<Text> values,	Context context ) throws IOException, InterruptedException {

		ArrayList<String> T = new ArrayList<String>(); 
		for (Text val : values) {	
			T.add(val.toString());
					}
		for(String val1 : T){
			String[] valsplit = val1.split("\t");
			double ni = Double.parseDouble(valsplit[1]);
			double N =  Double.parseDouble(valsplit[2])/ni;
			double idf = Math.log10(N) / Math.log10(2);				//cal idf
			res = valsplit[0] + "\t" + idf;
			context.write(key, new Text(res));
		}
	}
}
