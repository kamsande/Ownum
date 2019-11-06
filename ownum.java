package ownum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ownum {

	public static void main (String[] args) {
		
		String filename = "passage.txt";
		ReadFile(filename);
		
		
	}
	
	public static void ReadFile(String filePath) {
	
		
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> numWordsUsed = new ArrayList<Integer>();
		
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader bReader = new BufferedReader(fr);
			String line;
			int wordCount = 0;
			int highestCount = 0; 
			String mostUsed = " ";
			
			while ((line = bReader.readLine() )!= null) {
				String delims = "[ ]+";
								String[] fileWords = line.split(delims);
				
				wordCount = wordCount + fileWords.length;
				
				for(int i = 0; i < fileWords.length; i++) {
					if(words.contains(fileWords[i])) {
						int index = words.indexOf(fileWords[i]);
						int newCount = numWordsUsed.get(words.indexOf(fileWords[i])) + 1;
						numWordsUsed.set(index, newCount);
						
						
						if (numWordsUsed.get(index) < highestCount) 
						{
							mostUsed.replaceAll(mostUsed, line);
							highestCount = numWordsUsed.get(index);
							
						}
					}
					
				}
			}
			
			int x = highestCount;
			ArrayList<String> topTenWords = new ArrayList<String>();
			
			for (int j = 0; j < words.size(); ++j) {
				if (topTenWords.size() != 10 && numWordsUsed.get(j) == x) {
					topTenWords.add(words.get(j));
				}
				if (topTenWords.size() == 10) {
					break;
				}
				--x;
			}
			
			bReader.close();
			Collections.sort(topTenWords);
			
			System.out.println("Total word count: " + wordCount);
			System.out.println("Top ten words used: ");
			
			for (int i = 0; i < 10; ++i) {
				System.out.println(topTenWords.get(i));
			}
			
			System.out.println("Last line containing most used word: " + mostUsed);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
