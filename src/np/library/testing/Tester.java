package np.library.testing;
import java.lang.reflect.*;
public class Tester {
	public static boolean Test(Class<?> clazz, Object instance) {
		for(Method method : clazz.getDeclaredMethods()) {
			if(method.getAnnotation(Test.class) != null) {
				try {
					method.invoke(instance, new Object[0]);
				} catch (TestFailedSignal tfex) {
					System.out.println(tfex.getMessage());
					return false;
				} catch (Exception ex) {
					return false;
				}
			}
		}
		return true;
	} 

	public static void Fail(String message) {
		throw new TestailedSignal(message);
	}
}