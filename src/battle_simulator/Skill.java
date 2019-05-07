package battle_simulator;

public class Skill {
	private static String name;
	private static String description;
	private static int cooldown;
	private static String type;
	private static String fun_Name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		if (cooldown<=0 || cooldown>100 ) {
			cooldown = 99;
		}
		this.cooldown = cooldown;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFun_Name() {
		return fun_Name;
	}
	public void setFun_Name(String fun_Name) {
		this.fun_Name = fun_Name;
	}
	
	

}
