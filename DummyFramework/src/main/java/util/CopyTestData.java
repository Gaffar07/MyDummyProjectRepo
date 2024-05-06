package util;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CopyTestData {
	
	public static void BackupTestData(String TestDataPath,String BackupFolderName) throws Exception
	{
		System.out.println("Test Data Backup Processing ...");
		// create Backup Folder
		File backupfile = new File("D:\\"+BackupFolderName);
		if (!backupfile.exists()) {
			backupfile.mkdir();
		} 
		else
		{
			System.out.println("--- File Is Allready Present ---");
			backupfile.delete();
			System.out.println("--- File Deleted ---");
			backupfile.mkdir();
			System.out.println("--- File Created Successfully ---");
		}
	       File fileToCopy = new File(TestDataPath);
	       File newFile = new File("D:\\"+BackupFolderName);
	       FileUtils.copyDirectory(fileToCopy, newFile);
	       
	    System.out.println("Test Data Backup Completed.");
	
	}
	

}
