//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
void main() {
    String[] mainBlades = {"Shark scale", "Scale shark", "Clock mirage"};//names of different blades
    int[] mainBladesNum = {0, 0, 1}; //convert the names into numbers as their are nicknames
    String[][] bits = {{ "LO", "LR", "R", "H"}, {"LO", "W", " ", " "} }; //matrix of bit options
    String[][] ratchets = {{ "3-60", "1-60", "1-70", "4-50"}, {"4-55", "7-55", " ", " "} }; //matrix of bit options
    System.out.println("welcome to the beyblade combo maker we will start by having you input what blade you want to use");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter blade name:");
    String bladeName = scanner.nextLine();//they enter the blade name
    int conversion = bladePartCheck(bladeName, mainBlades);
    if (conversion == -1) {
        randomBullshitGo();
    }
    else {
        String bladeChosen= mainBlades[conversion];//stores entered blade name
        int blade = mainBladesNum[conversion];//stores the blade type
        int done = 0;//checks if done
        System.out.println("Have you used any ratchets click enter if no enter the name if yes");
        while (done ==0) {
            System.out.println("Enter ratchet name:");
            String ratchetName;//they enter the ratchet name
            ratchetName = scanner.nextLine();
            if (ratchetName.equals("")) {
                done = 1; //stops checking for removed parts
            }
            else {
                removePart(ratchets, blade, ratchetName);
                System.out.println("Have you used any moreratchets click enter if no enter the name if yes");
            }
        }
        done = 0;
        while (done ==0) {
            System.out.println("Enter bit name:");
            String bitName = scanner.nextLine();//they enter the bit name
            if (bitName.equals("")) {
                done = 1;//stops checking for removed parts
            }
            else {
                removePart(ratchets, blade, bitName);
                System.out.println("Have you used any moreratchets click enter if no enter the name if yes");
            }
        }
        System.out.println("time to chose a ratchet");
        String ratchetChosen = partChoose (ratchets, blade);//they chose a ratchet
        System.out.println("time to chose a bit");
        String bitChosen = partChoose (bits, blade);//they chose a bit
        System.out.println("Your bey combo is: "+bladeChosen+" "+ratchetChosen+bitChosen);
    }
}

// used ap classroom find phrase find phrase code
private int findPhrase(String statement, String goal, int startPos)
{
    String phrase = statement.trim().toLowerCase();
    goal = goal.toLowerCase();

    int position = phrase.indexOf(goal, startPos);

    // Refinement--make sure the goal isn't part of a
    // word
    while (position >= 0)
    {
        // Find the string of length 1 before and after
        // the word
        String before = " ", after = " ";
        if (position > 0)
        {
            before = phrase.substring(position - 1, position);
        }
        if (position + goal.length() < phrase.length())
        {
            after = phrase.substring(position + goal.length(), position + goal.length() + 1);
        }

        // If before and after aren't letters, we've
        // found the word
        if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) // before is not a letter
                && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
        {
            return position;
        }

        // The last position didn't work, so let's find
        // the next, if there is one.
        position = phrase.indexOf(goal, position + 1);
    }
    return -1;
}
// end of ap classroom find phrase section
public int bladePartCheck(String statement, String[] mainBlades)
{
    for (int position = 0; position < (mainBlades.length); position += 1) //checks each main blade to see if it is in the statement
    {
        int location = findPhrase(statement, mainBlades[position], 0);
        if (location >= 0)
        {
            return position;
        }
    }
    return -1;
}

public String partChoose (String[][] partType, int blade)//partType can be ratchet assist blade or bit
{
    System.out.println("here are the recommended parts if you chose one enter the number next to it");
    System.out.println("");
    int usableParts = 0;//counts usable parts
    for (int position = 0; position < (partType.length); position += 1) //checks each main blade to see if it is in the statement
    {
        boolean b= !(partType[blade][position].equals(" "));//if there is
        if (b) {
            System.out.print(position +") " +partType[blade][position] +" "); //checks if their is a bit name in that location
            usableParts++;
        }
    }
    System.out.println("enter number");
    if (usableParts > 0) {
        Scanner scanner = new Scanner(System.in);
        int specificPart = scanner.nextInt();
        return partType[blade][specificPart];
    }
    else // this will give zero if no recommended parts are left
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter part as no recommended parts are left");
        String nonRecommendedPart = scanner.nextLine();//allows user to enter their own part
        return nonRecommendedPart;
    }
}

//i can remove parts now
public void removePart(String[][] partType, int blade, String name){ //they input part type the blade they inputed and the name of the part
    for (int position = 0; position < (partType[blade].length); position += 1) //checks each main blade to see if it is in the statement
    {
        boolean b= (partType[blade][position].equals(name));//checks if it works
        if (b) {
            partType[blade][position] = " "; //checks if their is a bit name in that location
        }
    }
}
private void randomBullshitGo()
{
    String[] bladesssss = {"BearScratch", "Bite Croc", "BlackShell", "Buster Dran", "Chewbacca", "CobaltDrake","Rock Leone", "Hover Wyvern"};//yes chewbacca is a beyblade
    String[] ratchetsssss = {"1-60", "4-70", "0-60", "4-55", "3-80", "M-85","9-60", "4-50"};//these are random parts i took off of the wiki
    String[] bitsssss = {"W", "H", "RA", "M", "TK", "N","U", "L"};
    int blade = (int)(Math.random() * bladesssss.length);//all of these give a random part
    int ratchet = (int)(Math.random() * ratchetsssss.length);
    int bit = (int)(Math.random() * bitsssss.length);
    System.out.println("you did not give a valid blade here is a combo could be good could be shit   "+bladesssss[blade]+ratchetsssss[ratchet]+bitsssss[bit]);
}