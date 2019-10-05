package service;

import org.json.JSONObject;

public interface IBaiduWordAnalysis {
	JSONObject getResult(String text);
	String[] convertResult(JSONObject res);
}
