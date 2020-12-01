import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentCompetenciesComponent } from './student-competencies.component';

describe('StudentCompetenciesComponent', () => {
  let component: StudentCompetenciesComponent;
  let fixture: ComponentFixture<StudentCompetenciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentCompetenciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentCompetenciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
