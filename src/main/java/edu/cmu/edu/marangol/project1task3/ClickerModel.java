package edu.cmu.edu.marangol.project1task3;

/*
 * @author Martin Arango (marangol)
 *
 * This file is the model
 * It receives  answers from the controller (ClikcerServlet.java) through the addToCount
 * It resets the answers when the controller calls the resetClicker
 * It returns the answer counts when the controller asks
 * To run project remember to change the deployment application context to:
 * /Project1Task3-1.0-SNAPSHOT
 */
// Class with three member variables that represent the counts for each answer
public class ClickerModel {
    private int countA;
    private int countB;
    private int countC;
    private int countD;

// Method to reset clicker counts
    public void resetClicker(){
        countA = 0;
        countB = 0;
        countC = 0;
        countD = 0;
    }
// Method to add to the count depending on the answer
    public void addToCount(String answer){
        if (answer.equals("A")) {countA+=1;}
        else if (answer.equals("B")) {countB+=1;}
        else if (answer.equals("C")) {countC+=1;}
        else if (answer.equals("D")) {countD+=1;}
    }

    /*
     * Getters for the answer counts. Returns the counts
     */
    public int getCountA() {
        return countA;
    }

    public int getCountB() {
        return countB;
    }

    public int getCountC() {
        return countC;
    }

    public int getCountD() {
        return countD;
    }
}
