import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageGeneralComponent } from './page-general.component';

describe('PageGeneralComponent', () => {
  let component: PageGeneralComponent;
  let fixture: ComponentFixture<PageGeneralComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageGeneralComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageGeneralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
