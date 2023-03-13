import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Trip } from 'src/app/models/Trip';
import { TripsService } from 'src/app/services/trips/trips.service';

@Component({
  selector: 'app-create',
  templateUrl: './propose-trip.component.html',
  styleUrls: ['./propose-trip.component.css']
})
export class ProposeTripComponent implements OnInit {
  public inputControl!: FormControl;
  public formTrip!: FormGroup;
  public trip : Trip | undefined;
  date_alert = false;

  constructor(
    private formBuilder: FormBuilder,
    public tripService: TripsService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.inputControl = new FormControl();
    this.formTrip = this.formBuilder.group({
      ciudadOrigen: ['', { nonNullable: true, validators: [Validators.required]}],
      destino: ['', { nonNullable: true, validators: [Validators.required]}],
      fechaViaje: ['', { nonNullable: true, validators: [Validators.required]}],
      horaViaje: ['', { nonNullable: true, validators: [Validators.required]}],
      puntoEncuentro: ['', { nonNullable: true, validators: [Validators.required]}]
    });

  }

  public onSubmit(): void {
    if (!this.formTrip.valid) {
      this.formTrip.markAllAsTouched();
      console.log("NO");
      return;
    }
      const formValues = this.formTrip.value;
      this.trip = new Trip (formValues.ciudadOrigen, formValues.destino, formValues.fechaViaje, formValues.horaViaje, formValues.puntoEncuentro);
      console.log(this.trip);
    if(this.tripService.formattedDate > formValues.fechaViaje.toString() && this.tripService.formattedDate !== formValues.fechaViaje.toString()) {
      this.date_alert = true;
    }else {
      this.date_alert = false;
      this.tripService.setTrip(this.trip).subscribe(resp=>{
        console.log(resp);
        this.router.navigate(['']);

      },
      error=>{console.error(error)})
    }
    }
  }
