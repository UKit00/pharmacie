import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitpageComponent } from './produitpage.component';

describe('ProduitpageComponent', () => {
  let component: ProduitpageComponent;
  let fixture: ComponentFixture<ProduitpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProduitpageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProduitpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
