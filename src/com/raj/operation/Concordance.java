package com.raj.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import com.raj.model.ConcordanceModel;
import com.raj.util.StringUtil;

public class Concordance {
	private static final String SAMPLE_STRING = "Given an arbitrary text document written in English, write a program that will generate a concordance, i.e. an alphabetical list of all word occurrences, labeled with word frequencies. Bonus: label each word with the sentence numbers in which each occurrence appeared.";
	private static final String LINE_SEPARATOR_PATTERN = "[.!?]\\s{1,2}(?=[A-Z0-9])";
	private static final String WORD_SEPARATOR_PATTERN = "[-!,~:\\s]+";
	

	public static void main(String[] args) {
		Concordance concordance = new Concordance();		

		String[] lineArray = StringUtil.getStringArrayForPattern(SAMPLE_STRING, LINE_SEPARATOR_PATTERN);
		List<String> lineList= (List<String>) Arrays.asList(lineArray);

		String[] wordArray = StringUtil.getStringArrayForPattern(SAMPLE_STRING, WORD_SEPARATOR_PATTERN);
		StringUtil.replaceTrailingDot(wordArray);
		SortedSet<String> sortedWordSet = new TreeSet<String>(Arrays.asList(wordArray));

		List<ConcordanceModel> concordanceModelList = concordance.getConcordanceModels(lineList,sortedWordSet);

		displayOutput(concordanceModelList);
	}

	private static void displayOutput(List<ConcordanceModel> concordanceModelList) {
		for (int i=0;i<concordanceModelList.size();i++) {
			ConcordanceModel concordanceModel = concordanceModelList.get(i);
			System.out.print(concordanceModel.getSequnceNumber());
			for(int j=0;j<5-concordanceModel.getSequnceNumber().length();j++)
				System.out.print(" ");
			System.out.print(concordanceModel.getWord());
			for(int k=0;k<30-(concordanceModel.getWord().length() + concordanceModel.getSequnceNumber().length());k++)
				System.out.print(" ");
			System.out.println("{" + concordanceModel.getTotalOccurences() + ":" + concordanceModel.getLineNumbers() + "}");

		}

	}

	private List<ConcordanceModel> getConcordanceModels(List<String> lineList, SortedSet<String> sortedWordSet) {
		List<ConcordanceModel> concordanceModelList = new ArrayList<ConcordanceModel>();



		Iterator<String> sortedStringIterator = sortedWordSet.iterator();
		int sequenceNumber=1;
		while(sortedStringIterator.hasNext())
		{
			ConcordanceModel concordanceModel = new ConcordanceModel();
			String word = sortedStringIterator.next();
			concordanceModel.setSequnceNumber(sequenceNumber);
			concordanceModel.setWord(word);

			for(int i=0; i<lineList.size();i++) {
				int numberOfOccurences = getNumberOfOccurencesForLine(lineList.get(i),word);
				concordanceModel.setTotalOccurences(numberOfOccurences);
				setLineNumbersForWord(i+1,numberOfOccurences,concordanceModel);			
			}

			concordanceModelList.add(concordanceModel);
			sequenceNumber++;
		}
		return concordanceModelList;
	}

	private void setLineNumbersForWord(int lineNumber, int numberOfOccurences, ConcordanceModel concordanceModel) {
		for(int i=0;i<numberOfOccurences;i++)
			concordanceModel.setLineNumbers(lineNumber);		
	}

	private int getNumberOfOccurencesForLine(String lineString, String word) {
		String[] wordArrayInLine = StringUtil.getStringArrayForPattern(lineString, WORD_SEPARATOR_PATTERN);
		StringUtil.replaceTrailingDot(wordArrayInLine);
		List<String> wordList= (List<String>) Arrays.asList(wordArrayInLine);
		return StringUtil.getNumberOfOccurences(wordList, word);
	}

}
