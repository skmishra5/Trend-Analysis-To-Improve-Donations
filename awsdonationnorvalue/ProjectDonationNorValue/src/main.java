import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class main {
	
		
		public static void main(String[] args)throws Exception{
			Configuration conf =new Configuration();
			
			Job job=Job.getInstance(conf);
			job.setJarByClass(main.class);

		    	job.setMapperClass(DonationNorMap.class);
				job.setReducerClass(DonationNorReducer.class);          
				job.setNumReduceTasks(1);
				job.setOutputKeyClass(Text.class);
				job.setOutputValueClass(Text.class);
				job.setInputFormatClass(TextInputFormat.class);
				job.setOutputFormatClass(TextOutputFormat.class);			
				FileInputFormat.setInputPaths(job, new Path(args[0]));
				FileOutputFormat.setOutputPath(job, new Path(args[1])); 
		      
			boolean result = job.waitForCompletion(true);
			System.exit(result ? 0 : 1);
			
			
		}
}
