package Game.Object;

public class Player {
       private int lives = 20;
       private int moneys = 80;

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

}
