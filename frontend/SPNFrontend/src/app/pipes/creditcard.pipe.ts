import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'creditcard'
})
export class CreditcardPipe implements PipeTransform {

  transform(value: string): string {
    console.log(value)
    let x=value.substring(0,3);
    let y=value.substring(3,6);
    let z=value.substring(6,value.length);
    return x.concat(" ").concat(y).concat(" ").concat(z);
  }

}
