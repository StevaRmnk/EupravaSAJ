import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazPresudaComponent } from './prikaz-presuda.component';

describe('PrikazPresudaComponent', () => {
  let component: PrikazPresudaComponent;
  let fixture: ComponentFixture<PrikazPresudaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazPresudaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrikazPresudaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
