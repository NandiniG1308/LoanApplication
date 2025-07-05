import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayloanComponent } from './displayloan.component';

describe('DisplayloanComponent', () => {
  let component: DisplayloanComponent;
  let fixture: ComponentFixture<DisplayloanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisplayloanComponent]
    });
    fixture = TestBed.createComponent(DisplayloanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
