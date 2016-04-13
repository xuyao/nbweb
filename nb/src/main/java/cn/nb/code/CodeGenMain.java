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
			for(String s : list){
				System.out.println(s);
				Class clazz = Class.forName(s);
				getName(clazz);
				genDao(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//gen dao
	private static void genDao(String modelPackage){
		String daoClassName = getPackage(modelPackage, "dao");
		System.out.println(daoClassName);
		String pathFile = System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + "main"+ File.separator +"java" + File.separator +
				daoClassName.replaceAll("\\.", "\\\\");
//		System.out.println(pathFile);
		
		ifNotExistCreate(modelPackage, "dao");
		
		File daoFile = new File(pathFile+".java");
		try {
			daoFile.createNewFile();
			FileUtils.writeStringToFile(daoFile, "asd");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void ifNotExistCreate(String modelPackage, String type){
		modelPackage = modelPackage.substring(0, modelPackage.lastIndexOf("."));
		String daoPackage = modelPackage.substring(0, modelPackage.lastIndexOf("."))
				+"."+type+".";
		String pathFile = System.getProperty("user.dir") + File.separator + 
				"src" + File.separator + "main"+ File.separator +"java" + File.separator +
				daoPackage.replaceAll("\\.", "\\\\");
		File f = new File(pathFile);
		if(!f.exists()){
			try {
				f.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//get name
	private static String getPackage(String modelPackage, String type){
		String[] str = modelPackage.split("\\.");
		String modelClassName = str[str.length-1];
		modelPackage = modelPackage.substring(0, modelPackage.lastIndexOf("."));
		String daoPackage = modelPackage.substring(0, modelPackage.lastIndexOf("."))
				+"."+type+".";
		String packageClass = daoPackage + modelClassName + CharUpDownUtil.toUpperCaseFirstOne(type);
		return packageClass;
	}
	
	
	private static void getName(Class clazz){
		Field[] field = clazz.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].getName());
		}
	}
	
	
}
