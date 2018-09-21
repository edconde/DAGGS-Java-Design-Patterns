package ds.miniframework;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Logger {
	
	private Logger next;
	private int priorityThreshold;
	public static final int DEBUG=0, INFO=1, ERROR=2;
	private String[] prefix = {"[ DEBUG ]", "[ INFO ]", "[ ERROR ]"};
	
	private static Logger singleton;

	protected Logger(Logger next) {
		this.next = next;
	}

	public static Logger getInstance() {
		if (singleton == null) {
			singleton = createLoggerFromFile(new File("logger.conf"));
		}
		return singleton;
	}
	
	private static Logger createLoggerFromFile(File file) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(file);
			Logger chain = null;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.trim();
				if (line.length() == 0) {
					continue;
				}
				
				String[] tokens = line.split("\t");
				if (tokens.length > 1) {
					String className = tokens[0];
					int priorityThreshold = Integer.parseInt(tokens[1]);
					try {
						@SuppressWarnings("unchecked")
						Class<Logger> c = (Class<Logger>) Class.forName(className);
						Constructor<Logger> constructor = c.getConstructor(Logger.class);
						chain = constructor.newInstance(chain);
						chain.setPriorityThreshold(priorityThreshold);
						
					} catch (ClassNotFoundException e) {
						throw new RuntimeException("Your logger class is not valid "+className);
					} catch (NoSuchMethodException e) {
						throw new RuntimeException("Your logger class has not defined the expected constructor ");
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return chain;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void log(String msg, int priority) {
		if( priority >= this.priorityThreshold ) {
			_log(prefix[priority] + " " + LocalDateTime.now() 
					+ " " + msg);
		}
		
		if (next != null) {
			next.log(msg, priority);
		}
	}
	
	protected abstract void _log(String msg);
	
	public int getPriorityThreshold() {
		return priorityThreshold;
	}

	public void setPriorityThreshold(int priorityThreshold) {
		this.priorityThreshold = priorityThreshold;
	}
	
}