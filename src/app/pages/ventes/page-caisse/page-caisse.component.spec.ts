import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageCaisseComponent } from './page-caisse.component';

describe('PageCaisseComponent', () => {
  let component: PageCaisseComponent;
  let fixture: ComponentFixture<PageCaisseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageCaisseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageCaisseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
