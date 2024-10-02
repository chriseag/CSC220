package lab13;

public class WordFisherTester {
	
	public static void main(String[] args) {
		
		WordFisher alice = new WordFisher("texts/carroll-alice.txt", "stopwords.txt");
		
		System.out.println("Alice word count: " + alice.getWordCount());
		System.out.println("Alice num unique words: " + alice.getNumUniqueWords());
		
		WordFisher moby = new WordFisher("texts/moby-dick.txt", "stopwords.txt");
		System.out.println("Moby word count: " + moby.getWordCount());
		System.out.println("Moby num unique words: " + moby.getNumUniqueWords());
		
		System.out.println("Moby whale freq: " + moby.getFrequency("whale"));
		System.out.println("Moby handkerchief freq: " + moby.getFrequency("handkerchief"));
		
		System.out.println("Alice handkerchief freq: " + alice.getFrequency("handkerchief"));
		
		moby.pruneVocabulary();
		alice.pruneVocabulary();
		
		System.out.println("Alice pruned word count: " + alice.getWordCount());
		System.out.println("Moby pruned word count: " + moby.getWordCount());
		
		System.out.println("Top word moby: " + moby.getTopWords(10));
		
		System.out.println("CommonPopWords: " + moby.commonPopularWords(20, alice));
	}
}
