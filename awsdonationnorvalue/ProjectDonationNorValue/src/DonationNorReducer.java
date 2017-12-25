import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class DonationNorReducer extends Reducer<Text,Text,Text,DoubleWritable>{
	double maximum_cnt = 0;
	private DoubleWritable word = new DoubleWritable();
	public void reduce(Text key, Iterable<Text> values,	Context context ) throws IOException, InterruptedException {
	
		ArrayList<String> T = new ArrayList<String>(); 

		for (Text val : values) {
			T.add(val.toString());
			double count = Double.parseDouble(val.toString());
			if (count > maximum_cnt){
				maximum_cnt = count;				//calculate maximum of count for donation amount
			}	
		}
		for(String val : T){
		
			double NorValue = ((Double.parseDouble(val))/maximum_cnt);		
			word.set(NorValue);
			context.write(key, word);
		}
	}
}
