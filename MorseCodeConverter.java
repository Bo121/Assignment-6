import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (กฎ กฎ). 
	 * Each word is delimited by a กฎ/กฏ.
	 * @param code the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		
		MorseCodeTree morse = new MorseCodeTree();
		String str = code;
		String English = "";
	
		String[] tokens = str.split(" ");
		for(int i = 0; i<tokens.length; i++) {
			if(tokens[i].equals("/"))
				English += " ";
			else
				English += morse.fetch(tokens[i]);
		}

		return English;	
	}
	
	/**
	 * Converts a file of Morse code into English Each letter 
	 * is delimited by a space (กฎ กฎ).Each word is delimited by a กฎ/กฏ.
	 * @param codefile name of the File that contains Morse Code
	 * @return
	 */
	public static String convertToEnglish(File codefile) throws FileNotFoundException{
		
		MorseCodeTree morse = new MorseCodeTree();
		String English = "";
		String code = "";
		
		try {
			Scanner reader = new Scanner(codefile);
			while(reader.hasNext()) {
				code = reader.nextLine();
			}
			reader.close();
			
			String[] tokens = code.split(" ");
			for(int i = 0; i<tokens.length; i++) {
				if(tokens[i].equals("/"))
					English += " ";
				else
					English += morse.fetch(tokens[i]);
			}
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			
		}
		
		return English;
	}
	
	/**
	 * Returns a string with all the data in the tree in LNR order with
	 * an space in between them.
	 * @return the English translation of the file
	 */
	public static String printTree() {
		
		MorseCodeTree morse = new MorseCodeTree();
		ArrayList<String> tree = new ArrayList<>();
        tree = morse.toArrayList();  
        String data = "";
        
        for(int i=0; i < tree.size(); i++){
        	if(i == tree.size()-1)
        		data += tree.get(i);    
        	else
        		data += tree.get(i) + " ";   
        }
        
        return data;
	}

}
