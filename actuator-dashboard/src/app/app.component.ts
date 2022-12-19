import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as ApexCharts from 'apexcharts';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent implements OnInit {

  public badRequest = new Array<any>();
  public acceptedRequest = new Array<any>();
  public serverErrorRequest = new Array<any>();
  public notFoundRequest = new Array<any>();
  public allRequest = new Array<any>();
  public healthInfo;


  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.refresh();
    // setTimeout(() => { this.createChart(); }, 1000);
  }
  public refresh(): void {
    this.getHealth();
    this.getHttpTrace();
  }

  private getHttpTrace(): void {
    this.http.get<any>('http://localhost:19999/actuator/httptrace').subscribe(response => {
      this.allRequest = response.traces;
      this.acceptedRequest.length = 0;
      this.badRequest.length = 0;
      this.serverErrorRequest.length = 0;
      this.notFoundRequest.length = 0;
      this.allRequest.forEach(x => {
        if (x.response.status === 200) {
          this.acceptedRequest.push(x);
        }
        if (x.response.status === 400) {
          this.badRequest.push(x);
        }
        if (x.response.status === 500) {
          this.serverErrorRequest.push(x);
        }
        if (x.response.status === 404) {
          this.notFoundRequest.push(x);
        }
      });
    });
  }

  private getHealth(): void {
    this.http.get<any>('http://localhost:19999/actuator/health').subscribe(response => {
      this.healthInfo = response;
    });
  }

  private createChart(): void {

    const options = {
      chart: {
        type: ''
      },
      series: [{
        name: 'sales',
        data: [30, 40, 35, 50, 49, 60, 70, 91, 125]
      }],
      xaxis: {
        categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999]
      }
    };

    const chart = new ApexCharts(document.querySelector('.pr-chart'), options);

    chart.render();
  }
}
