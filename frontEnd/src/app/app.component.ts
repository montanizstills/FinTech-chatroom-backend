import { Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  constructor(){ }

 public getColor(color: string): string {
    return color;
  }
// avoid accessing DOM directly, avoid ElementRef, xss attacks!
 /*ngAfterViewInit () {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = this.getColor("black");
 }*/
 title = 'UI';
}
