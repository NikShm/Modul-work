export class Search {
    constructor(name: any, brand: string, priceFrom: number, priceTo: number, sortField: string, sortDirection: string, page: number, pageSize: number, categoryType: any) {
        this.name = name;
        this.brand = brand;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.sortField = sortField;
        this.sortDirection = sortDirection;
        this.page = page;
        this.pageSize = pageSize;
        this.categoryType = categoryType;
    }

    name : string;
    brand : string;
    priceFrom : number;
    priceTo : number;
    sortField : string;
    sortDirection : string;
    page : number;
    pageSize : number;
    categoryType:string;
}
