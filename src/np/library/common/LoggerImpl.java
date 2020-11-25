package np.library.common;

class LoggerImpl extends Logger {
	protected LoggerImpl(String name) {
		super(name);
	}

	protected LoggerImpl(Class<?> clazz) {
		super(clazz);
	}

	public void Info(Object... args) {}
	public void Debug(Object... args) {}
	public void Warn(Object... args) {}
}