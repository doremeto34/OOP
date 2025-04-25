package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	
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
		if(this == obj)return true;
		if (!(obj instanceof Media)) return false;
		Media other = (Media)obj;
		return title!=null && title.equalsIgnoreCase(other.title); 
	}
	
	public void play() {
		
	}
}
