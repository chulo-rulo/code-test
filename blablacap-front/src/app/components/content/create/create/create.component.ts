import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { Vehicle } from 'src/app/models/Vehicle';
import { TripsService } from 'src/app/services/trips/trips.service';
import { VehiclesService } from 'src/app/services/vehicles/vehicles.service';
import { ITripForm } from 'src/app/shared/models/trip-form.model';
import { AddacarComponent } from '../../addacar/addacar/addacar.component';
declare function greet(): void;

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  public inputControl!: FormControl;
  public formTrip!: FormGroup;
  public carSelected = '';
  seats_av: number[] = [];
  vehicles: any;
  seats: any;
  date_alert = false;
  hora: number = Date.now();
  user_id = "";
  car_id: any;
  filter: any;
  modalRef: MdbModalRef<AddacarComponent> | null = null;

  constructor(
    private formBuilder: FormBuilder,
    public vehiclesService: VehiclesService,
    public tripService: TripsService,
    public router: Router,
    private modalService: MdbModalService
  ) { }

  ngOnInit(): void {
    console.log("TIME: -->" + this.tripService.fecha.getHours() + ":" + this.tripService.fecha.getMinutes() + ":" + this.tripService.fecha.getSeconds());
    this.vehiclesService.getVehicles().subscribe(resp=>{
      this.vehicles = resp;
  },
  error=>{console.error(error)}
  )
  greet();
    this.inputControl = new FormControl();
    this.formTrip = this.formBuilder.group({
      ciudadOrigen: ['', { nonNullable: true, validators: [Validators.required]}],
      destino: ['', { nonNullable: true, validators: [Validators.required]}],
      fechaViaje: ['', { nonNullable: true, validators: [Validators.required]}],
      horaViaje: ['', { nonNullable: true, validators: [Validators.required]}],
      coche: ['', { nonNullable: true, validators: [Validators.required]}],
      asientosDisp: ['',  { nonNullable: true, validators: [Validators.compose([
                         Validators.required, Validators.pattern(/^([1-9])*$/)])]}],
      precio: ['', { nonNullable: true, validators: [Validators.compose([
                   Validators.required, Validators.pattern(/\d+(,\d+)?/)])]}],
      puntoEncuentro: ['', { nonNullable: true, validators: [Validators.required]}]
    });

  }

  public onSubmit(): void {
    if (!this.formTrip.valid) {
      this.formTrip.markAllAsTouched();return;
    }
    console.log("entrada dos");
    console.log("fecha hoy: " + this.tripService.formattedDate);
    const formValue = this.formTrip.value;
    const submitData: ITripForm = {
      start_point: formValue.ciudadOrigen,
      dest_office: formValue.destino,
      departure_date: formValue.fechaViaje,
      departure_time: formValue.horaViaje,
      aviable_seats: formValue.asientosDisp,
      price: formValue.precio,
      meeting_point_desc: formValue.puntoEncuentro,

    }
    console.log("formato hora: " + submitData.departure_time);
    console.log("id vehicle: -->" + this.carSelected);
    console.log("Seats_av : -->" + this.seats_av);
    if(this.tripService.formattedDate > submitData.departure_date.toString() && this.tripService.formattedDate !== submitData.departure_date.toString()) {
      this.date_alert = true;
    }else {
      this.date_alert = false;
      this.tripService.createTrip(submitData).subscribe(resp=>{
        console.log(resp);
      },
      error=>{console.error(error)});
      this.formTrip.reset();
      this.router.navigateByUrl('/');
    }
  }
  selectSeats() {
    /* Reinicamos el array */
    this.seats_av = [];
    /* Buscamos el vehiculo seleccionado por el id desde carSelected */
    let vehicleSelected = this.vehicles.find((x: { id: string; }) => x.id == this.carSelected);
    /* Comprobamos que el SELECT no esta vacio */
    if (vehicleSelected) {
      this.seats = vehicleSelected.seats;
      for(let i = 1; i <= this.seats; i++) {
        let a = i - 1;
        this.seats_av.push(i);
        console.log(a + "-->" + this.seats_av[a]);
      }
    }
  }

  openModal() {
    this.modalRef = this.modalService.open(AddacarComponent,  {
      modalClass: 'modal-dialog-centered'
    });
    const content = document.getElementById('container');
    if (content != null)
       content.style.visibility = 'hidden';

    this.modalRef.onClose.subscribe( data => {
      if (content != null)
        content.style.visibility = 'visible';

      if(data != null){
        let vehiclesArray: Array<Vehicle> = this.vehicles;
        vehiclesArray.push(data);
        this.vehicles =vehiclesArray;
      }
    }
    );
   
  }

}
