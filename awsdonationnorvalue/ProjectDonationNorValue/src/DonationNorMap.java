import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class DonationNorMap extends Mapper<LongWritable, Text, Text, Text> {

	String donationAmt;
	 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
  	   String[] parse_line = value.toString().split("\t");
  	   
  	   if(!parse_line[2].contains(":")){
  		 donationAmt = parse_line[2].replaceAll("\"", "");
  	   }
 		context.write(new Text(parse_line[0].replaceAll("\"", "")), new Text(donationAmt));
  	   
  	   
     }
}
