import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class URLRunner {
	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {		
		File file = new File(args[0]);
		Scanner input = new Scanner(file);
		ArrayList<String> urlStrings = new ArrayList<String>();
		ArrayList<URL> urlList = new ArrayList<URL>();
		ArrayList<URL> canonicalList = new ArrayList<URL>();
		
		while(input.hasNextLine()) {
			urlStrings.add(input.nextLine());
		}
		
		input.close();
		
		for(int i = 0; i < urlStrings.size(); i++) {
			URLModel url = new URLModel(urlStrings.get(i));
			urlList.add(url.getURL());
			canonicalList.add(url.getCanonicalized());
		}
		
		for(int i = 0; i < urlStrings.size(); i++) {
			System.out.println("Source: " + urlStrings.get(i));
			URL current = urlList.get(i);
			URL canonicalizedCurrent = canonicalList.get(i);

			if(current != null)
				System.out.println("Valid: True");
			else
				System.out.println("Valid: False");
			
			if(canonicalizedCurrent != null)
				System.out.println("Canonical: " + canonicalList.get(i).toString());
			else
				System.out.println("Invalid source URL to be canonicalized");
			
			if(current != null)
				System.out.println("Source Unique: " + isUnique(urlList, current, i));
			else
				System.out.println("Source URL is invalid to compare");
			
			if(canonicalizedCurrent != null)
				System.out.println("Canonicalized Source Unique: " + isUnique(canonicalList, canonicalizedCurrent, i));
			else
				System.out.println("Canonicalized Source URL is invalid to compare");	
			
			System.out.println("");
		}
				
	}
	
	public static boolean isUnique(ArrayList<URL> list, URL current, int index){
		for(int i = 0; i < list.size(); i++) {
			if(i == index) {
				continue;
			}
			if(current.equals(list.get(i)))
				return false;
		}
		return true;		
	}
}
