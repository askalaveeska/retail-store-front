package com.aska.store.transformer;

import com.aska.store.model.ProductDTO;
import com.aska.store.model.ShoppingCartItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductToCartLineItemTransformer {
    public ShoppingCartItemDTO from(final ProductDTO productDTO){
        final ShoppingCartItemDTO shoppingCartItemDTO = new ShoppingCartItemDTO();
        return shoppingCartItemDTO;

    }
}
