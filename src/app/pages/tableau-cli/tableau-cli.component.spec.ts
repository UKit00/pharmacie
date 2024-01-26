import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableauCliComponent } from './tableau-cli.component';

describe('TableauCliComponent', () => {
  let component: TableauCliComponent;
  let fixture: ComponentFixture<TableauCliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableauCliComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TableauCliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
