package model;

import java.io.Serializable;

public abstract class AbstractForm implements IWeight, Serializable {

	protected Wood wood;

	public AbstractForm() {
		super();
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	/*public Wood getWood() {
		return wood;
	}*/
	public abstract float volume();

	public float weight() {
		return wood.getDensity() * volume();
	}

}