package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Date date = new Date();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sfd1 = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email :");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sfd1.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		
		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = sc.next();
		
		Order order = new Order(date, OrderStatus.valueOf(status), client);
		
		
		System.out.print("How many items to this order?");
		int items = sc.nextInt();
		
		OrderItem orderItem;
		
		for(int i=1;i<=items;i++) {
			System.out.println("Enter #"+i+" item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double ProductPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, ProductPrice);
			
			orderItem = new OrderItem(quantity, ProductPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		
	}

}
