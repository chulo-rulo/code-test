import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { faMap } from '@fortawesome/free-regular-svg-icons';
import { faLocationDot, faUser, faCity, faRoadBridge, faCalendar } from '@fortawesome/free-solid-svg-icons';
import { faSearchengin } from '@fortawesome/free-brands-svg-icons';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { TripsService } from 'src/app/services/trips/trips.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {
  @Output() searchEmitter = new EventEmitter<string>();

  showCarousel = true;
  dontShowCarousel = false;
  mapIcon = faMap;
  locationIcon = faLocationDot;
  calendarIcon = faCalendar;
  searchIcon = faSearchengin;
  roadIcon = faRoadBridge;
  cityIcon = faCity;
  userIcon = faUser;
  searchForm = new FormGroup({
    origin: new FormControl('', Validators.required),
    destination: new FormControl('', Validators.required),
    depart_date: new FormControl('', Validators.required)
  });
  destinations: string[] = [
    "Murcia", "Valencia"
  ];
  newOrigin: any;
  newDestination: any;
  newDepart_date: any;

  constructor(
    public tripsService: TripsService
  ) { }

  ngOnInit(): void {
  }

  public submitSearch() {
    if (this.searchForm.value.origin == "" && this.searchForm.value.destination == "" && this.searchForm.value.
    depart_date == "") {
      console.log("Campos vacios");
      this.searchForm.markAllAsTouched();return;
    }
    const formValue = this.searchForm.value;
    if(formValue.origin == "") {
      this.newOrigin = "null";
    }else {
      this.newOrigin = formValue.origin;
    }
    if(formValue.destination == "") {
      this.newDestination = "null";
    }else {
      this.newDestination = formValue.destination;
    }
    if(formValue.depart_date == "") {
      this.newDepart_date = "null";
    }else {
      this.newDepart_date = formValue.depart_date;
    }
    const submitData = this.newOrigin +"*"+ this.newDestination +"*"+ this.newDepart_date;
    this.searchForm.reset();

    console.log("resultado: " + submitData);
    this.tripsService.searchBar(submitData);
    this.searchEmitter.emit(submitData);
  }
}
