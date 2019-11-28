package Game.Object;

public class Player {
       private int lives = 25;
       private int moneys = 80;
       private int score = 0;

       public Player (){

       }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setMoney ( int  moneys ){
           this.moneys = moneys;
    }

    public int getLives() {
        return lives;
    }

    public int getMoneys() {
        return moneys;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
