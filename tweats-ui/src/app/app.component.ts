import { Component } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { Order } from './order';
import { OrderService } from './order.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'tweats-ui';
  orderArray: Order[];

  constructor(private httpClient: HttpClientModule, private orderService: OrderService) {

  }
  ngOnit() {
    this.orderService.getOrders().subscribe(orders => this.orderArray = orders);
  }
}
