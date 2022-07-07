INSERT INTO brand (name)
VALUES
    ('Maybelline New York'),
    ('Loreal Paris'),
    ('Artdeco'),
    ('Lamel Professional'),
    ('NYX');

INSERT INTO product (name, description, brandId, price, category, color, volume, photoPath)
VALUES
    ('Lash Sensational', 'Drive crazy and delight with just one look.
 Take care of your lashes with Maybelline New York Mascara.', 1, 8.29, 'MAKEUP',
     '#000000', '9.5 ml', 'assets/images/makeup/maybelline-lash-sensational-mascara.jpg'),
    ('Color Riche Ultra Matte', 'Ultra-matte lipstick', 2, 9.61, 'MAKEUP', '#9f5057',
     '4.5 ml', 'assets/images/makeup/loreal-ultra-riche-matte-lipstick.jpg'),
    ('Concealer Wand', 'Great liquid Concealer Wand concealer, thanks to which you can easily hide any imperfections and darkening in the eye area.', 5, 9.44, 'MAKEUP',
     '#f6e6d3', '3 g', 'assets/images/makeup/nyx-concealer-wand.jpg'),
    ('Eyeshadow Base', 'Eyeshadow Base with a delicate, creamy consistency.', 3, 6.26, 'MAKEUP',
     '#d8b590', '5 ml', 'assets/images/makeup/artdeco-eyeshadow-base.jpg'),
    ('Eyeshadow Pearl', 'Deep shades of eyeshadow paired with a light pearlescent shade.', 3, 3.11, 'MAKEUP',
     '#dfb5c5', '0.8 g', 'assets/images/makeup/artdeco-eyeshadow-pearl.jpg'),
    ('Alliance Perfect', 'Light facial foundation with hyaluronic acid. The innovative formula of the tonal cream will make your makeup perfect and elegant, giving your face purity, mystery and a gentle glow.', 2, 8.12, 'MAKEUP',
     '#fbd3b3', '30 ml', 'assets/images/makeup/loreal-alliance-perfect.jpg'),
    ('True Match', 'True Match high-quality face concealer will help quickly and effectively hide redness, small pimples, signs of fatigue and dark circles under the eyes, giving the skin a healthy glow.', 2, 6.22, 'MAKEUP',
     '#efcfb8', '6.8 ml', 'assets/images/makeup/loreal-true-match.jpg');