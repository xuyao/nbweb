package cn.nb.code;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CodeGenMain {

	public static void main(String[] args){
		File f = new File(Class.class.getResource("/mybatis/mybatis-config.xml").getFile());
		List<String> list = XmlTypeAliasUtil.getTypeAlias(f);
		try{
			for(String modelClass : list){
				Class clazz = Class.forName(modelClass);
				getName(clazz);
				genCode(modelClass, "dao");//生成dao
				genCode(modelClass, "service");//生成dao
				genCode(modelClass, "controller");//生成dao
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//gen dao
	private static void genCode(String modelClass, String type){
		String thislassName = PackageUtil.getThisClass(modelClass, type);
		String pathFile = System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + "main"+ File.separator +"java" + File.separator +
				thislassName.replaceAll("\\.", "\\\\");
		PackageUtil.ifPackageNotExistCreate(modelClass, type);
		
		File daoFile = new File(pathFile+".java");
		try {
			daoFile.createNewFile();
			String content = FileUtils.readFileToString(
					new File(CodeGenMain.class.getResource("").getFile() + type));
			content = content.replaceAll("\\$thisPackage", PackageUtil.getPackage(modelClass, type));
			content = content.replaceAll("\\$modelClass", modelClass);
			content = content.replaceAll("\\$thisClassName", PackageUtil.getThisClassName(modelClass, type));
			content = content.replaceAll("\\$modelName", PackageUtil.getClassName(modelClass));
			content = content.replaceAll("\\$modelObj", PackageUtil.getClassName(modelClass).toLowerCase());
			
			content = content.replaceAll("\\$daoClass", PackageUtil.getThisClass(modelClass, "dao"));
			
			String daoName = PackageUtil.getClassName(PackageUtil.getThisClass(modelClass, "dao"));
			content = content.replaceAll("\\$daoName", daoName);
			content = content.replaceAll("\\$daoObj", daoName.toLowerCase());
			
			content = content.replaceAll("\\$serviceClass", PackageUtil.getThisClass(modelClass, "service"));
			String serviceName = PackageUtil.getClassName(PackageUtil.getThisClass(modelClass, "service"));
			content = content.replaceAll("\\$serviceName", serviceName);
			content = content.replaceAll("\\$serviceObj", serviceName.toLowerCase());
			FileUtils.writeStringToFile(daoFile, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void getName(Class clazz){
		Field[] field = clazz.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].getName());
		}
		System.out.println("========================");
	}
	
	
}
