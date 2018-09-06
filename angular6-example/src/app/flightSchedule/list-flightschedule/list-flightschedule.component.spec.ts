import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ListFlightscheduleComponent} from './list-flightschedule.component';

describe('ListFlightscheduleComponent', () => {
  let component: ListFlightscheduleComponent;
  let fixture: ComponentFixture<ListFlightscheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListFlightscheduleComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListFlightscheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
