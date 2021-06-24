package Model;

import Model.Effects.Effect;
import Model.Zahra.Icon;


public class Spell extends Card {

    private String status;
    private Icon icon;
    private Effect effect;

    public Spell(String name, Type type) {
        super(name, type);
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Effect getEffect() {
        return effect;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public Object clone() {
        Spell spell = new Spell(this.getName(), this.getCardType());
        spell.setDescription(this.getDescription());
        spell.setPrice(this.getPrice());
        spell.setStatus(this.getStatus());
        spell.setAttackPosition(this.getAttackPosition());
        spell.setOccupied(this.getOccupied());
        spell.setSelected(this.getSelected());
        spell.setEffect(this.getEffect());
        return spell;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nSpell" +
                "\nType: " + this.getCardType() +
                "\nDescription: " + this.getDescription();
    }
}
