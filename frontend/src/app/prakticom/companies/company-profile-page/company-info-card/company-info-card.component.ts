import {Component, Input, OnInit} from '@angular/core';
import {ICompany} from '../../../../shared/contracts/company';
import {ActivatedRoute, Router} from '@angular/router';
import {CompanyService} from '../../../../shared/services/CompanyService';

@Component({
  selector: 'app-company-info-card',
  templateUrl: './company-info-card.component.html',
  styleUrls: ['./company-info-card.component.sass']
})
export class CompanyInfoCardComponent implements OnInit {

  @Input() company: ICompany;

  constructor(private route: ActivatedRoute, private router: Router) { }

  async ngOnInit(): Promise<void> {
  }
}
