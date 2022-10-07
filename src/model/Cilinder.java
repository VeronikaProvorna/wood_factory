package model;

import java.util.Objects;

public class Cilinder extends AbstractForm {
    private float length;
    private float diameter;
	@Override
	public float volume() {
	    float v = 3.1415927F * this.diameter / 2.0F * this.diameter / 2.0F * this.length;
		return v;
	}
	public Cilinder(float length, float diameter, Wood wood) throws Exception{
		super();
		setLength(length);
		setDiameter(diameter);
		this.wood=wood;
	}
	public float getLength() {
		return length;
	}
	public float getDiameter() {
		return diameter;
	}
	@Override
	public String toString() {
		return "Cilinder [wood="+wood.getName()+","
				+ " length=" + length + ","
						+ " volume()=" + volume() + "]\n";
	}
	public void setLength(float length) throws Exception{
		if(length < 0f || length > 40f)
			throw new Exception(length + " is not correct length.\n"
					+"The length must be from 0 to 40 m.");
		this.length = length;
	}
	public void setDiameter(float diameter) throws Exception{
		if(diameter <0f || diameter > 30f)
			throw new Exception(diameter+" is not correct diameter.\n" 
					+"The diameter must be from 0to 30 m.");
		this.diameter = diameter;
	}
	@Override
	public String name() {
		return "Cilinder";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diameter, length);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cilinder other = (Cilinder) obj;
		return Float.floatToIntBits(diameter) == Float.floatToIntBits(other.diameter)
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length);
	}
	
	
}
