import java.io.File;
import java.util.Scanner;

public class ReadFile {
	//takes a file string and returns an array with its contents
	public static String[] readFile(String file){
		Scanner fileInput;
		String[] resultArray = new String[100]; //first array has size of 100 which should be larger enough to hold any file
		
		try{
			fileInput = new Scanner(new File(file));
			int count = 0;
			while(fileInput.hasNext()){
				String currentWord = fileInput.next().trim();
				resultArray[count] = currentWord; //adds the current string to the array
				count++;
			}
			fileInput.close();
		}catch(Exception e){
			System.out.println("file not found"); //catches any invalid files
		}
		int i;
		for(i = 0;resultArray[i] != null;i++); //i is incremented until null value is hit to find the actual size of the array
		
		String[] newArray = new String[i];  //new array is made which will cut out all the null values that were not populated
		
		for(int j = 0;j<newArray.length;j++) //new array is populated with old array values excluding left over null values
			newArray[j] = resultArray[j];
		
		return newArray;	
	}
	//returning new Array. it should either be empty or populated
}
