/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.odometerOptions = {
  auto: false, // Don't automatically initialize everything with class 'odometer'
  selector: '.my-numbers', // Change the selector used to automatically find things to be animated
  format: '(,ddd).dd', // Change how digit groups are formatted, and how many digits are shown after the decimal point
  duration: 3000, // Change how long the javascript expects the CSS animation to take
  theme: 'car', // Specify the theme (if you have more than one theme css file on the page)
  animation: 'count' // Count is a simpler animation method which just increments the value,
                     // use it when you're looking for something more subtle.
};

var valor = document.getElementById("total-gasto").innerHTML;
valorFormat = valor.replace("R$ ", "")
valorFormat2 = valorFormat.replace(".", "")
valorFormat3 = valorFormat2.replace(",", ".")


console.log(valorFormat3);        
console.log(valor);
var valor2 = parseFloat(valor);
console.log(valor2);

setTimeout(function(){
    odometer.innerHTML = valorFormat3;
}, 1000)

