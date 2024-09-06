package com.chethanawijesinghe.pointOfSales.service.serviceImpl;

import com.chethanawijesinghe.pointOfSales.config.ModelMappingConfig;
import com.chethanawijesinghe.pointOfSales.dto.RequestOrderSaveDTO;
import com.chethanawijesinghe.pointOfSales.entity.Order;
import com.chethanawijesinghe.pointOfSales.entity.OrderDetails;
import com.chethanawijesinghe.pointOfSales.repository.CustomerRepo;
import com.chethanawijesinghe.pointOfSales.repository.ItemRepo;
import com.chethanawijesinghe.pointOfSales.repository.OrderDetailsRepo;
import com.chethanawijesinghe.pointOfSales.repository.OrderRepo;
import com.chethanawijesinghe.pointOfSales.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;


    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId())){
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){
                    }.getType());
            for(int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "saved";

        }else{
            return null;
        }
    }


}
