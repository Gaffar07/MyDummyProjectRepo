package util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public final class MapOfUserIDAssignedToAllocation {

	public static Map<String, String> listOfUserIDForExecution=null;
	public static Map<String, String> PPMClistOfUserIDForExecution=null;
	public static Map<String, String> UWRlistOfUserIDForExecution=null;

	//Motor UWR Log ID
	public static Map<String, String> MotorUWRR5LogId=null;
	public static Map<String, String> MotorUWRR6LogId=null;
	public static Map<String, String> MotorUWRR7LogId=null;
	public static Map<String, String> MotorUWRR8LogId=null;
	public static Map<String, String> MotorUWRRLoginIDForAllRoles=null;
	
	
	//Added For RM Role For Motor
	public static Map<String, String> MotorRMLogId=null;
	
	
	private MapOfUserIDAssignedToAllocation() throws Exception {
		if(listOfUserIDForExecution==null) 
			MapOfUserIDAssignedToAllocation.listOfUserIDForExecution =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MyuserId").trim().split(",")));
	
		if(PPMClistOfUserIDForExecution==null)
			MapOfUserIDAssignedToAllocation.PPMClistOfUserIDForExecution =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("PPMCMyuserId").trim().split(",")));
		
		if(UWRlistOfUserIDForExecution==null)
			MapOfUserIDAssignedToAllocation.UWRlistOfUserIDForExecution =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("UWRMyuserId").trim().split(",")));
	
		//For Motor UWR LogId As per Level
		if(MotorUWRR5LogId==null)
			MapOfUserIDAssignedToAllocation.MotorUWRR5LogId =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MotorUWRR5LogId").trim().split(",")));
	
		if(MotorUWRR6LogId==null)
			MapOfUserIDAssignedToAllocation.MotorUWRR6LogId =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MotorUWRR6LogId").trim().split(",")));
	
		if(MotorUWRR7LogId==null)
			MapOfUserIDAssignedToAllocation.MotorUWRR7LogId =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MotorUWRR7LogId").trim().split(",")));
	
		if(MotorUWRR8LogId==null)
			MapOfUserIDAssignedToAllocation.MotorUWRR8LogId =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MotorUWRR8LogId").trim().split(",")));
	
		//Added By Suraj For RM Role 
		if(MotorRMLogId==null)
			MapOfUserIDAssignedToAllocation.MotorRMLogId =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("MotorRMLogId").trim().split(",")));	
		
		if(MotorUWRRLoginIDForAllRoles==null)
			MapOfUserIDAssignedToAllocation.MotorUWRRLoginIDForAllRoles =Collections.synchronizedMap(MapOfUserID(ConfigReader.getInstance().getValue("UWRMyuserId").trim().split(",")));
	}
	
	
	
	public static MapOfUserIDAssignedToAllocation getInstance() throws Exception{
		return new MapOfUserIDAssignedToAllocation();
		
	}

	private HashMap<String,String> MapOfUserID(String[] arrayOfString) {
		HashMap<String,String> toReturn = new HashMap<String,String>();
		for (String s : arrayOfString) {
			toReturn.put(s,"Free");
		}
		return toReturn;
	}
}