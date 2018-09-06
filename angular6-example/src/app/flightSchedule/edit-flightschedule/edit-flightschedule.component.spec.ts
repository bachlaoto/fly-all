import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EditFlightscheduleComponent} from './edit-flightschedule.component';

describe('EditFlightscheduleComponent', () => {
  let component: EditFlightscheduleComponent;
  let fixture: ComponentFixture<EditFlightscheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditFlightscheduleComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditFlightscheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
