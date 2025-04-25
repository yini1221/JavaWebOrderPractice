package service;

import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import model.dto.OrderDTO;
import model.entity.Order;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();
	
	// 根據訂單項目(item)新增一筆訂單並回傳訂單顯示資訊(OrderDTO)
	public OrderDTO addOrder(String item) {
		Order order = new Order();
		order.setItem(item);
		order.setPrice(100);
		orderDAO.save(order);
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("您點了 " + order.getItem() + " 價格:" + order.getPrice() + "元");
		return orderDTO;
	}

	// 取得歷史資料
	public List<OrderDTO> getHistoryOrder() {
		List<Order> orders = orderDAO.findAll();
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for(Order order : orders) {
			OrderDTO dto = new OrderDTO();
			dto.setMessage("您點了 " + order.getItem() + " 價格:" + order.getPrice() + "元");
			orderDTOs.add(dto);
		}
		return orderDTOs;
	}

	// 刪除一筆訂單根據 index
	public OrderDTO removeOrder(int index) {
		orderDAO.remove(index);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + "資料刪除成功");
		return orderDTO;
	}

	// 修改單筆
	public OrderDTO updateOrder(int index, String newItem) {
		Order order = orderDAO.getOrder(index);
		order.setItem(newItem);
		order.setPrice(100);
		orderDAO.update(index, order);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + "資料修改成功");
		return orderDTO;
	}
}
