package Model.Zahra;

import Model.Board;
import Model.Card;
import Model.Spell;
import Model.Type;

public class Raigeki extends Spell {

    public Raigeki() {
        super("Raigeki", Type.SPELL);
    }

    public void specialAction (Board rivalBoard) {
        //cats in control are those in the field
        for (Card monster : rivalBoard.getMonstersZone()) {
            rivalBoard.getMonstersZone().remove(monster);
            rivalBoard.getGraveYard().add(monster);
        }
    }
}
