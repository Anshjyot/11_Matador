package game;

public class DieCup {
        Dice[] dice;

        public DieCup(int numDice)
        {
            this.dice = new Dice[numDice];
            for(int i = 0; i<numDice; i++)
                dice[i] = new Dice();
        }

        public void rollDice(){
            int[] results = new int[this.dice.length];
            for(int i = 0; i<this.dice.length; i++)
                results[i] = dice[i].roll();
        }

        public int getSum(){
            int result = 0;
            for(int i = 0; i<this.dice.length; i++){
                result += dice[i].getEyes();
            }

            return result;
        }
    }

