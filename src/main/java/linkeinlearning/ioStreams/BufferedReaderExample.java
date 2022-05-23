package linkeinlearning.ioStreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) {
		
		BufferedReaderExample obj = new BufferedReaderExample();
		obj.readFile();
	}
	
	public void readFile() {

		//Get the file inside resources folder 
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("example.txt").getFile());
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
			
		} catch (IOException e) {
			System.out.println(file.getAbsolutePath());
			e.printStackTrace();
		}
	}

}
