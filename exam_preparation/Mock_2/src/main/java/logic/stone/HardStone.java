package logic.stone;

public class HardStone extends Stone {
    protected int durability;

    public HardStone(int posX, int posY, int durability) {
        super(posX, posY);
        setDurability(durability);
    }

    public void dig(int digPower) {
        durability = Math.max(0, this.durability - digPower);
        if (durability == 0) {
            destroy();
        }
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = Math.min(Math.max(durability, 0), 5);
    }
}
