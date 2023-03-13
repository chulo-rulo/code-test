import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposeTripComponent } from './propose-trip.component';

describe('ProposeTripComponent', () => {
  let component: ProposeTripComponent;
  let fixture: ComponentFixture<ProposeTripComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProposeTripComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposeTripComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
