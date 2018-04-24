package lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CartAction {

	public static void main(String[] args) throws IOException {
		String s;
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1001, "name1", 2, "description1", 3));
		itemList.add(new Item(1002, "name2", 4, "description2", 4));
		itemList.add(new Item(1003, "name3", 3, "description3", 5));
		itemList.add(new Item(1004, "name4", 5, "description4", 6));
		itemList.add(new Item(1005, "name5", 6, "description5", 5));
		Hashtable<Integer, Integer> cart = new Hashtable<>();
		LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();

		// for(int i = 0; i < itemList.size(); i++) {
		// cart.put(itemList.get(i).getId(), itemList.get(i).getQuantity());
		// }
		System.out.println("Welcome to the store!" + System.lineSeparator()
				+ "Here is the commands you can type and press ENTER, when you done write EXIT" + System.lineSeparator()
				+ "-to print all the items enter \"show items\"" + System.lineSeparator()
				+ "-to add item to your cart write \"add+id\"" + " example \"add 0001\"" + System.lineSeparator()
				+ "-to print all the items from your cart  input " + "\"show cart\"" + System.lineSeparator()
				+ "-to go to checkout write " + "\"checkout\"" + System.lineSeparator()
				+ "-to show last 5 added enter \"last added\"");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			s = reader.readLine();
			if (!s.equalsIgnoreCase("exit")) {
				if (s.equalsIgnoreCase("show items")) {
					printAllList(itemList);
				} else if ((s.substring(0, 3).equalsIgnoreCase("add"))) {
					if (s.length() < 8) {
						System.out.println("id not found");
					} else {
						addingItems(s, itemList, cart, lhm);
					}
				} else if (s.equalsIgnoreCase("show cart")) {
					showCart(itemList, cart);
				} else if (s.equalsIgnoreCase("checkout")) {
					checkout(itemList, cart);
				} else if (s.equalsIgnoreCase("last added")) {
					lastAdded(itemList, lhm);
				}
			} else {
				System.out.println("You have exited from the store");
				break;
			}
		}
	}

	public static void printAllList(List<Item> itemList) {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println("id:" + String.format("%04d", itemList.get(i).getId()) + " name: "
					+ itemList.get(i).getName() + " price: " + itemList.get(i).getPrice() + "$ description: "
					+ itemList.get(i).getDescription());
		}
	}

	public static void addingItems(String s, List<Item> list, Hashtable<Integer, Integer> ht,
			LinkedHashMap<Integer, Integer> lhm) {
		int id = Integer.parseInt(s.substring(4, 8));
		int val;
		int amount = 1;
		if (ht.containsKey(id)) {
			val = ht.get(id);
			ht.put(id, val + 1);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (id == list.get(i).getId()) {
					ht.put(list.get(i).getId(), amount);
					lhm.put(list.get(i).getId(), amount);
				}
			}
		}
		System.out.println("item " + id + " was added to your cart");

	}

	public static void showCart(List<Item> list, Hashtable<Integer, Integer> map) {
		System.out.println("That's what you have in your cart");
		Set<Map.Entry<Integer, Integer>> showMap = map.entrySet();
		for (Map.Entry<Integer, Integer> a : showMap) {
			for (Item i : list) {
				if (i.getId() == a.getKey()) {
					System.out.println("id: " + a.getKey() + " name: " + i.getName() + " quantity: " + a.getValue()
							+ " item price: " + i.getPrice() + "$");
				}
			}
		}
	}

	public static void checkout(List<Item> list, Hashtable<Integer, Integer> map) {
		int totalVal = 0;
		System.out.println("Checkout");
		Set<Map.Entry<Integer, Integer>> showMap = map.entrySet();
		List<Integer> total = new ArrayList<>();
		for (Map.Entry<Integer, Integer> a : showMap) {
			for (Item i : list) {
				if (i.getId() == a.getKey()) {
					total.add(a.getValue() * i.getPrice());
					System.out.println("id: " + a.getKey() + " name: " + i.getName() + " quantity: " + a.getValue()
							+ " item price: " + i.getPrice() + "$");
				}

			}
		}
		for (int a : total) {
			totalVal += a;
		}
		System.out.println("Total price of your order is: " + totalVal + "$");
	}

	public static void lastAdded(List<Item> list, LinkedHashMap<Integer, Integer> map) {
		List<Integer> keyList = new ArrayList<>(map.keySet());

		if (keyList.size() >= 5) {
			for (int i = keyList.size(); i > keyList.size() - 5; i--) {
				System.out.println(keyList.get(i));
			}
		} else {
			for (int i : keyList) {
				for (Item a : list) {
					if (a.getId() == i) {
						System.out.println("id: " + a.getId() + " name: " + a.getName()
						+ " item price: " + a.getPrice() + "$");
					}
				}
			}
		}

	}
}