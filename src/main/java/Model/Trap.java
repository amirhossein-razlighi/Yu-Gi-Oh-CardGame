package Model;

import Model.Effects.Effect;
import Model.Effects.falseEffect;

public class Trap extends Card {

    private String status;
    private  Boolean canBeActive = true;
    private boolean isDestructive = false;
    private Effect effect;

    public Trap(String name, Type type) {
        super(name, type);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDestructive(boolean destructive) {
        isDestructive = destructive;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public boolean getIsDestructive () {
        return isDestructive;
    }

    public void setCanBeActive(Boolean canBeActive) {
        this.canBeActive = canBeActive;
    }

    public Boolean getCanBeActive() {
        return canBeActive;
    }

    public String getStatus() {
        return status;
    }

    public Effect getEffect() {
        return effect;
    }

    public void giveEffect() {
        effect = new falseEffect(this);
    }

    @Override
    public Object clone() {
        Trap trap = new Trap(this.getName(), this.getCardType());
        trap.setDescription(this.getDescription());
        trap.setPrice(this.getPrice());
        trap.setStatus(this.getStatus());
        trap.setAttackPosition(this.getAttackPosition());
        trap.setOccupied(this.getOccupied());
        trap.setSelected(this.getSelected());
        return trap;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nTrap" +
                "\nType: " + this.getCardType() +
                "\nDescription: " + this.getDescription();
    }
}
