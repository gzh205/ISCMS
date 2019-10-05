package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entity.Compete;
import entity.Organizer;
import entity.Signup;
import entity.User;

public class OutputExcel {
    /**
     * 
     * @param name
     * Excel保存的主题名
     * @param data
     * 里边有Map和List Map存放字段对应关系(ziDuan,字段的第一个字符是序号)
     * List存放对象数据(listData)
     * @return [0]是fileName [1]是filePath
     */
    public static String listToExcel(String name,String[] title, String[][] data,String path) {
    	try{
	    	HSSFWorkbook hsw = ExcelUtil.getHSSFWorkbook(name, title, data, null);
	    	OutputStream stream = new FileOutputStream(new File(path));
	    	hsw.write(stream);
	    	stream.close();
	    	return path;
    	}catch(Exception e){
    		e.printStackTrace();
    		return null; 
    	}
    }
    public static String[] getUserTitle(){
    	String[] result = new String[3];
    	result[0] = "参赛者邮箱";
    	result[1] = "参赛者密码";
    	result[2] = "参赛者用户名";
    	return result;
    }
    public static String[][] convertUserData(List<User> uList){
    	String[][] result = new String[uList.size()][3];
    	for(int i=0;i<uList.size();i++){
    		User u = uList.get(i);
    		result[i][0] = u.getUemail();
    		result[i][1] = u.getUpassword();
    		result[i][2] = u.getUname();
       	}
    	return result;
    }
    public static String getTomcatPath(HttpServletRequest req){
    	return req.getServletContext().getRealPath("/");
    }
    public static String[][] convertOrgData(List<Organizer> oList){
    	String[][] result = new String[oList.size()][3];
    	for(int i=0;i<oList.size();i++){
    		Organizer o = oList.get(i);
    		result[i][0] = o.getOemail();
    		result[i][1] = o.getOpassword();
    		result[i][2] = o.getOinfo();
       	}
    	return result;
    }
    public static String[] getOrgTitle(){
    	String[] result = new String[3];
    	result[0] = "主办方邮箱";
    	result[1] = "主办方密码";
    	result[2] = "主办方信息";
    	return result;
    }
    public static String[] getCompeteTitle(){
    	return(new String[]{"比赛名称","比赛时间","报名费用","备注"});
    }
    public static String[][] convertCompeteData(List<Compete> cList){
    	String[][] result = new String[cList.size()][4];
    	for(int i=0;i<cList.size();i++){
    		Compete c = cList.get(i);
    		result[i][0] = c.getcInfo();
    		result[i][1] = c.getcTime();
    		result[i][2] = c.getcFee().toString();
    		result[i][3] = c.getcRemark();
    	}
    	return result;
    }
    public static String[] getSignupTitle(){
    	return(new String[]{"编号","竞赛名称","参赛者邮箱","身份证号码"});
    }
    public static String[][] convertSignupData(List<Signup> sList){
    	String[][] result = new String[sList.size()][4];
    	for(int i=0;i<sList.size();i++){
    		Signup s = sList.get(i);
    		result[i][0] = new Integer(s.getId()).toString();
    		result[i][1] = s.getcInfo();
    		result[i][2] = s.getuEmail();
    		result[i][3] = s.getcNumber();
    	}
    	return result;
    }
}
