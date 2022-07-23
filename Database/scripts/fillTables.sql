INSERT INTO brand (name)
VALUES
    ('Maybelline New York'),
    ('Loreal Paris'),
    ('Artdeco'),
    ('Lamel Professional'),
    ('NYX'),
    ('Estee Lauder');

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
     '#efcfb8', '6.8 ml', 'assets/images/makeup/loreal-true-match.jpg'),
    ('Futurist Aqua Brilliance Makeup SPF 20', 'Illuminate the beauty of your skin. Infused with our exclusive Sustainable Moisture Complex™ and Revival Plant Extract, this makeup helps create a ' ||
                                               'surge of fresh radiance. Skin looks brighter instantly. Hydrates with a skin-caring blend of moisturizers and conditioners. ' ||
                                               'Helps improve moisture and keep skin looking brighter, dewy and plump. Fine drylines and imperfections seem to disappear. ' ||
                                               'All you see is flawless brilliance. For all skintypes.', 6, 13.21, 'MAKEUP',
     '#ceab89', '10 ml', 'assets/images/makeup/estee-lauder-futurist-aqua-brilliance.jpg'),
    ('Fit Me Matte Poreless Powder', 'Fit Me® Matte + Poreless Powder face makeup. Mattifies and leaves a poreless-looking finish with long-lasting shine control. Ideal for normal to oily skin, this long-lasting powder leaves a natural, poreless-looking finish with long-lasting shine control.', 1, 8.49, 'MAKEUP',
     '#f6c17c', '9 g', 'assets/images/makeup/maybelline-fit-me-matte-poreless-powder.jpg'),
    ('Lip Cream Plump & Care', 'Give your lips a combination of loving care. Lip Cream Plump & Care instantly transforms dry and chapped lips into seductive, full of sensuality and delicate touch. ', 4, 5.49, 'MAKEUP',
     '#ffc6df', '6 ml', 'assets/images/makeup/lamel-professional-lip-cream-plum-n-care.jpg'),
    ('HD Highlighting Glow & Sparkle Powder', 'It has a light texture that creates a weightless, shimmering layer on the skin. Thanks to small light-reflecting particles, the face acquires a gentle, soft, natural shine. The decorative tool will help correct facial features - highlight the cheekbones, visually raise the eyebrows, open the eyes and give the lips a lush volume. It minimizes the appearance of pigmentation and hides age changes.', 4, 5.68, 'MAKEUP',
     '#d6b9aa', '12 g', 'assets/images/makeup/lamel-professional-hd-highlighting-glow-n-sparkle-powder.jpg'),
    ('Lipliner', ' With the help of the lipliner, you can quickly emphasize the contour and visually correct the shape of the lips. And all this against the background of practical advantages: a soft formula and a matte finish.', 4, 2, 'MAKEUP',
     '#8e4e4f', '1.7 g', 'assets/images/makeup/lamel-professional-lipliner.jpg'),
    ('The City Mini Palette', 'Shadows do not dust and stay on the eyelids for a long time. Suitable for those who wear lenses. Can be applied both with a brush and with the fingers. Shimmer shades lay more beautifully and unfold when using the finger technique. You can choose between matte and shiny texture. They do not clump together in the folds of the eyelids when applied to the base.', 1, 7.5, 'MAKEUP',
     '#9d7c73', '6 g', 'assets/images/makeup/maybelline-the-city-mini-palette.jpg');