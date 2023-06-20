package networking.infiniteoptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkingService {
	
	static final int MENTORSHIP_LIMIT = 3;
	
	List<Attendee> listOfAttendees = new ArrayList<Attendee>();
	Map<String, List<Attendee>> skillResgistry = new HashMap<String, List<Attendee>>();
	List<Connect> listOfConnections = new ArrayList<Connect>();
	Map<String, Integer> mentorshipMap = new HashMap<String, Integer>();
	
	public void register(Attendee attendee) {
		
		// List of people attending
		listOfAttendees.add(attendee);

		// Map to keep track of mentorship details
		mentorshipMap.put(attendee.getAttendeeId(), 0);
		
		// Skill registry - Map skill with the mentors available
		List<String> skillsList = attendee.getSkills();
		skillsList.stream().forEach(skill -> {
			if(skillResgistry.containsKey(skill)) {
				List<Attendee> attendeeList = skillResgistry.get(skill);
				attendeeList.add(attendee);
				skillResgistry.put(skill,attendeeList);
			}else {
				List<Attendee> attendeeList = new ArrayList<Attendee>();
				attendeeList.add(attendee);
				skillResgistry.put(skill,attendeeList);
			}
		});
	}

	
	/**
	 * Print details
	 */
	public void printAttendeesDetails() {
		listOfAttendees.stream().forEach(attendee -> System.out.println(attendee.toString()));
	}

	/**
	 * Print Skill Registry
	 */
	public void printSkillRegistry() {
		
		for(Map.Entry<String, List<Attendee>> skillmap : skillResgistry.entrySet()){
			
			System.out.println("Skill : "+skillmap.getKey());
			List<Attendee> list= skillmap.getValue();
			list.stream().forEach(attendee -> System.out.println(attendee.getAttendeeId()+" "+attendee.getAttendeeName()));
			System.out.println("---------------------------------");
		}	
	}
	

	/**
	 * For each attendee, check for each skill if a mentor is available.
	 * If yes, create a connection.
	 * Do not allow mentors to have more than 3 attendees
	 */
	public void findMatch() {
		
		for(int i=0;i<listOfAttendees.size();i++) {
			Attendee attendee = listOfAttendees.get(i);

			List<String> interestedInList = attendee.getInterested();
			
			interestedInList.stream().forEach(interestedInSkill -> {
				List<Attendee> mentors = skillResgistry.get(interestedInSkill);
				
					// For equal mentorship distribution use LRU technique 
					for(int j=0;mentors!=null && j<mentors.size();j++) {
						Attendee mentor = mentors.get(j);
						int mentorshipCount = mentorshipMap.get(mentor.getAttendeeId());
						
						if(mentorshipCount<MENTORSHIP_LIMIT) {	// Change the value of constant to increase or decrease limit
							mentorshipMap.put(mentor.getAttendeeId(), mentorshipCount+1);
							listOfConnections.add(new Connect(attendee, interestedInSkill, mentor));
							break;
						}
					}
					
					// Future action - Form a separate registry -> Advertise this
					if(mentors==null) {
						System.out.println("No mentors available for "+interestedInSkill);
					}
			});
		}
	}

	public void printMentors() {
		listOfConnections.stream().forEach(connect -> System.out.println(connect.toString()));
		
	}

}
