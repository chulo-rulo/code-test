import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LookajourneyComponent } from './lookajourney.component';

describe('LookajourneyComponent', () => {
  let component: LookajourneyComponent;
  let fixture: ComponentFixture<LookajourneyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LookajourneyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LookajourneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
