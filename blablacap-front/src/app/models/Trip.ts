import { Time } from "@angular/common";

export class Trip {
    
    departure_date:Date;
    departure_time:Time;
    start_point:String;
    dest_office:String;
    meeting_point_desc:String;
    



    constructor(start_point: String, dest_office: String, departure_date: Date, departure_time: Time,  meeting_point_desc: String) {
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.start_point = start_point;
        this.dest_office = dest_office;
        this.meeting_point_desc = meeting_point_desc;
    }

}