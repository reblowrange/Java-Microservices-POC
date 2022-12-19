import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'byteToMb'
})

export class ByteToMbPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    const units = ['bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];

    let l = 0;
    let n = parseInt(value, 10) || 0;

    while (n >= 1024 && ++l) {
      n = n / 1024;
    }
    return (n.toFixed(n < 10 && l > 0 ? 1 : 0) + ' ' + units[l]);
  }

}
