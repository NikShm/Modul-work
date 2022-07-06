import { Component } from '@angular/core';

class Item{
    name: string;
    price: number;

    constructor(name: string, price: number) {

        this.name = name;
        this.price = price;
    }
}

@Component({
    selector: 'purchase-app',
    template:
`    <div class="box-container">
    <div class="box"  *ngFor="let item of items">
        <span class="discount">-10%</span>
        <div class="image">
            <img src="https://i.pinimg.com/564x/a3/af/e1/a3afe1c2cb803c4911cb71d64d268b0d.jpg" alt="">
            <div class="icons">
                <a href="#" class="fas fa-heart"></a>
                <a href="#" class="cart-btn">add to cart</a>
                <a href="#" class="fas fa-share"></a>
            </div>
        </div>
        <div class="content">
            <h3>{{item.name}}</h3>
            <div class="price">{{item.price}}$</div>
        </div>
    </div>
</div>`,
})
export class AppComponent {
   text: string = "";
    price: number = 0;

    items: Item[] =
        [
            { name: "Unice Pastel Lipstick",price: 15.9 },
            { name: "L'oreal Paris Color Riche", price: 60 },
            { name: "Clarins Joli Rouge Lacquer Barra de Labios", price: 22.6 },
            { name: "Clarins Joli Rouge Brillant", price:310 },
            { name: "Guerlain Kiss Kiss La Rouge Mat", price:310 }
        ];
    addItem(text: string, price: number): void {

        if(text==null || text.trim()=="" || price==null)
            return;
        this.items.push(new Item(text, price));
    }
}