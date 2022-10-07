package model;

import java.util.Objects;

public class Timber extends AbstractForm {
	private float height;
	private float length;
	private float width;
	public Timber(Wood wood,
float height, float length, float width)throws Exception {
		this.wood = wood;
	    setHeight(height);
		setLength(length);
		setWidth(width);
	}
	public float getHeight() {
		return height;
	}
	@Override
	public int hashCode() {
		return Objects.hash(height, length, width);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timber other = (Timber) obj;
		return Float.floatToIntBits(height) == Float.floatToIntBits(other.height)
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length)
				&& Float.floatToIntBits(width) == Float.floatToIntBits(other.width);
	}
	public float getLength() {
		return length;
	}
	public float getWidth() {
		return width;
	}
	public float volume() {
		return this.length * this.height * this.width;
	}
	@Override
	public String toString() {
		return "Timber [wood=" 
	+ wood.getName() + ", weight()="
				+ weight() + "]\n";
	}
	public void setHeight(float height) throws Exception{
		if(height < 0f || height > 40f)
			throw new Exception(height+" is not correct height.\n"
					+"The height must be from 0 to 40 m.");
		this.height = height;
	}
	public void setLength(float length)throws Exception {
		if(length > 30f || length < 0f)
			throw new Exception(length+" is not correct length.\n"
					+"The length must be from 0 to 30 m.");
		this.length = length;
	}
	public void setWidth(float width) throws Exception{
		if(width <0.1f || width > 20f)
			throw new Exception(width+" is not correct width.\n"
					+"The width must be from 0.5 to 20 m.");
		this.width = width;
	}
	@Override
	public String name() {
		return "Timber";
	}
	
    
}
