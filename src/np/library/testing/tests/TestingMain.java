package np.library.testing.tests;

import java.io.File;
import java.io.IOException;

import np.library.io.FileWatcher;
import np.library.testing.Tester;

public class TestingMain {

	public static void main(String[] args) {
		if(Tester.Test(LoggerTests.class)) System.out.println("LoggerTests Passed!");
		
		if(Tester.Test(DeviceTests.class)) System.out.println("DeviceTests Passed!");
		
		try {
			FileWatcher watcher = new TestFileWatcher();
			watcher.RegisterDir(new File("resources/"));
			Thread watcherWorker = watcher.StartPollingForEvents();
			watcherWorker.join();
		} catch(IOException ioex) {
		} catch (InterruptedException e) {
		}
	}
	
	public static class TestFileWatcher extends FileWatcher {

		public TestFileWatcher() throws IOException {
			super();
		}

		@Override
		protected void OnFileCreated(File file) {
			if(file.isDirectory()) RegisterDir(file);
			System.out.println(file);
		}

		@Override
		protected void OnFileModified(File file) {
			System.out.println(file);
		}

		@Override
		protected void OnFileDeleted(File file) {
			System.out.println(file);
		}
		
		
		
		
	}

}
