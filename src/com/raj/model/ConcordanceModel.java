package com.raj.model;

import com.raj.util.MathUtils;

public class ConcordanceModel {

	public ConcordanceModel() {
		this.sequnceNumber = null;
		this.word = null;
		this.totalOccurences = 0;
		this.lineNumbers = null;
	}

	String sequnceNumber;
	String word;
	int totalOccurences;
	String lineNumbers;

	public String getSequnceNumber() {
		return sequnceNumber;
	}
	public void setSequnceNumber(int sequnceNumber) {
		this.sequnceNumber = MathUtils.getStringSequence(sequnceNumber);
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getTotalOccurences() {
		return totalOccurences;
	}
	public void setTotalOccurences(int totalOccurences) {
		this.totalOccurences = this.totalOccurences+totalOccurences;
	}
	public String getLineNumbers() {
		return lineNumbers;
	}
	public void setLineNumbers(int lineNumber) {
		if(this.lineNumbers!=null) {
			this.lineNumbers = this.lineNumbers + ","+ lineNumber;
		} else {
			this.lineNumbers = lineNumber + "";
		}
	}

}
