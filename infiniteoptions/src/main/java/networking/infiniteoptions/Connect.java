package networking.infiniteoptions;

public class Connect {
	
	private Attendee attendee;
	private String skill;
	private Attendee mentor;
	
	public Connect(Attendee attendee, String skill, Attendee mentor) {
		super();
		this.attendee = attendee;
		this.skill = skill;
		this.mentor = mentor;
	}
	
	public Attendee getAttendee() {
		return attendee;
	}
	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Attendee getMentor() {
		return mentor;
	}
	public void setMentor(Attendee mentor) {
		this.mentor = mentor;
	}
	@Override
	public String toString() {
		//return "Connect [attendee=" + attendee + ", skill=" + skill + ", mentor=" + mentor + "]";
		return "Connection : " + attendee.getAttendeeId() +" ("+attendee.getAttendeeName()+")"+ " is mentored by " 
				+ mentor.getAttendeeId()+ " (" + mentor.getAttendeeName()+")"
				+" in "+ skill;
	}
	
	
}
