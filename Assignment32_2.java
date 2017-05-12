

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Assignment32_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if(args.length!=1)
		{
			System.out.println("Enter one argument");
			System.exit(1);
		}
		
		Configuration conf = new Configuration();
		Path path = new Path(args[0]);
		FileSystem file =  FileSystem.get(path.toUri(),conf);
		FSDataInputStream in = file.open(path); 
		BufferedReader d= new BufferedReader(new InputStreamReader(in));
		int i ;
		
		while((i= d.read())!=-1)
		{
		System.out.print((char)i);
		}
		
	}

}
