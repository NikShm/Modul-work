import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'format'
})
export class FormatPipe implements PipeTransform {
    transform(value: string): string {
        return value.toLowerCase().replace(/^\w/, (char) => char.toUpperCase()).replace(/_/g, " ");
    }
}