import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { Vehicle } from 'src/app/models/Vehicle';
import { VehiclesService } from 'src/app/services/vehicles/vehicles.service';

@Component({
  selector: 'app-addacar',
  templateUrl: './addacar.component.html',
  styleUrls: ['./addacar.component.css']
})
export class AddacarComponent implements OnInit {
  public inputControl!: FormControl;
  public formJourney!: FormGroup;
  public vehicle : Vehicle | undefined;
  public fileName: any;
  public file:any;
 

  constructor(
    public modalRef: MdbModalRef<AddacarComponent>,
    private formBuilder: FormBuilder,
    public vehicleService: VehiclesService
  ) { }

  ngOnInit(): void {

    this.inputControl = new FormControl();
    this.formJourney = this.formBuilder.group({
      modelo: ['', { nonNullable: true, validators: [Validators.required]}],
      year: ['', { nonNullable: false}],
      seats: ['', { nonNullable: true, validators: [Validators.required]}],
      color: ['', { nonNullable: true, validators: [Validators.required]}],
      plate: ['', { nonNullable: true, validators: [Validators.required]}],
      img: ['', { nonNullable: true, validators: [Validators.required]}]
    });

  }

  onFileSelected(event:any) {
   
    const file:File = event.target.files[0];
    if (file) {

      const content = document.getElementById('imageok');
      if (content != null)
         content.hidden = false;

      this.formJourney.patchValue({img:file});
      this.file = file;
      this.fileName = file.name;
    }
  }

  public onSubmit(): void {
    if (!this.formJourney.valid) {this.formJourney.markAllAsTouched();return;}
    else {
      const values = this.formJourney.value;
      this.vehicle = new Vehicle (values.plate,new Date(values.year),values.modelo, values.seats, values.color);

      const mData = JSON.stringify(this.vehicle);
      const formData = new FormData();
      formData.append('data', mData);
      formData.append('file', this.file, this.file.name);
      
      this.vehicleService.setVehicle(formData).subscribe(resp=>{
        console.log(resp);
        this.modalRef.close(this.vehicle);
      },error=>{console.error(error)}
      )
 
    }
  }

}
