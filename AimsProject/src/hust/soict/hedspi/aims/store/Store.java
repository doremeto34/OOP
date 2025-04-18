package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {

	// Max number of disc
	public static final int MAX_NUMBERS_STORED = 36;
		
	// disc array
	private DigitalVideoDisc itemsInStore[] =
			new DigitalVideoDisc[MAX_NUMBERS_STORED];
	
	private int qtyStored;
	// add dvd
	public void addDVD(DigitalVideoDisc disc) {
		if(qtyStored==MAX_NUMBERS_STORED)
			System.out.println("Store is almost full");
		else {
			itemsInStore[qtyStored]=disc;
			++qtyStored;
			System.out.println("Disc added to store");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyStored==0)
			System.out.print("Store is empty");
		else {
			for(int i=0;i<=qtyStored;++i) {
				if(itemsInStore[i]==disc) {
					for(int j=i;j<qtyStored;++j)itemsInStore[j]=itemsOrdered[j+1];
					--qtyOrdered;
					break;
				}
				if(i==qtyOrdered)System.out.println("Not found");
			}
		}
	}
}
