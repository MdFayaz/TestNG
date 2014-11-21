package examples.practise;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.testng.log4testng.Logger;


public class RegisteredBrowsers {
	
	private static final int HKEY_LOCAL_MACHINE = 0x80000002;
	private static final int READ_INSTRUCTION = 0x20019;
	private static final int SUCCESS = 0;
	private static final int NOT_FOUND = 2;
	private static final int ACCESS_DENIED = 5;

	public static void main(String[] args) {
		RegisteredBrowsers reg = new RegisteredBrowsers();
		boolean value = reg.getRegisteredBrowsers("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Internet Explorer");
		System.out.println("Value: " + value);
		
	}
	
	private boolean getRegisteredBrowsers(String installPath) {
		boolean value = false;
		
		
//		try {
			Preferences systemRoot = Preferences.systemRoot();
			Preferences userRoot = Preferences.userRoot();
			
			boolean isNodeExists;
			try {
				isNodeExists = userRoot.nodeExists(installPath);
				System.out.println(isNodeExists);
			} catch (BackingStoreException e) {
				e.printStackTrace();
			}
			
			
			/*Class<? extends Preferences> userClass = userRoot.getClass();

			Method openRegKey = userClass.getDeclaredMethod(
					"WindowsRegOpenKey", new Class[] { int.class, byte[].class, int.class });
			openRegKey.setAccessible(true);

			Method readRegKey = userClass.getDeclaredMethod(
					"WindowsRegQueryValueEx", new Class[] { int.class, byte[].class });
			readRegKey.setAccessible(true);

			Method closeRegKey = userClass.getDeclaredMethod(
					"WindowsRegCloseKey", new Class[] { int.class });
			closeRegKey.setAccessible(true);

			
			int[] openValue = (int[])openRegKey.invoke(systemRoot, new Object[] {
					new Integer(HKEY_LOCAL_MACHINE), getStringBytes(installPath),
					new Integer(READ_INSTRUCTION)
			});
			
			if(openValue != null && openValue.length ==2){
				if(openValue[1] == SUCCESS){
					System.out.println("Path "+ installPath + " found key");
					byte[] keyValue = (byte[])readRegKey.invoke(systemRoot, new Object[]{
						new Integer(openValue[0]), getStringBytes(installKey)
					});
					
					
					System.out.println(Arrays.toString(keyValue));
					closeRegKey.invoke(systemRoot, new Object[]{
							new Integer(openValue[0])
					});
					
					System.out.println("Closed registry");
					
					if(keyValue != null){
						value = new String(keyValue).trim();
					}
				} else if( openValue[1] == NOT_FOUND){
					System.out.println("Not found");
				} else if( openValue[1] == ACCESS_DENIED){
					System.out.println("Access denied");
				} else {
					System.out.println("Unknow code");
				}
			} else {
				System.out.println("Unable to retrive registry");
			}
			
			System.out.println(Arrays.toString(systemRoot.childrenNames()));
			String[] keys;
			keys = systemRoot.keys();
			System.out.println(keys.length);
			for (String key : keys) {
				System.out.println("Key: " + key);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(RegisteredBrowsers.class).info(" unable to get access" +
					"to windows registry key " + e.getLocalizedMessage());
		}
		*/
		return value;

	}
	
	
	/**
     * Convert the String value to bytes format taking care to ensure the '0' at
     * the end.
     * 
     * @param stringValue
     * @return
     */
    private static byte[] getStringBytes(String stringValue) {
        byte[] bytes = new byte[stringValue.length() + 1]; // Add '0' at the end
 
        for (int i = 0; i < stringValue.length(); i++) {
            bytes[i] = (byte) stringValue.charAt(i);
        }
 
        bytes[stringValue.length()] = 0;
 
        return bytes;
    }
}
