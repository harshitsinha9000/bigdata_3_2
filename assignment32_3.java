import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class assignment32_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if(args.length!=2)
		{
			System.out.println("Enter one argument");
			System.exit(1);
		}
		
		Configuration conf = new Configuration();
		Path path_in = new Path(args[0]);
		Path path_out = new Path(args[1]);
		FileSystem file_in =  FileSystem.get(path_in.toUri(),conf);
		FSDataInputStream in = file_in.open(path_in);
		
		FileSystem file_out =  FileSystem.get(path_out.toUri(),conf);
		FSDataOutputStream out = file_out.create(path_out);
		
		BufferedReader d= new BufferedReader(new InputStreamReader(in));
		int i ;
		
		while((i= d.read())!=-1)
		{
		out.write((char)i);
		}
		
		
	}

}
