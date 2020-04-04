// Thi is the inner in the HTML script in the element <script></script> as in the last Document
let i =0;
function main(i) {
    let primeness = "";
    let num = 0;
    for(i=1;i<100;i++){
        let counter = 0;
        for (num=i; num>=1;num--){
            if (i%num === 0){
                counter = counter+1;
            }
        }
        if (counter === 2){
            primeness = primeness +  i + "";
        }
    }
    document.getElementById("id").innerHTML = "prime numbers from 1 to 100 are :";
    document.getElementById("id").innerHTML = primeness;
}