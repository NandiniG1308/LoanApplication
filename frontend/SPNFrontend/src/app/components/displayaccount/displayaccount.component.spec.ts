import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayaccountComponent } from './displayaccount.component';

describe('DisplayaccountComponent', () => {
  let component: DisplayaccountComponent;
  let fixture: ComponentFixture<DisplayaccountComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisplayaccountComponent]
    });
    fixture = TestBed.createComponent(DisplayaccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
