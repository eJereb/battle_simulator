package battle_simulator;

public class Status {
	private static String name;
	private static String description;
	private static String fun_Name;
	private static int duration;
	private static boolean type;
	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Status.name = name;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		Status.description = description;
	}
	public static String getFun_Name() {
		return fun_Name;
	}
	public static void setFun_Name(String fun_Name) {
		Status.fun_Name = fun_Name;
	}
	public static int getDuration() {
		return duration;
	}
	public static void setDuration(int duration) {
		Status.duration = duration;
	}
	public static boolean isType() {
		return type;
	}
	public static void setType(boolean type) {
		Status.type = type;
	}
	

}
