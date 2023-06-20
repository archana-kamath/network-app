package networking.infiniteoptions;

import java.util.List;

//Networking app for Infinite Options
public class App 
{
    public static void main( String[] args )
    {
    	
    	// Attendee -> ID, Name, Skills, Interested in learning
    	// Future action: Contact details, Willingness  to mentor, willingness to refer, will be shifted to database
        Attendee a1 = new Attendee("A1", "Steve", 
        		List.of("Coding", "Web Design","Cybersecurity"), 
        		List.of("Artificial intelligence","Technical Writing"));
        
        Attendee a2 = new Attendee("A2", "Tony", 
        		List.of("Management"), 
        		List.of("Artificial intelligence"));
        
        Attendee a3 = new Attendee("A3", "Peter", 
        		List.of("Artificial intelligence","Data Analysis"), 
        		List.of("Management"));
        
        Attendee a4 = new Attendee("A4", "Clint", 
        		List.of("Coding","Artificial intelligence"), 
        		List.of("Cybersecurity","Web Design"));
        
        Attendee a5 = new Attendee("A5", "Nick", 
        		List.of("Web Design"), 
        		List.of("Artificial intelligence"));
        
        Attendee a6 = new Attendee("A6", "Chris", 
        		List.of("Technical Writing"), 
        		List.of("Artificial intelligence"));
        
        // Register to event 
        NetworkingService service = new NetworkingService();
        service.register(a1);
        service.register(a2);
        service.register(a3);
        service.register(a4);
        service.register(a5);
        service.register(a6);
        
        System.out.println("\nEvent attendees Directory \n");
        service.printAttendeesDetails();
        System.out.println("\nSkill Registry \n");
        service.printSkillRegistry();
        
        service.findMatch();
        
        System.out.println("\nMentor Directory \n");
        service.printMentors();
        
    }
}
