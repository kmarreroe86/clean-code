package linkeinlearning.workingwithfiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PathClassTest {

    public void processFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("example.txt").getFile());

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println(file.getAbsolutePath());
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\kmarrero\\Desktop\\myfiles\\myfiel.txt");

        try {
            boolean deleted = Files.deleteIfExists(path);
            System.out.println(deleted);
        } catch (IOException e) {
        }

        Path path2 = Paths.get("C:\\Users\\kmarrero\\Desktop\\myfiles\\example.txt");
        System.out.println(path2.getParent());
        System.out.println(path2.getRoot());
        System.out.println(path2.getFileName());

        PathClassTest obj = new PathClassTest();
        obj.testPropertiesFile();
    }

    public void testPropertiesFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        FileReader fileReader = null;

        fileReader = new FileReader(classLoader.getResource("file.properties").getFile());

        Properties properties = new Properties();
        properties.load(fileReader);
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
        fileReader.close();
    }

}
