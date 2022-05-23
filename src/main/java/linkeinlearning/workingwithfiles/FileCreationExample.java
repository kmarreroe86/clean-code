package linkeinlearning.workingwithfiles;

import java.io.File;
import java.io.IOException;

public class FileCreationExample {

	public static void main(String[] args) {
		
		File newFile = new File("C:\\Users\\kmarrero\\Desktop\\myfiles\\myfiel.txt");
		try {
			boolean fileCreated = newFile.createNewFile();
			System.out.println(fileCreated);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
