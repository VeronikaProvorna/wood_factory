package model;

import java.io.Serializable;
import java.util.Objects;

public class Waste implements IWeight, Serializable {
    public float weight;
	@Override
	public float weight() {
		return weight;
	}
	public Waste(float weight) throws Exception{
		super();
		setWeight(weight);
	}
	@Override
	public String toString() {
		return "Waste [weight=" + weight + "]\n";
	}
	public void setWeight(float weight) throws Exception {
		if(weight < 20f || weight> 100f)
			throw new Exception(weight + 
					" is not correct weight.\n"
					+"The weight must be from 20 to 100 kg");
		this.weight = weight;
	}
	@Override
	public String name() {
		return "Waste";
	}
	@Override
	public int hashCode() {
		return Objects.hash(weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waste other = (Waste) obj;
		return Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
    
}
