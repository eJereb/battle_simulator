package battle_simulator;

public class Skill {
	private  String name;
	private  String description;
	private  int cooldown;
	private  String type;
	private  String fun_Name;
	private  int number;
	
	public Skill(String name,String desc,int cooldown,String type,String fun_Name,int number){
		this.name=name;
		this.cooldown=cooldown;
		this.description=desc;
		this.type=type;
		this.fun_Name=fun_Name;
		this.number=number;
	}
	
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
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
