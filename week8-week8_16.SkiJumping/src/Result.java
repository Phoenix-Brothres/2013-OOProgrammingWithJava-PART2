import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WONSEOB
 */
publicpublic class Result {
    private int length;
    private int[] votes;
    private Random randomGenerator = new Random();
    
    public Result() {
        this.length = randomGenerator.nextInt(61) + 60;
        this.votes = new int[5];
        for (int i = 0; i < 5; i++) {
            votes[i] = randomGenerator.nextInt(11) + 10;
        }
    }

    public int getLength() {
        return this.length;
    }

    public String getVotes() {
        String returnStr = "[";
        for (int i = 0; i < 4; i++) {
            returnStr = returnStr + votes[i] + ", ";
        } 
        returnStr = returnStr + votes[4] + "]";
        return returnStr;
    }
    
    public int getPoint() {
        return this.length + this.takeValidVotes();
    }
    
    private int takeValidVotes() {
        int validVotesTotal = 0;
//      fitst sort votes then leaving out min and max by adjusting the enumerator
        Arrays.sort(votes);
        for (int i = 1; i < this.votes.length-1; i++) {
            validVotesTotal += this.votes[i]; 
        }
        return validVotesTotal;
    }
    
}
