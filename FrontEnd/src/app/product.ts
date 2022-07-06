export class Product {
    constructor(product: Product) {
        this.id = product.id;
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.color = product.color;
        this.brandId = product.brandId;
        this.brand = product.brand;
        this.photoPath = product.photoPath;
        this.volume = product.volume;
        this.category = product.category;
    }

    id: string;
    name: string;
    description: string;
    brandId: string;
    brand: string;
    price: string;
    category: string;
    color: string;
    volume: string;
    photoPath: string;
}
