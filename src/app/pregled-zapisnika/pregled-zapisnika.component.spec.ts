import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledZapisnikaComponent } from './pregled-zapisnika.component';

describe('PregledZapisnikaComponent', () => {
  let component: PregledZapisnikaComponent;
  let fixture: ComponentFixture<PregledZapisnikaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledZapisnikaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PregledZapisnikaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
