package com.aska.store.transformer;

import com.aska.store.common.Constants;
import com.aska.store.model.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartToOrderTransformer {

    public OrderDTO transform(final ShoppingCartDTO sessionCart, final AddressDTO deliveryAddress,final UserDTO user){
        final OrderDTO orderDTO = new OrderDTO();
        final List<OrderLineDTO> orderLines = sessionCart.getCartItems().stream().map(this::transform).collect(Collectors.toList());

        orderDTO.setOrderEmail(user.getEmail());
        orderDTO.setPhoneNumber(user.getPhoneNumber());
        orderDTO.setAddressLine1(deliveryAddress.getAddressLine1());
        orderDTO.setAddressLine2(deliveryAddress.getAddressLine2());
        orderDTO.setAddressLine3(deliveryAddress.getAddressLine3());
        orderDTO.setCity(deliveryAddress.getCity());
        orderDTO.setState(deliveryAddress.getState());
        orderDTO.setPinCode(deliveryAddress.getPostalCode());
        orderDTO.setOrderTotal(sessionCart.getCartTotal());

        orderDTO.setOrderLines(orderLines);
        return orderDTO;
    }
    public OrderLineDTO transform(final ShoppingCartItemDTO shoppingCartItemDTO){
        final OrderLineDTO orderLineDTO = new OrderLineDTO();
        orderLineDTO.setProductId(shoppingCartItemDTO.getProductId());
        orderLineDTO.setProductName(shoppingCartItemDTO.getProductName());
        orderLineDTO.setQuantity(shoppingCartItemDTO.getQuantity());
        orderLineDTO.setPrice(shoppingCartItemDTO.getLineItemTotal());
        return orderLineDTO;
    }
}
