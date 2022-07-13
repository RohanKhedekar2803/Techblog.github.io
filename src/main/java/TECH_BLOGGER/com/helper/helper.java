package TECH_BLOGGER.com.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public  class helper {
	public static boolean flag=false;    
    static boolean flag1=false;
    public static boolean  saveFile(InputStream is,String path) {
    	try {
//			input stream will read data from give location and is.read(b) is function to read from source and store in b
    		byte b[]=new byte[is.available()];
    		is.read(b);
//    		created object of fileoutput stream which is used to write in file;
    		FileOutputStream fos =new FileOutputStream(path);
    		fos.write(b);
    		fos.flush();
    		fos.close();
    		flag1=true;
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return flag1;
    }
	public static boolean deleteFile(String path) {
		try {
//			create object of file
    		File file =new File(path);
    		flag=file.delete();
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

}
