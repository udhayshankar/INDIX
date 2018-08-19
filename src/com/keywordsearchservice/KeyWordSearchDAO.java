package com.keywordsearchservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class KeyWordSearchDAO {
	
	private static Logger logger=Logger.getLogger(KeyWordSearchDAO.class.getName());

	private static ArrayList<String> readFiles(File file, ArrayList<String> fileArrayList) throws IOException {
		
		
		for (File fileEntry : file.listFiles()) {
			
			if (fileEntry.isDirectory()) {
				readFiles(fileEntry, fileArrayList);
			} else {
				fileArrayList.add(fileEntry.getAbsolutePath());
			}
		}
		return fileArrayList;
	}

	public static ArrayList<FileDetails> getValuesByKeyWord(String keyWord) throws Exception {
		try {
			logger.info("reading folder src");
		File file = new File("C:/Users/UDHAYA SHANKAR/Desktop/redis-unstable/src");
		long lineCount = 0;
		String line = "";
		// source folder file names
		ArrayList<String> fileList = new ArrayList<String>();
		fileList = readFiles(file, fileList);
		logger.info("file list created !!");
		
		// file detail list file and line string mapping
		ArrayList<FileDetails> fileDetailsList = new ArrayList<FileDetails>();		
		logger.info("initiating for loop");
		for (String fname : fileList) {
			BufferedReader brFileReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(fname))));
			// line number and line string mapping
			FileDetails fileDetails = new FileDetails();
			HashMap<Long, String> lineStringMap = new HashMap<Long, String>();
			while ((line = brFileReader.readLine()) != null) {
				++lineCount;
				if (new String(line).toLowerCase().contains(keyWord.toLowerCase())) {
					lineStringMap.put(lineCount, line.trim());
				}
			}
			if (lineStringMap.size() > 0) {
				fileDetails.setFileName(fname);
				logger.info(lineStringMap.toString());
				fileDetails.setLineNoStringMatch(lineStringMap);
				fileDetailsList.add(fileDetails);				
				lineCount = 0;
			}
			brFileReader.close();			
		}
		logger.info(fileDetailsList.toString());
		return fileDetailsList;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}
