import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageRapportVenteComponent } from './page-rapport-vente.component';

describe('PageRapportVenteComponent', () => {
  let component: PageRapportVenteComponent;
  let fixture: ComponentFixture<PageRapportVenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageRapportVenteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageRapportVenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
