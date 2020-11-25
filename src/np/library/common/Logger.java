package np.library.common;

public abstract class Logger {
	private final String name;

	public abstract void Info(Object... args);
	public abstract void Debug(Object... args);
	public abstract void Warn(Object... args);

	public Logger(String name) {
		this.name = name;
	}

	public Logger(Class<?> clazz) {
		this(clazz.getSimpleName());
	}
}