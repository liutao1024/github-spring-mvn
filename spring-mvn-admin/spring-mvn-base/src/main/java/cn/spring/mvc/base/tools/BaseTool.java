package cn.spring.mvc.base.tools;

import java.util.UUID;

public class BaseTool {
	/**
	 * @author LiuTao @date 2018年6月12日 下午1:25:10 
	 * @Title: getSerial 
	 * @Description: 生成一个流水号
	 * @return
	 */
	public static String getSerial(){
		UUID uuid = UUID.randomUUID();
		String serial = uuid.toString();
		return serial;
	}
	
	/**
	 * @author LiuTao @date 2018年6月12日 下午1:35:54 
	 * @Title: getSerial 
	 * @Description: 根据传入的key字符串获取UUID字符串,类似MD5加密 
	 * @param key
	 * @return
	 */
	public static String getSerial(String key){
		UUID uuid = UUID.nameUUIDFromBytes(key.getBytes());
		String serial = uuid.toString();
		return serial;
	}
}
