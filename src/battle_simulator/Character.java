package battle_simulator;

public class Character {
	private static int START_STATS[];
	private int curr_stats[];
	private String status_effect;
	private static String SKILL_NAME[];
	private int skill_cd[];
	
	public static int[] getSTART_STATS() {
		return START_STATS;
	}
	public static void setSTART_STATS(int[] sTART_STATS) {
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
	public String getStatus_effect() {
		return status_effect;
	}
	public void setStatus_effect(String status_effect) {
		this.status_effect = status_effect;
	}
	public static String[] getSKILL_NAME() {
		return SKILL_NAME;
	}
	public static void setSKILL_NAME(String[] sKILL_NAME) {
		if (sKILL_NAME.length == 4)
			SKILL_NAME = sKILL_NAME;
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
	
	
	
	

	
	
	
}
