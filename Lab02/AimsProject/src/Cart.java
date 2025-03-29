public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered==20)
			System.out.println("The cart is almost full");
		else {
			itemsOrdered[qtyOrdered]=disc;
			++qtyOrdered;
			System.out.println("The disc has been added");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc disc:dvdList)addDigitalVideoDisc(disc);
	}
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc... arbitraryDvd) {
		for (DigitalVideoDisc disc : arbitraryDvd) addDigitalVideoDisc(disc);
	}
	*/
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); 
        addDigitalVideoDisc(dvd2); 
    }
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
	public float totalCost() {
		float sum=0;
		for(int i=0;i<qtyOrdered;++i)sum+=itemsOrdered[i].getCost();
		return sum;
	}
	public void displayCart() {
		if(qtyOrdered==0)
			System.out.print("The cart is empty");
		else {
			for(int i=0;i<qtyOrdered;++i) {
				System.out.println(itemsOrdered[i].getTitle()
						+ " " + itemsOrdered[i].getLength()
						+ " " + itemsOrdered[i].getCost());
			}
		}
	}
}
 
 