export class Vehicle {
    
    id:number | undefined;
    license_plate:string;
    year:Date;
    model:string;
    seats:number;
    color:string;



    constructor(license_plate: string, year: Date, model: string, seats: number, color: string) {
        this.license_plate = license_plate;
        this.year = year;
        this.model = model;
        this.seats = seats;
        this.color = color;
    }

}