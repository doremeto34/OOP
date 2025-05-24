package hust.soict.hedspi.aims.media;

import java.util.Comparator;

import hust.soict.hedspi.aims.exception.PlayerException;

public abstract class Media implements Comparable<Media> {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {
		// TODO Auto-generated constructor stub
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	void setCost(float cost) {
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Media)) return false;
	    Media other = (Media) obj;
	    if (this.title == null || other.title == null) return false;
	    return this.title.equalsIgnoreCase(other.title) && this.cost == other.cost;
	}
	
	public int compareTo(Media other) {
	    if (other == null) {
	        throw new NullPointerException("Compared Media is null");
	    }
	    if (this.title.equalsIgnoreCase(other.title)) {
	        return Float.compare(this.cost, other.cost);
	    }
	    return this.title.compareToIgnoreCase(other.title);
	}
	public void play() throws PlayerException {
		
	}
}
