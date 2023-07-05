import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrijaveGradjaninaComponent } from './prijave-gradjanina.component';

describe('PrijaveGradjaninaComponent', () => {
  let component: PrijaveGradjaninaComponent;
  let fixture: ComponentFixture<PrijaveGradjaninaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrijaveGradjaninaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrijaveGradjaninaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
