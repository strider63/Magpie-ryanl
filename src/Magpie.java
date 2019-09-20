
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 * Uses indexOf to find strings
 * </li><li>
 * Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 *
 * @author Laurie White
 * @version April 2012
 */
public class Magpie {

    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        statement = statement.trim().toLowerCase();
        if (statement.length() == 0) {
            return "I'll make this awkward enough, please say something.";
        }
        String response = "";
        if (findKeyword(statement, "no") >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (findKeyword(statement, "cat") >= 0
                || findKeyword(statement, "dog") >= 0) {
            response = "Wow, you have pets? I hate animals.";
            //TODO: prevent repeat response
        } else if (findKeyword(statement, "Mr. Adiletta") >= 0
                || findKeyword(statement, "Mr. A") >= 0
                || findKeyword(statement, "Pro Hacker") >= 0) {
            response = "I have heard legends of such a being.";
        } else if (findKeyword(statement, "fight") >= 0) {
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
        } else if (findKeyword(statement, "love") >= 0) {
            response = "( ͡° ͜ʖ ͡°)";
        } else if (findKeyword(statement, "money") >= 0) {
            response = "Hey there kiddo! Elon Musk is in trouble, and the "
                    + "only thing that can save him is the three lucky "
                    + "numbers on the back of your mom's credit card. Stay "
                    + "frosty gamers, and vote VoiceOverPete for president 2020.";
        } else if (findKeyword(statement, "fortnite") >= 0) {
            response = "REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE";
        } // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
        } else {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);
            int psn2 = findKeyword(statement, "I", 0);
            if (psn >= 0
                    && findKeyword(statement, "me", psn) >= 0){
                response = transformYouMeStatement(statement);
            } 
            else if (psn >= 0
                    && psn2 >= 0 && psn2 < psn){
                response = transformIYouStatement(statement);
            }
        else {
                response = getRandomResponse();
            }
    }

    return response ;
}

/**
 * Pick a default response to use if nothing else fits.
 *
 * @return a non-committal string
 */
private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "Try harder.";
        } else if (whichResponse == 5) {
            response = "Why are we still here? Just to suffer? "
                    + "Every night, I can feel my leg… and my arm… even my fingers. "
                    + "The body I’ve lost… the comrades I’ve lost… won’t stop hurting… "
                    + "It’s like they’re all still there. You feel it, too, don’t you?";
        }
        return response;
    }// closes random Response

    /**
     * Search for one word in phrase. The search is not case sensitive. This
     * method will check that the given goal is not a substring of a longer
     * string (so, for example, "I know" does not contain "no").
     *
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if
     * it's not found
     */
    private int findKeyword(String statement, String goal,
            int startPos) {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0) {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0) {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length()) {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0))) {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case sensitive. This
     * method will check that the given goal is not a substring of a longer
     * string (so, for example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     *
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if
     * it's not found
     */
    private int findKeyword(String statement, String goal) {
        return findKeyword(statement, goal, 0);
    }

    /**
     * Take a statement with "I want to <something>." and transform it into
     * "What would it mean to <something>?"
     *
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantToStatement(String statement) {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }
        private String transformIWantStatement(String statement) {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Can you handle the responsibility of " + restOfStatement + "?";
    }
     private String transformIYouStatement(String statement) {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }

        int psnOfI = findKeyword(statement, "I", 0);
        int psnOfYou = findKeyword(statement, "you", psnOfI + 1);


        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "How dare you " + restOfStatement + " me, scum?";
    }

    /**
     * Take a statement with "you <something> me" and transform it into "What
     * makes you think that I <something> you?"
     *
     * @param statement the user statement, assumed to contain "you" followed by
     * "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement) {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement
                    .length() - 1);
        }

        int psnOfYou = findKeyword(statement, "you", 0);
        int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

}
