package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.service.mapper.resolver.OrderMapperResolver;
import com.dark.webshop.service.model.OrderModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderMapperResolver.class})
public interface OrderServiceMapper {

    OrderModel entityToModel(Order order);

    Order modelToEntity(OrderModel orderModel);
}
