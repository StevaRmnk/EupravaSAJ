import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZapisnikComponent } from './zapisnik.component';

describe('ZapisnikComponent', () => {
  let component: ZapisnikComponent;
  let fixture: ComponentFixture<ZapisnikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZapisnikComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZapisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
