CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `address_line3` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id`),
  KEY `storeIdKeygen_idx` (`store_id`),
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `storeIdKeygen` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `brand` (
  `brand_id` bigint(20) NOT NULL,
  `brand_description` varchar(255) DEFAULT NULL,
  `brand_image` varchar(255) DEFAULT NULL,
  `brand_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `cart_item` (
  `item_id` bigint(20) NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `item_discount` double DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `item_total_price` double DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `quantity` bigint(10) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKf9e1brwb4ea9cxtvxbs0wugdt` (`cart_id`),
  CONSTRAINT `FKf9e1brwb4ea9cxtvxbs0wugdt` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL,
  `category_description` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `storeidkeyreference_idx` (`store_id`),
  CONSTRAINT `storeidkeyreference` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `order` (
  `order_id` bigint(20) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `last_updated_date` datetime DEFAULT NULL,
  `order_email` varchar(45) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `address_line1` varchar(255) DEFAULT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `address_line3` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` bigint(20) DEFAULT NULL,
  `order_status` varchar(100) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id_key_idx` (`user_id`),
  CONSTRAINT `user_id_key` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `order_line` (
  `order_line_id` bigint(20) NOT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `cart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`order_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_status` (
  `status_id` bigint(20) NOT NULL,
  `status_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_price` double DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `msrp` double DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `supplier_price` double DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FKjlfidudl1gwqem0flrlomvlcl` (`store_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `FKjlfidudl1gwqem0flrlomvlcl` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `product_group` (
  `product_group_id` bigint(20) NOT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `product_group_name` varchar(255) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_group_id`),
  KEY `FKp5jgqd81picb3ig57jcgc29u8` (`store_id`),
  CONSTRAINT `FKp5jgqd81picb3ig57jcgc29u8` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `product_group_product` (
  `product_group_product_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_group_product_id`),
  KEY `FK2dl5ei533oxftyieeiru4icw9` (`product_group_id`),
  CONSTRAINT `FK2dl5ei533oxftyieeiru4icw9` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`product_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `shopping_cart` (
  `cart_id` bigint(20) NOT NULL,
  `cart_total` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK254qp5akhuaaj9n5co4jww3fk` (`user_id`),
  CONSTRAINT `FK254qp5akhuaaj9n5co4jww3fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `store` (
  `store_id` bigint(20) NOT NULL,
  `store_description` varchar(255) DEFAULT NULL,
  `store_image` varchar(255) DEFAULT NULL,
  `product_group_id` bigint(20) DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `is_user` bit(1) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` bigint(20) DEFAULT NULL,
  `store_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK1k3x2kt9pxcmon8jhquv31qe4` (`store_id`),
  CONSTRAINT `FK1k3x2kt9pxcmon8jhquv31qe4` FOREIGN KEY (`store_id`) REFERENCES `store` (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




