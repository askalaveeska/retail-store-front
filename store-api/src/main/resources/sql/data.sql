INSERT INTO `STORE`.`store`
(`store_id`,
`store_description`,
`store_image`,
`store_name`)
VALUES
(1,
'B-Naturo Products',
'static/image/b-naturo.png',
'B-Naturo'):


INSERT INTO `STORE`.`address`
(`address_id`,
`address_line1`,
`address_line2`,
`address_line3`,
`city`,
`country`,
`postal_code`,
`state`,
`store_id`)
VALUES
(1,
'#63',
'Railway Station Road',
'Korattur',
'Chennai',
'India',
600080,
'TamilNadu',
1);


INSERT INTO `STORE`.`category`
(`category_id`,
`category_description`,
`category_name`,
`store_id`)
VALUES
(1,
'default category for all products',
'DEFAULT',
1
);

INSERT INTO `STORE`.`brand`
(`brand_id`,
`brand_description`,
`brand_image`,
`brand_name`)
VALUES
(
1,
'B-Naturo Products',
'/image/b-naturo.png',
'B-NATURO'
);


INSERT INTO `STORE`.`product`
(`product_id`,
`description`,
`discount_price`,
`is_active`,
`msrp`,
`product_name`,
`quantity`,
`supplier_price`,
`brand_id`,
`category_id`,
`store_id`)
VALUES
(1,
'Premium Rice 20 kgs',
0,
1,
1700,
'Premium Rice 20 Kgs',
10,
1700,
1,
1,
1
),
(2,
'Premium Rice 5 kgs',
0,
1,
425,
'Premium Rice 5 Kgs',
10,
425,
1,
1,
1
),

(3,
'Premium Rice 1 kgs',
0,
1,
85,
'Premium Rice 1 Kgs',
10,
85,
1,
1,
1
),

(4,
'Golden Raw Rice 20 kgs',
0,
1,
1700,
'Golden Raw Rice 20 Kgs',
10,
1700,
1,
1,
1
),

(5,
'Golden Raw Rice 5 kgs',
0,
1,
425,
'Golden Raw Rice 5 Kgs',
10,
425,
1,
1,
1
),


(6,
'Golden Raw Rice 1 kgs',
0,
1,
85,
'Golden Raw Rice 1 Kgs',
10,
85,
1,
1,
1
),

(7,
'Green Rice 20 kgs',
0,
1,
1600,
'Green Rice 20 Kgs',
10,
1600,
1,
1,
1
),

(8,
'Green Rice 5 kgs',
0,
1,
400,
'Green Rice 5 Kgs',
10,
400,
1,
1,
1
),

(9,
'Green Rice 1 kgs',
0,
1,
80,
'Green Rice 1 Kgs',
10,
80,
1,
1,
1
),


(10,
'Dia - Special Rice 1 Kgs',
0,
1,
85,
'Dia - Special Rice 1 Kgs',
10,
85,
1,
1,
1
);

INSERT INTO `STORE`.`product_group`
(`product_group_id`,
`is_active`,
`product_group_name`,
`store_id`)
VALUES
(1,
1,
'DEFAULT',
1);

INSERT INTO `STORE`.`product_group_product`
(`product_group_product_id`,
`product_id`,
`product_group_id`)
VALUES
(1,1,1),
(2,2,1),
(3,3,1),
(4,4,1),
(5,5,1),
(6,6,1),
(7,7,1),
(8,8,1),
(9,9,1),
(10,10,1);


