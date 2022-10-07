package model;

import java.io.Serializable;
import java.util.Objects;

public class Wood implements Serializable, Comparable{
		
		@Override
	public int hashCode() {
		return Objects.hash(density, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wood other = (Wood) obj;
		return Float.floatToIntBits(density) == Float.floatToIntBits(other.density) && id == other.id
				&& Objects.equals(name, other.name);
	}
		private String name;
		private int id;
        private float density;
        public Wood(String name, int id, float density) {
			this.name = name;
			this.id = id;
			this.density = density;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getDensity() {
			return density;
		}
		public int getId() {
			return id;
		}
		public void setDensity(float density) {
			this.density = density;
		}
		@Override
		public String toString() {
			return "Wood [name=" 
		+ name + ", id=" + id + ", "
				+ "density=" + density + "]\n";
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
        
        
}
