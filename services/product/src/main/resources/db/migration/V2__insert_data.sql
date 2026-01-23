-- CATEGORIES (IDS FIXOS)
INSERT INTO category (id, name, description) VALUES
    (1, 'Electronics', 'Electronic devices and accessories'),
    (2, 'Books', 'Books and educational materials'),
    (3, 'Clothing', 'Men and women clothing'),
    (4, 'Home Appliances', 'Appliances for home use');

-- PRODUCTS
INSERT INTO product (
    id,
    name,
    description,
    available_quantity,
    price,
    category_id
)
VALUES
    (nextval('product_seq'), 'Laptop Dell Inspiron', '15-inch laptop with Intel i5 processor', 10, 3500.00, 1),
    (nextval('product_seq'), 'Wireless Mouse', 'Ergonomic wireless mouse', 50, 120.00, 1),
    (nextval('product_seq'), 'Spring Boot in Action', 'Book about Spring Boot framework', 25, 180.00, 2),
    (nextval('product_seq'), 'Clean Code', 'A Handbook of Agile Software Craftsmanship', 30, 200.00, 2),
    (nextval('product_seq'), 'Men T-Shirt', 'Cotton t-shirt size M', 40, 60.00, 3),
    (nextval('product_seq'), 'Women Jacket', 'Winter jacket size L', 15, 350.00, 3),
    (nextval('product_seq'), 'Microwave Oven', '800W microwave oven', 8, 900.00, 4);