package service.impl;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.baidu.aip.nlp.AipNlp;
import service.IBaiduWordAnalysis;


public class BaiduWordAnalysisImpl implements IBaiduWordAnalysis{
	public static String BaiduUrl = "https://aip.baidubce.com/rpc/2.0/nlp/v1/lexer";
	//设置APPID/AK/SK
    public static final String APP_ID = "15677100";
    public static final String API_KEY = "sBOS902ZUl4SQ8G0YKWOrMKn";
    public static final String SECRET_KEY = "OPA9vT1bnLlQ9CPKeNpujgfw06rcuoqa";
    
    public JSONObject getResult(String text) {
    	// TODO Auto-generated method stub
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        return client.lexer(text);
    }

	public String[] convertResult(JSONObject res) {
		// TODO Auto-generated method stub
		System.out.println(res);
		int num = 0;
		List<String> result = new ArrayList();
		JSONArray items = res.getJSONArray("items");
		for(int i=0;i<items.length();i++){
			JSONObject tmp = items.getJSONObject(i);
			if(tmp.getString("pos").equals("n")||tmp.getString("ne").equals("ORG")){
				result.add(tmp.getString("item"));
				num++;
			}
		}
		String[] resultStr = new String[num];
		result.toArray(resultStr);
		return resultStr;
	}
}
