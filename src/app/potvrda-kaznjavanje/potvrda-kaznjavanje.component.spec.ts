import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PotvrdaKaznjavanjeComponent } from './potvrda-kaznjavanje.component';

describe('PotvrdaKaznjavanjeComponent', () => {
  let component: PotvrdaKaznjavanjeComponent;
  let fixture: ComponentFixture<PotvrdaKaznjavanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PotvrdaKaznjavanjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PotvrdaKaznjavanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
