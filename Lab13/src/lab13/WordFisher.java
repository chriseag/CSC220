package lab13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class WordFisher {

	// Please note these variables. they are the state of the object.
	public HashMap<String, Integer> vocabulary;
	public List<String> stopwords; // User ArrayList for initialization
	private String inputTextFile;
	private String stopwordsFile;

	WordFisher(String inputTextFile, String stopwordsFile) {
		this.inputTextFile = inputTextFile;
		this.stopwordsFile = stopwordsFile;

		buildVocabulary();
		getStopwords();
	}

	public void buildVocabulary() {
		
		
		vocabulary = new HashMap<String, Integer>();
		
		try {
			String reader = new String(Files.readAllBytes(Paths.get(inputTextFile))).replaceAll("[^a-zA-Z0-9 ]", "");
			String[] allWords = reader.split("\\s+");
				for(int i = 0; i < allWords.length; i++) {
					allWords[i] = allWords[i].toLowerCase();
				}
				for(int i = 0; i < allWords.length; i++) {
					if(!vocabulary.containsKey(allWords[i])) {
						vocabulary.put(allWords[i], 1);
					}
					else if(vocabulary.containsKey(allWords[i])) {
						int temp = vocabulary.get(allWords[i]);
						vocabulary.put(allWords[i], ++temp);
					}
				}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		
		
		// TODO: load in each word from inputTextFile into the vocabulary.
		// By the end of this method, vocabulary should map each word to the number of
		// times it occurs in inputTextFile.
		// Therefore, as you iterate over words, increase the value that the word maps
		// to in vocabulary by 1.
		// If it's not in the vocabulary, then add it with an occurrence of 1.
		// Use getStopwords as an example of reading from files.

	}

	public void getStopwords() {
		stopwords = new ArrayList<String>();
		String word;

		try {
			BufferedReader input = new BufferedReader(new FileReader(stopwordsFile));
			while ((word = input.readLine()) != null) {
				stopwords.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getWordCount() {
		
		int count = 0;
		
		for(Entry<String, Integer> object : vocabulary.entrySet()) {
			count += object.getValue();
		}
		
		return count;
		
		
		// TODO: Return the total number of words in inputTextFile.
		// This can be calculated using vocabulary.

	}

	public int getNumUniqueWords() {
		// TODO: Return the number of unique words.
		// This should be the same as the number of keys in vocabulary.
		
		
		return vocabulary.size();
		
		
	}

	public int getFrequency(String word) {
		if(vocabulary.containsKey(word)){
			// TODO: Return the number of times word occurs. 
			// (Should be one simple line of code.)
			// Think about what vocabulary stores.
			
			return vocabulary.get(word);
			
		}
		
		return -1;
	}

	public void pruneVocabulary() {
		// TODO: remove stopwords from the vocabulary.
		
			for(String stop : stopwords) {
				if(vocabulary.containsKey(stop)) {
					vocabulary.remove(stop);
				}
			}
		}
	
	public static class WordNode {
		public String word;
		public int frequency;
		
		public WordNode(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}
	}
	
	
	public static class WordComparator implements Comparator<WordNode>{
		public int compare(WordNode w1, WordNode w2) {
			return w2.frequency - w1.frequency;
		}
	}
	
	
	public ArrayList<String> getTopWords(int n) {
		ArrayList<String> topWords = new ArrayList<String>();
		
		// TODO: get the top n words.
		
		
		PriorityQueue<WordNode> pq = new PriorityQueue <> (new WordComparator());
		
		for(HashMap.Entry<String, Integer> word : vocabulary.entrySet()) {
			WordNode wn = new WordNode(word.getKey(), word.getValue());
			pq.add(wn);
		}
		
		for (int i = 0; i < n; i++) {
			WordNode wn = pq.poll();
			topWords.add(wn.word);
		}
		
		return topWords;
	}

	public ArrayList<String> commonPopularWords(int n, WordFisher other) {
		ArrayList<String> commonPopWords = new ArrayList<String>();
		
		// TODO: get the common popular words.
		
		ArrayList<String> topWords1 = this.getTopWords(n);
		ArrayList<String> topWords2 = other.getTopWords(n);
		
		
		for(String tw1 : topWords1) {
			for(String tw2 : topWords2) {
				if(tw1.equals(tw2)) {
					commonPopWords.add(tw1);
				}
			}
			
		}

		
		return commonPopWords;
	}

}
