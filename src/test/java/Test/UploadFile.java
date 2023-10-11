package Test;

import org.testng.annotations.Test;

import autoitx4java.AutoItX;



public class UploadFile extends TestAutomation {
    	
	@Test
	public void notepad()
	{
    	 AutoItX x = new AutoItX();
        x.run("notepad.exe", "C:/Windows/System32", AutoItX.SW_SHOW);
        x.winActivate("Notepad");
		x.winWaitActive("Untitled - Notepad");
		x.send("This is example text");
		x.winClose("Untitled - Notepad");
		x.winWaitActive("Notepad", "Save");
		x.send("!n");
    }

//    public static String jvmBitVersion() {
//        // TODO Auto-generated method stub
//        System.out.println(System.getProperty("sun.arch.data.model"));
//        return System.getProperty("sun.arch.data.model");
//
//    }

}