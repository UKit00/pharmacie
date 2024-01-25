import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageRapportClientComponent } from './page-rapport-client.component';

describe('PageRapportClientComponent', () => {
  let component: PageRapportClientComponent;
  let fixture: ComponentFixture<PageRapportClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PageRapportClientComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PageRapportClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
