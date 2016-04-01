package cn.nb.base.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 资源响应类型
 * @author 
 *
 */
public class ContentType {

	public enum Format{
		xml,
		json
	}
	
	public static final String URL_ENCODED = "application/x-www-form-urlencoded";
	
	public static final String TEXT_PLAIN = "text/plain;charset=UTF-8";
    
	public static final String JSON = TEXT_PLAIN;
	
	public static final String XML = TEXT_PLAIN;
	
	
	public static final String ACCEPT_JSON = "application/json";
	
    public static final String ACCEPT_XML = "text/xml";
    
    public static Map<String, String> response_types = new HashMap<String, String>();
    static{
    	response_types.put(Format.json.toString(), JSON);
    	response_types.put(Format.xml.toString(), XML);
    }
    
    public static List<String> formats = new ArrayList<String>();
    static{
    	formats.add(Format.json.toString());
		formats.add(Format.xml.toString());
    }
    
    public static String getResponseContentType(String format){
    	if (StringUtils.isBlank(format) || !formats.contains(format.toLowerCase())) {
			format = Format.json.toString();
		}
    	return response_types.get(format);
    }
}
