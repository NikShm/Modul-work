INSERT INTO brand (name)
VALUES
    ('Maybelline New York'),
    ('Loreal Paris'),
    ('Artdeco'),
    ('Lamel Professional');

INSERT INTO product (name, description, brandId, price, category, color, volume, photoPath)
VALUES
    ('Lash Sensational', 'Drive crazy and delight with just one look.
 Take care of your lashes with Maybelline New York Mascara.', 1, 245, 'makeup',
     '#000000', '9.5 ml', ''),
    ('Color Riche Ultra Matte', 'Ultra-matte lipstick', 2, 284, 'makeup', '#9f5057',
     '4.5 ml', '');