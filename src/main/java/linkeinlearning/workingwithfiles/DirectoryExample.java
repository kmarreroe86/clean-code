package linkeinlearning.workingwithfiles;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirectoryExample {

	public static void main(String[] args) {
		
		// Get the content of the specific directory
		String[] contentFolder = new File(".").list();
		
		Arrays.stream(contentFolder).forEach(System.out::println);
		
		
		// Creating directory
		new File("myDirectory").mkdir();
		
		
		// Get the filtered content of the specific directory(Onle the files)
		FilenameFilter filter = (file, fileName) -> {
			return fileName.contains(".");
		}; 
		
		System.out.println("--- Only the files ---");
		String[] onlyFilesContent = new File(".").list(filter);
		Arrays.stream(onlyFilesContent).forEach(System.out::println);

	}

}
