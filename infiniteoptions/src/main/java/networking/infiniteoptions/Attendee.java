package networking.infiniteoptions;

import java.util.List;

public class Attendee {
	
	private String attendeeId;
	private String attendeeName;
	private List<String> skills;
	private List<String> interested;
	
	
	public Attendee() {
		super();
	}

	public Attendee(String attendeeId, String attendeeName, List<String> skills, List<String> interested) {
		super();
		this.attendeeId = attendeeId;
		this.attendeeName = attendeeName;
		this.skills = skills;
		this.interested = interested;
	}

	public String getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(String attendeeId) {
		this.attendeeId = attendeeId;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<String> getInterested() {
		return interested;
	}

	public void setInterested(List<String> interested) {
		this.interested = interested;
	}

	@Override
	public String toString() {
		return "Attendee [attendeeId=" + attendeeId + ", attendeeName=" + attendeeName + ", skills=" + skills
				+ ", interested=" + interested+ "]";
	}

}
