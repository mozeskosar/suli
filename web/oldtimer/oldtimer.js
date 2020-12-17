window.onload = function () {
    nemelerheto()
}
function nemelerheto() {
   var data = "";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
  if(this.readyState === 4 && this.status === 200) {
document.getElementById("nem-elerheto").innerHTML=JSON.parse(this.responseText).nemElerhetoAutok
	  
  }
});

xhr.open("GET", "http://localhost:8000/api/nemelerheto");

xhr.send(data);
}
function velemeny() {
    var bejegyzes = document.getElementById("velemenyInput");
    var data = JSON.stringify({"velemeny": bejegyzes.value});
   
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4) {
            bejegyzes.value = "";
            alert("Véleménye fontos számunkra!");
        }
    });

    xhr.open("POST", "http://localhost:8000/api/velemeny");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(data);
}