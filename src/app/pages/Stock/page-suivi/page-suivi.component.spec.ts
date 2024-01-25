import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageSuiviComponent } from './page-suivi.component';

describe('PageSuiviComponent', () => {
  let component: PageSuiviComponent;
  let fixture: ComponentFixture<PageSuiviComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageSuiviComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageSuiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
