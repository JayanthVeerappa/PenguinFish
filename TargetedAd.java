/*
 * Problem 2.3.1 Sell My Pet Food
 */
public class TargetedAd
{

  public static void main(String[] args)
  {

    DataCollector dc = new DataCollector();
    // Calls setData() to load social media posts
    dc.setData("socialMediaPostsSmall.txt", "targetWords.txt");

    // build list of usernames
    String matchedUsers = "";
    
    // iterate through posts
    String post;

    while (!(post = dc.getNextPost()).equals("NONE"))
      {
        // Converts post to lowercase 
        String postLower = post.toLowerCase();
        
        // Extracts username
        String username = post.split(" ")[0];

        // Calls getNextTargetWord() accessor to iterateate through target words
        String word;
        while (!(word = dc.getNextTargetWord()).equals("NONE"))
          {
            // Uses indexOf() to check if target word appears in lowercase post
            if (postLower.indexOf(word.toLowerCase()) != -1)
              {
                // Checks for duplicates
                if (matchedUsers.indexOf(username) == -1)
                  {
                    // username with space separator
                    matchedUsers += username + " ";
                  }
                break;
              }
          }
      }

    //message
    String advertisement = "Check out our premium penguin food - specially formulated for your feathery friend!";
    
    // write output file
    dc.prepareAdvertisement("targetedUsers.txt", matchedUsers, advertisement);
    
    System.out.println("Advertisement file created: targetedUsers.txt");
    System.out.println("Targeted users: " + matchedUsers);
  }
}
