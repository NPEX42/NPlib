package np.library.testing;

public class TestFailedSignal extends RuntimeException {
	public TestFailedSignal(String message) {
		super(message);
	}
}