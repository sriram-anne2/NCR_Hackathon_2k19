import { Component } from '@angular/core';
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

  constructor(private orderService: OrderService) { }

  ngOnInit() {
    console.log('component.ts')
    this.orderService.getOrders().subscribe(orders => this.orderArray = orders);
  }
}
