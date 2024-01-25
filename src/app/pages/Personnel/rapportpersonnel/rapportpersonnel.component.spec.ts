import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RapportpersonnelComponent } from './rapportpersonnel.component';

describe('RapportpersonnelComponent', () => {
  let component: RapportpersonnelComponent;
  let fixture: ComponentFixture<RapportpersonnelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RapportpersonnelComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RapportpersonnelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
