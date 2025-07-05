import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaycreditcardComponent } from './displaycreditcard.component';

describe('DisplaycreditcardComponent', () => {
  let component: DisplaycreditcardComponent;
  let fixture: ComponentFixture<DisplaycreditcardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisplaycreditcardComponent]
    });
    fixture = TestBed.createComponent(DisplaycreditcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
