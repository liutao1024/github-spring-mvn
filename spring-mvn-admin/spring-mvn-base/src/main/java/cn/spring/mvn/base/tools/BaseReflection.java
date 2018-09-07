package cn.spring.mvn.base.tools;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

import cn.spring.mvn.base.util.BaseUtil;


@SuppressWarnings({"rawtypes", "unchecked"})
public class BaseReflection {
	private static final Logger LOGGER = Logger.getLogger(BaseReflection.class);
	/**
	 * @author LiuTao @date 2018年6月2日 下午9:15:07 
	 * @Title: executeMethodByClassNameAndMethodName 
	 * @Description: 
	 * @param className
	 * @param methodName
	 * @throws Exception 
	 */
	/**
	 * @author LiuTao @date 2018年9月4日 下午4:07:40 
	 * @Title: executeMethodByClassNameAndMethodName 
	 * @Description: 通过反射获得className对应的类并执行该类中methodName对应的方法
	 * @param className 类
	 * @param methodName 类中的方法
	 * @param classes 方法参数的类型  所以是不是需要将   输入和输出封装成单独的类
	 * @param objects 方法的参数
	 * @throws Exception
	 */
	public static void executeMethodByClassNameAndMethodName(String className, String methodName, Class[] classes, Object[] objects) throws Exception{
		try {
			Class theClass = getClassByClassName(className);
			Object obj = theClass.newInstance();
			Method method = theClass.getMethod(methodName, classes);
			method.setAccessible(true);//对于类中的private方法也可以通过这只后可以访问
			method.invoke(obj, objects);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}
	/**
	 * @author LiuTao @date 2018年6月2日 下午7:11:56 
	 * @Title: getClassByClassName 
	 * @Description: 通过反射根据className获取Class
	 * @param className
	 * @return
	 * @throws Exception 
	 */
	public static Class getClassByClassName(String className) throws Exception{
		try {
			Class object = Class.forName(className);
			return object;
		} catch (Exception e) {
			LOGGER.info("根据字符串" + className + "获取类失败:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @author LiuTao @date 2018年6月4日 下午8:18:10 
	 * @Title: getSubFileNameListByFilePath 
	 * @Description: 递归查找指定目录下的类文件的全路径 
     * @param baseFile 查找文件的入口 
     * @param fileList 保存已经查找到的文件集合 
	 */
    public static List<String> getSubFileNameListByFilePath(File file, List<String> fileList){ 
        if(file.isDirectory()){  
            File[] files = file.listFiles();  
            for(File tmpFile : files){  
            	getSubFileNameListByFilePath(tmpFile, fileList);  
            }  
        }else {
        	String filePath = file.getPath();  
        	System.out.println(filePath);
        	if(filePath.endsWith(".java")){  
        		String name1 = filePath.substring(filePath.indexOf("java")+5, filePath.length());  
        		String name2 = name1.replaceAll("\\\\", ".");  
        		String name3 = name2.substring(0, name2.lastIndexOf(".java"));  
        		fileList.add(name3);  
        	}  
		}  
        return fileList;
    }  
    /**
     * @author LiuTao @date 2018年6月4日 下午8:17:51 
     * @Title: getClassNameFromByJar 
     * @Description: 从jar包读取所有的class文件名 
     * @param jarName
     * @return
     */
    @SuppressWarnings("resource")
	public static List<String> getClassNameFromByJar(String jarName){  
        List<String> fileList = new ArrayList<String>();  
        try {  
            JarFile jarFile = new JarFile(new File(jarName));  
             Enumeration<JarEntry> en = jarFile.entries(); // 枚举获得JAR文件内的实体,即相对路径    
             while (en.hasMoreElements()) {  
                 String name1 =  en.nextElement().getName();  
                 if(!name1.endsWith(".class")){//不是class文件  
                     continue;  
                 }  
                 String name2 = name1.substring(0, name1.lastIndexOf(".class"));  
                 String name3 = name2.replaceAll("/", ".");  
                 fileList.add(name3);  
             }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return fileList;  
    }  
    /** 
     * @author LiuTao @date 2018年6月4日 下午8:17:35 
     * @Title: isChildClass 
     * @Description: 判断一个类是否继承某个父类或实现某个接口
     * @param className
     * @param parentClazz
     * @return
     */
    public static boolean isChildClass(String className, Class parentClazz){  
        if(className == null) return false;  
          
        Class clazz = null;  
        try {  
            clazz = Class.forName(className);  
            if(Modifier.isAbstract(clazz.getModifiers())){//抽象类忽略  
                return false;  
            }  
            if(Modifier.isInterface(clazz.getModifiers())){//接口忽略  
                return false;  
            } 
            if(BaseUtil.equal(clazz, parentClazz)){//该父类忽略
            	return false;  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
        return parentClazz.isAssignableFrom(clazz);  
          
    }  
	
}