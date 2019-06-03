package battle_simulator;

public class Character {
	private int START_STATS[];
	private int curr_stats[];
	private Skill skills[];
	private int skill_cd[];
	
	public  int[] getSTART_STATS() {
		return START_STATS;
	}
	public  void setSTART_STATS(int[] sTART_STATS) {
		if (sTART_STATS.length == 6)
			START_STATS = sTART_STATS;
		
	}
	public int[] getCurr_stats() {
		return curr_stats;
	}
	public void setCurr_stats(int[] curr_stats) {
		if (curr_stats.length == 6)
			this.curr_stats = curr_stats;
	}

	public void setSkills(Skill[] skills) {
		this.skills=skills;
	}
	public Skill[] getSkills() {
		return this.skills;
	}
	public int[] getSkill_cd() {
		return skill_cd;
	}
	public void setSkill_cd(int[] skill_cd) {
		for (int i = 0; i < skill_cd.length; i++) {
			if(skill_cd[i]<=0 || skill_cd[i]>99)
				skill_cd[i] = 99;
		}
		if (skill_cd.length == 4)
			this.skill_cd = skill_cd;
	}
	public void setHP(int newHealth) {
		this.curr_stats[0] = newHealth;
	}
	
	
	
	

	
	
	
}
