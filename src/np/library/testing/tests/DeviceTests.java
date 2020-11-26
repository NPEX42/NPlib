package np.library.testing.tests;

import java.io.File;

import np.library.io.FileIO;
import np.library.io.IODevice;
import np.library.io.SystemIO;
import np.library.testing.Test;
import np.library.testing.Tester;

public class DeviceTests {
	@Test
	public void testSystemIO() {
		IODevice io = new SystemIO();
		io.WriteString("Hello From SystemIO");
		String received = io.ReadStringOrBlock();
		if(received == null) Tester.Fail("io.ReadStringOrBlock() Returned Null...");
		io.Close();
	}
	
	@Test
	public void testFileIO() {
		IODevice io = new FileIO(new File("file.txt"));
		io.WriteString("Hello From FileIO");
		String received = io.ReadStringOrBlock();
		if(!received.equals("Hello From FileIO")) Tester.Fail("io.ReadStringOrBlock() Returned Null...");
		io.Close();
	}
}
