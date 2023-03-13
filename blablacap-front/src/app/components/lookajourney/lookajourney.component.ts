import { Component, OnInit } from '@angular/core';
import { TripsService } from 'src/app/services/trips/trips.service';

@Component({
  selector: 'app-lookajourney',
  templateUrl: './lookajourney.component.html',
  styleUrls: ['./lookajourney.component.css']
})
export class LookajourneyComponent implements OnInit { 
  trips: any;
  propose: any;
  filteredResults: any[] = [];
  searchResults: any;

  constructor(
    public tripsService: TripsService
  ) { }

  ngOnInit(): void {
    this.searchResults = this.tripsService.result;
    console.log("trips by search: " + this.searchResults);
    this.getFilterResults(this.searchResults);
  }
  onChangeSearch($event: any) {
    console.log("EVENT: " + $event);
    this.searchResults = $event;
    this.getFilterResults(this.searchResults);
  }

  getFilterResults(searchFilter: string) {
    this.tripsService.getTripsSearched(searchFilter).subscribe(resp=>{
      this.filteredResults = [];
      this.trips = resp.filter((x: { aviable_seats: number; }) => x.aviable_seats != 0);
      this.filteredResults = resp.filter((x: { aviable_seats: number; }) => x.aviable_seats == 0);
      console.log(resp);
  },
  error=>{console.error(error)}
  )
  }

  }


