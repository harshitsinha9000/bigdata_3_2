import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Assignment32_1 {

	
	
	public static void main(String[] args) throws IOException, ParseException 
	{
		// TODO Auto-generated method stub

		if(args.length!=3)
		{
			System.out.println("Enter 1.First argument as path 2.Second as start_ts()  3.Third as end_ts");
			System.exit(1);
		}
		
		Date date1,date2,date3,date_modification;
		String date1_to_str;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Path path = new Path(args[0]);
		
		Configuration conf = new Configuration(); 
		FileSystem filesystem = FileSystem.get(path.toUri(), conf);
		FileStatus[] filestatus = filesystem.listStatus(path); 

//Assignment 1		
		for(FileStatus filestatus1:filestatus)
		{
			date_modification = new Date(filestatus1.getModificationTime());
			date1_to_str = formatter.format(date_modification);
			date1 = formatter.parse(date1_to_str);
			date2 = formatter.parse(args[1]);
			date3 = formatter.parse(args[2]);
			
			if((date1.after(date2))&&(date1.before(date3)))
				System.out.println(filestatus1.getPath());
		}
		
		
	}

}
