import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OptuzniceComponent } from './optuznice.component';

describe('OptuzniceComponent', () => {
  let component: OptuzniceComponent;
  let fixture: ComponentFixture<OptuzniceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OptuzniceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OptuzniceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
