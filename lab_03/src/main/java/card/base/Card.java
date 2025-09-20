package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {
    private String name;
    private String flavorText;
    private int bloodCost;

	public Card(String name, String flavorText, int bloodCost) {
        setName(name);
        setFlavorText(flavorText);
        setBloodCost(bloodCost);
	}
		
	public abstract String toString();
	
	public String getName() {
        return name;
	}

	public int getBloodCost() {
        return bloodCost;
	}

	public String getFlavorText() {
        return flavorText;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public void setBloodCost(int bloodCost) {
        this.bloodCost = Math.max(bloodCost, 0);
    }

    /// You can modify code above ///
	
	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
		}  

	
}