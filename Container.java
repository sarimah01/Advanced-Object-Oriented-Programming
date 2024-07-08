package lab6;

import java.io.*;
import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
/**
 * The {@code Container} class is a generic container that can hold objects. It
 * provides methods for adding and removing objects, as well as querying the
 * size of the container.
 * Your implementation of this class or methods should not contains:
 * 1. No System.out.println statements should appear here. Instead, you need to
 * return the result. 2. No Scanner operations should appear here (e.g.,
 * input.nextInt()). Instead, refer to the input parameters of this method.
 *
 *
 */
public class Container {
	// No instance variable should be defined for this class.
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private ArrayList<Order> orders = new ArrayList<>();
	public void add(Order order) {
		orders.add(order);
		
	}
	public Order remove() {
		if (!orders.isEmpty()) {
            return orders.remove(0);
        }
        return null;
		
	}
	public int getSize() {
		return orders.size();
		
	}
	
	
}

/**
 * The {@code Queue} class simulates a queue data structure, inserting and
 * removing data by the FIFO (first-in, first-out) rule. It stores orders with a
 * total amount above or equal to 1500 in the queue.
 *
 */
class Queue extends Container {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private ArrayList<Order> queue ;
	public Queue (String fileName) {
		queue = new ArrayList<>();
	      List<String> orderStrings = IOHandler.readFile(fileName);
	        for (String orderString : orderStrings) {
	            String[] orderData = orderString.split(", ");
	            if (orderData.length == 5) {
	                int orderId = Integer.parseInt(orderData[0]);
	                String customerName = orderData[1];
	                String productName = orderData[2];
	                int quantity = Integer.parseInt(orderData[3]);
	                double unitPrice = Double.parseDouble(orderData[4]);
	                Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
	                add(order);
	            }
	        }
	    }

	class Stack extends Container {
	    private ArrayList<Order> stack;

	    public Stack(String filename) {
	        stack = new ArrayList<>();
	        List<String> orderStrings = IOHandler.readFile(filename);
	        for (String orderString : orderStrings) {
	            String[] orderData = orderString.split(", ");
	            if (orderData.length == 5) {
	                int orderId = Integer.parseInt(orderData[0]);
	                String customerName = orderData[1];
	                String productName = orderData[2];
	                int quantity = Integer.parseInt(orderData[3]);
	                double unitPrice = Double.parseDouble(orderData[4]);
	                Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
	                add(order);
	            }
	        }
	    }

	}
	public void add(Order order) {
		 if (order.getTotalAmount() >= 1500) {
	            queue.add(order);
	        }
		
	}
	public Order remove() {
		if (!queue.isEmpty()) {
            return queue.remove(0);
        }
        return null;
		
	}
	public Order top() {
		if (!queue.isEmpty()) {
            return queue.get(0);
        }
        return null;
		
	}
	public int getSize() {
		return queue.size();
	}

	
}

/**
 * The {@code Stack} class simulates a stack data structure, inserting and
 * removing data by the FILO (first-in, last-out) rule. It stores orders with a
 * total amount below 1500 in the stack.
 *
 */
class Stack extends Container {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private ArrayList<Order> stack ;
	
	public Stack(String filename) {
		stack = new ArrayList<>();
		List<String> orderStrings = IOHandler.readFile(filename);
        for (String orderString : orderStrings) {
            String[] orderData = orderString.split(", ");
            if (orderData.length == 5) {
                int orderId = Integer.parseInt(orderData[0]);
                String customerName = orderData[1];
                String productName = orderData[2];
                int quantity = Integer.parseInt(orderData[3]);
                double unitPrice = Double.parseDouble(orderData[4]);
                Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
                add(order);
            }
        }
	}
	public void add(Order order) {
		if (order.getTotalAmount() < 1500) {
            stack.add(order);
        }
		
	}
	public Order remove() {
		if (!stack.isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return null;
		
	}
	public Order top(){
		if (!stack.isEmpty()) {
	        return stack.get(stack.size() - 1);
	    }
	    return null;
	}
	public int getSize() {
		return stack.size();
		
	}

	
}

/**
 * The {@code IOHandler} class provides static methods for handling input and
 * output operations with files. It allows reading content from a file and
 * writing content to a file.
 *
 */

class IOHandler {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	public static List <String> readFile(String fileName){
		try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
		
	}
	public static void writeFile(String fileName, List <String> content) {
		try {
            Files.write(Paths.get(fileName), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	
}

/**
 * The {@code Order} class represents an order in the order processing system.
 * It encapsulates information about the order such as order ID, customer name,
 * product name, quantity, and unit price.
 *
 */
class Order {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	private String customerName;
	private int orderId;
	private String productName;
	private int quantity;
	private double unitPrice;
	
	public Order(int orderId, String customerName, String productName, int quantity, double unitPrice) {
		this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
	}
	public double getTotalAmount() {
		double total = quantity * unitPrice;
		return total;
	}
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", orderId=" + orderId + ", productName=" + productName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	
	
}