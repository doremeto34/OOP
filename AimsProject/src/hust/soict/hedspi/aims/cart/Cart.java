package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.*;

public class Cart {
	// Max number of disc
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	// disc array
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	// disc count
	private int qtyOrdered;
	
	// add disc
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered==20)
			System.out.println("The cart is almost full");
		else {
			itemsOrdered[qtyOrdered]=disc;
			++qtyOrdered;
			System.out.println("The disc has been added");
		}
	}
	
	// add disc list
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc disc:dvdList)addDigitalVideoDisc(disc);
	}
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc... arbitraryDvd) {
		for (DigitalVideoDisc disc : arbitraryDvd) addDigitalVideoDisc(disc);
	}
	*/
	
	// remove disc
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered==0)
			System.out.print("The cart is empty");
		else {
			for(int i=0;i<=qtyOrdered;++i) {
				if(itemsOrdered[i]==disc) {
					for(int j=i;j<qtyOrdered;++j)itemsOrdered[j]=itemsOrdered[j+1];
					--qtyOrdered;
					break;
				}
				if(i==qtyOrdered)System.out.println("Not found");
			}
		}
	}	
	
	// get cost
	public float totalCost() {
		float sum=0;
		for(int i=0;i<qtyOrdered;++i)sum+=itemsOrdered[i].getCost();
		return sum;
	}
	
	// print cart
	public void print() {
		if(qtyOrdered==0)
			System.out.print("The cart is empty");
		else {
			System.out.println("***********************CART***********************");
			for(int i=0;i<qtyOrdered;++i) {
				System.out.println(
						i+1 + ". " +
						"DVD - " + 
						itemsOrdered[i].getTitle()+" - " +
						itemsOrdered[i].getCategory()+" - " +
						itemsOrdered[i].getDirector()+" - " +
						itemsOrdered[i].getLength()+": " +
						itemsOrdered[i].getCost()+" $"
				);
			}
			System.out.println("Total cost: " + totalCost());
			System.out.println("**************************************************");
			
		}
	}
	
	// search by ID
	public void seachByID(int id) {
		if(qtyOrdered==0)
			System.out.print("The cart is empty");
		else {
			int discCnt = 0;
			for(int i=0;i<qtyOrdered;++i) {
				if(itemsOrdered[i].isMatchID(id)) {
					System.out.println(
							i+1 + ". " +
							"DVD - " + 
							itemsOrdered[i].getTitle()+" - " +
							itemsOrdered[i].getCategory()+" - " +
							itemsOrdered[i].getDirector()+" - " +
							itemsOrdered[i].getLength()+": " +
							itemsOrdered[i].getCost()+" $"
					);
					++discCnt;
				}
			}
			if(discCnt == 0)System.out.println("No DVD with alike ID found");
		}
	}
	
	// search by title
	public void seachByTitle(String title) {
		if(qtyOrdered==0)
			System.out.print("The cart is empty");
		else {
			int discCnt = 0;
			for(int i=0;i<qtyOrdered;++i) {
				if(itemsOrdered[i].isMatchTitle(title)) {
					System.out.println(
							i+1 + ". " +
							"DVD - " + 
							itemsOrdered[i].getTitle()+" - " +
							itemsOrdered[i].getCategory()+" - " +
							itemsOrdered[i].getDirector()+" - " +
							itemsOrdered[i].getLength()+": " +
							itemsOrdered[i].getCost()+" $"
					);
					++discCnt;
				}
			}
			if(discCnt == 0)System.out.println("No DVD with alike title found");
		}
	}
}
 
 