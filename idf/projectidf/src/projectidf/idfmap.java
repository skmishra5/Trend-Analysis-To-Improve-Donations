package projectidf;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

public class idfmap extends Mapper<LongWritable, Text, Text, Text>  {

	

	public static int pidcount=877747;
	public static int Ni;
	
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String[] parse_line = value.toString().split("\t");
		context.write(new Text(parse_line[0]), new Text(parse_line[1] + "\t" + parse_line[2] + "\t" + pidcount));  //key =word ,value=author,cnt,authcnt,Ni
	}


}