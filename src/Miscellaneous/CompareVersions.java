package Miscellaneous;

public class CompareVersions {

	private static final String v1 = "1.1";
	private static final String v2 = "1.1.1";
	
	public static void main(String[] args) {

		if(compareVersion(v1, v2) == -1)
			System.out.println("Version1 < Version2");
		else if(compareVersion(v1, v2) == 1)
			System.out.println("Version1 > Version2"); 
		else
			System.out.println("Version1 = Version2");
	}

	public static int compareVersion(String version1, String version2) {
        String[] v1 = getVersion(version1);
        String[] v2 = getVersion(version2);
        
        for(int i=0; i< v1.length || i< v2.length;)   {
            int ver1 = (i >= v1.length)? 0: Integer.parseInt(v1[i]);
            int ver2 = (i >= v2.length)? 0: Integer.parseInt(v2[i]);
            if(ver1 < ver2) return -1;
            else if(ver1 > ver2) return 1;
            else { i++;}    //Check further subversions
        }
        return 0;
    }
    
    private static String[] getVersion(String version)   {
        if(!version.contains("."))  {
            String[] stringVersion = new String[1];
            stringVersion[0] = version;
            return stringVersion;
        }
        else    {
            String[] stringVersion = version.split("\\.");
            return stringVersion;
        }
    }
}
