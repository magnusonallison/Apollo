package seniorproject;
/**
 *
 * @author Santa Cardenas - Team Apollo Fall 2015 
 */
public class Main 
{
    public static void main(String args[]) 
  {
        //Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
             WelcomeGUI.createAndShowGUI();
            }
        });
    }
}

 
