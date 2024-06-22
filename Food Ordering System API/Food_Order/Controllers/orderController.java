package Food_Order.Controllers;
import Food_Order.Models.Order;
import Food_Order.Service.Impl.OrderServiceImpl;
public class orderController {
    OrderServiceImpl orderService = new OrderServiceImpl();
    public void place_Order(Order order){
        orderService.placeOrder(order);
    }
    public void checkStatus(String cusId){
        orderService.getOrdersByCustomerId(cusId);
    }
    //For Restaurant
    public void viewOrder(String resid){
        orderService.getOrdersByRestaurantId(resid);
    }
    public void updateOrderStatus(String oId,String status){
        orderService.updateOrderStatus(oId,status);
    }

}
