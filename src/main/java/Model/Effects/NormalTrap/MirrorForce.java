package Model.Effects.NormalTrap;

import Client.Controller.Game;
import Model.Card;
import Model.Effects.Effect;
import Model.Spell;
import Model.Trap;
import Model.User;
import Client.View.GUI.GamePlay;
import javafx.scene.control.Alert;

public class MirrorForce extends Effect {

    private User owner;
    private User enemy;

    public MirrorForce(Card card) {
        super(card);
        speed = 2;
    }

    @Override
    public boolean activate(Game game) {
        game.setMirrorForceActivated(true);
        game.setDeclaredAttack(false);
        for (int i = 0; i < 5; i++) {
            Card enemyMonsterCard = game.originalCurrentUser.getBoard().getMonstersZone().get(i);
            if (enemyMonsterCard != null) {
                if (enemyMonsterCard.getOccupied()) {
                    game.addMonsterFromMonsterZoneToGraveyard(enemyMonsterCard, game.originalCurrentUser);
                }
            }
        }
        GamePlay.showAlert(Alert.AlertType.INFORMATION, "activate effect message", "trap activated");
        game.addSpellOrTrapFromZoneToGraveyard(card, owner);
        return true;
    }

    @Override
    public boolean canBeActivated(Game game) {
        if (game.getCurrentUser().getBoard().getAllCards().contains(card)) {
            owner = game.getCurrentUser();
            enemy = game.getOpponentOfCurrentUser();
        } else {
            owner = game.getOpponentOfCurrentUser();
            enemy = game.getCurrentUser();
        }
        // check Mirage Dragon
        for (int i = 0; i < 5; i++) {
            Card enemyMonster = enemy.getBoard().getMonstersZone().get(i);
            if (enemyMonster != null) {
                if (enemyMonster.getOccupied()) {
                    if (enemyMonster.getName().equals("Mirage Dragon")) {
                        return false;
                    }
                }
            }
        }
        if (game.originalCurrentUser.getBoard().getAllCards().contains(card)) {
            return false;
        }
        if (!game.isDeclaredAttack()) {
            return false;
        }
        if (game.getChain().size() != 0) {
            if (game.getChain().get(game.getChain().size() - 1) instanceof Spell) {
                if (((Spell) game.getChain().get(game.getChain().size() - 1)).getEffect().getSpeed() > speed) {
                    return false;
                }
            } else {
                if (((Trap) game.getChain().get(game.getChain().size() - 1)).getEffect().getSpeed() > speed) {
                    return false;
                }
            }
        }
        return true;
    }
}
