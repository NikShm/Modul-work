export class Brand {
    constructor(brand: Brand) {
        this.id = brand.id;
        this.name = brand.name;
    }

    id: string;
    name: string;
}