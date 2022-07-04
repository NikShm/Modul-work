import { Component } from '@angular/core';

@Component({
    selector: 'my-app',
    templateUrl: './app.component.html'
})
export class AppComponent {
    name= '';
    filter: 'all' | 'active' | 'done' = 'all';

    allItems = [
        { description: 'eat', picture: "672144.jpg",  done: true },
        { description: 'sleep', picture: "672144.jpg", done: false },
        { description: 'play', picture: "672144.jpg", done: false },
        { description: 'laugh', picture: "672144.jpg", done: false },
        { description: 'play', picture: "672144.jpg", done: false },
        { description: 'laugh', picture: "672144.jpg", done: false },
        { description: 'play', picture: "672144.jpg", done: false },
        { description: 'laugh', picture: "672144.jpg", done: false },
        { description: 'play', picture: "672144.jpg", done: false },
        { description: 'laugh', picture: "672144.jpg", done: false },
    ];

    get items() {
        if (this.filter === 'all') {
            return this.allItems;
        }
        return this.allItems.filter(item => this.filter === 'done' ? item.done : !item.done);
    }
    addItem(description: string) {
        this.allItems.unshift({
            description,
            done: false,
            picture: "672144.jpg"
        });
    }
    change(name: string){
        this.name = name;
    }

}