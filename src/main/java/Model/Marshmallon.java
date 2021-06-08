package Model;

public class Marshmallon extends Monster{
    private Card card;
    public Marshmallon() {
        super("Marshmallon", Type.FAIRY);
    }

    public void specialAction (boolean isNormalBattle, User rivalUser) {
        long lifePoint = rivalUser.getLifePoint();
       if (!isNormalBattle) {
           Card marshmallon = (Marshmallon) card;
           if (!marshmallon.getOccupied()) {
               rivalUser.setLifePoint(lifePoint);
           }
       }
    }
}
