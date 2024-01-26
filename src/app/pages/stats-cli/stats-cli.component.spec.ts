import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatsCliComponent } from './stats-cli.component';

describe('StatsCliComponent', () => {
  let component: StatsCliComponent;
  let fixture: ComponentFixture<StatsCliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StatsCliComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StatsCliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
