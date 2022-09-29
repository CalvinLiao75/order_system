package com.refresh.pos.domain;

import java.util.List;

import android.content.ContentValues;

import com.refresh.pos.techicalservices.Database;
import com.refresh.pos.techicalservices.DatabaseContents;

/**
 * 語言
 *
 */
public class LanguageController {
	
	private static final String DEFAULT_LANGUAGE = "en";
	private static Database database;
	private static LanguageController instance;
	
	private LanguageController() {
		
	}
	
	public static LanguageController getInstance() {
		if (instance == null)
			instance = new LanguageController();
		return instance;
	}
	
	/**
	 * 設置DB

	 */
	public static void setDatabase(Database db) {
		database = db;
	}
	
	/**
	 * 設置語言

	 */
	public void setLanguage(String localeString) {
		database.execute("UPDATE " + DatabaseContents.LANGUAGE + " SET language = '" + localeString + "'");
	}
	
	/**
	 * 回傳當前語言

	 */
	public String getLanguage() {
		List<Object> contents = database.select("SELECT * FROM " + DatabaseContents.LANGUAGE);

		if (contents.isEmpty()) {
			ContentValues defualtLang = new ContentValues();
			defualtLang.put("language", DEFAULT_LANGUAGE);
			database.insert( DatabaseContents.LANGUAGE.toString(), defualtLang);
	
			return DEFAULT_LANGUAGE;
		}
		ContentValues content = (ContentValues) contents.get(0);
		return content.getAsString("language");	
	}

}
