package cn.spring.mvn.core.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.spring.mvn.comm.util.CommUtil;
import cn.spring.mvn.comm.util.SpringContextUtil;
import cn.spring.mvn.core.account.entity.CustUser;
import cn.spring.mvn.core.account.entity.service.CustUserService;

/**
 * @author LiuTao @date 2018年9月4日 下午1:25:31
 * @ClassName: AccountServiceImpl 
 * @Description: TODO(核心部分-账户模块对账户的处理均写在本类中)
 */

public class AccountServiceImpl extends SpringContextUtil {
	
	private static CustUserService custUserServiceImpl = (CustUserService) applicationContext.getBean(CustUserService.class);
	
	public static void openAccount(){
		
	}
	/**
	 * @author LiuTao @date 2018年9月4日 下午1:30:17 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param idtftp
	 * @param idtfno
	 * @param custna
	 * @return
	 */
	public static Map<String, Object> queryCustUserOne(String idtftp, String idtfno, String custna){
		Map<String, Object> rstMap = new HashMap<String, Object>();
		String hqlStr = "from CustUser where 1 = 1";
		String appendStr = "";
		if(CommUtil.isNotNull(idtftp)){
			appendStr += " and idtftp = '" + idtftp + "'";
		}
		if(CommUtil.isNotNull(idtfno)){
			appendStr += " and idtfno = '" + idtfno + "'";
		}
		if(CommUtil.isNotNull(custna)){
			appendStr += " and custna like '%" + custna + "%'";
		}
		if(CommUtil.isNotNull(appendStr)){
			hqlStr = hqlStr + appendStr;
		}
		List<CustUser> custUserList = custUserServiceImpl.findAllByHql(hqlStr);
		rstMap.put("count", custUserList.size());
		rstMap.put("data", custUserList);
		return rstMap;
	}
	/**
	 * @author LiuTao @date 2018年9月5日 下午3:23:42 
	 * @Title: queryCustUser 
	 * @Description: TODO(Describe) 
	 * @param idtftp
	 * @param idtfno
	 * @param custna
	 * @return 
	 * @return
	 */
	public static void queryCustUser(Myinput input, Myoutput output){
		String hqlStr = "from CustUser where 1 = 1";
		String appendStr = "";
		if(CommUtil.isNotNull(input.getIdtptf())){
			appendStr += " and idtftp = '" + input.getIdtptf() + "'";
		}
		if(CommUtil.isNotNull(input.getIdtfno())){
			appendStr += " and idtfno = '" + input.getIdtfno() + "'";
		}
		if(CommUtil.isNotNull(input.getCustna())){
			appendStr += " and custna like '%" + input.getCustna() + "%'";
		}
		if(CommUtil.isNotNull(appendStr)){
			hqlStr = hqlStr + appendStr;
		}
		List<CustUser> custUserList = custUserServiceImpl.findAllByHql(hqlStr);
		output.setCount(custUserList.size());
		output.setData(custUserList);
	}
}