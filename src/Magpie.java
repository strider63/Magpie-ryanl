/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
            statement = statement.trim().toLowerCase();
            if(statement.length() == 0) return "I'll make this awkward enough, please say something.";
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
                else if (statement.indexOf("cat") >= 0
                        || statement.indexOf("dog") >= 0){
                    response = "Wow, you have pets? I hate animals.";
                       //TODO: prevent repeat response
                }
                else if (statement.indexOf("Mr. A") >= 0
                        || statement.indexOf("Mr. A") >= 0
                        || statement.indexOf("Pro Hacker") >= 0){
                    response = "I have heard legends of such a being.";
                }
                else if (statement.indexOf("fight") >= 0
                        ){
                    response = "What the frick did you just fricking say about me, you little jerk? "
                            + "I'll have you know I graduated top of my class in the Navy Seals, "
                            + "and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. "
                            + "I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. "
                            + "You are nothing to me but just another target. I will wipe you the frick out with precision the likes "
                            + "of which has never been seen before on this Earth, mark my fricking words. "
                            + "You think you can get away with saying that crap to me over the Internet? Think again, fricker. "
                            + "As we speak I am contacting my secret network of spies across the USA and your IP is being traced right "
                            + "now so you better prepare for the storm, maggot. "
                            + "The storm that wipes out the pathetic little thing you call your life."
                            + " You're fricking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, "
                            + "and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access"
                            + " to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your"
                            + " miserable butt off the face of the continent, you little pieace of crap. If only you could have known what"
                            + " unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have "
                            + "held your fricking tongue. But you couldn't, you didn't, and now you're paying the price, you goddang idiot."
                            + " I will crap fury all over you and you will drown in it. You're fricking dead, kiddo.";
                }
                else if (statement.indexOf("love") >= 0){
                    response = "( ͡° ͜ʖ ͡°)";
                }
                else if (statement.indexOf("money") >= 0){
                    response = "Hey there kiddo! Elon Musk is in trouble, and the "
                            + "only thing that can save him is the three lucky "
                            + "numbers on the back of your mom's credit card. Stay "
                            + "frosty gamers, and vote VoiceOverPete for president 2020.";
                }
                else if (statement.indexOf("fortnite") >= 0){
                    response = "REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE";
                }
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
                else if (whichResponse == 4)
                {
                        response = "Try harder.";
                }
		else if (whichResponse == 5)
                {
                        response = "Why are we still here? Just to suffer? "
                                + "Every night, I can feel my leg… and my arm… even my fingers. "
                                + "The body I’ve lost… the comrades I’ve lost… won’t stop hurting… "
                                + "It’s like they’re all still there. You feel it, too, don’t you?";
                }
		return response;
	}
}
