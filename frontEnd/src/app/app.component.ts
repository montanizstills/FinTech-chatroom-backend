import { Component, AfterViewInit, ElementRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements AfterViewInit{
  constructor(private elementRef: ElementRef){ }

 public getColor(color: string): string {
    return color;
  }


 ngAfterViewInit () {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = this.getColor("black");
 }
 title = 'UI';
}