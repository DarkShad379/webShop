package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.service.mapper.resolver.OrderMapperResolver;
import com.dark.webshop.service.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrderMapperResolver.class})
public interface OrderServiceMapper {
    OrderServiceMapper  INSTANCE = Mappers.getMapper(OrderServiceMapper.class);
    OrderModel orderToOrderModel(Order order);
    Order orderModelToOrder(OrderModel orderModel);
}
