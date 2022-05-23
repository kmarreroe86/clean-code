package linkeinlearning.workingwithfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyExample {

	public static void main(String[] args) {
		
		Path source = Paths.get("C:\\Users\\kmarrero\\Desktop\\myfiles\\example.txt");
		Path destination = Paths.get("C:\\Users\\kmarrero\\Desktop\\myfiles\\Copy_example.txt");
		
		try {
//			Files.copy(source, destination);
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING); // Replace existing file with same name
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
