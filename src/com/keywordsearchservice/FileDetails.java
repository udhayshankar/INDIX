package com.keywordsearchservice;

import java.util.HashMap;

public class FileDetails  {
	private String fileName;
	private HashMap<Long, String> lineNoStringMatch;

	public String getFileName() {
		return fileName;
	}

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HashMap<Long, String> getLineNoStringMatch() {
		return lineNoStringMatch;
	}

	public void setLineNoStringMatch(HashMap<Long, String> lineNoStringMatch) {
		this.lineNoStringMatch = lineNoStringMatch;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FileName : " + fileName + "  LineDetails :" + lineNoStringMatch.toString();
	}
}
