import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazSudjenjaComponent } from './prikaz-sudjenja.component';

describe('PrikazSudjenjaComponent', () => {
  let component: PrikazSudjenjaComponent;
  let fixture: ComponentFixture<PrikazSudjenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazSudjenjaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrikazSudjenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
