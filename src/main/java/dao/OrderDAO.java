package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAO {
	private static List<Order> orders = new CopyOnWriteArrayList<Order>();
	
	public void save(Order order) {
		orders.add(order);
	}
	
	public List<Order> findAll() {
		return orders;
	}
	
	public void update(int index, Order newOrder) {
		orders.set(index, newOrder);
	}
	
	public void remove(int index) {
		orders.remove(index);
	}
	
	public Order getOrder(int index) {
		return orders.get(index);
	}
}
