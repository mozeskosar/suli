window.onload = function () {
    akcios()
}
function akcios() {
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("akcios-ar").innerHTML = JSON.parse(this.responseText).akciosAr
            document.getElementById("akcios-teszta").innerHTML = JSON.parse(this.responseText).akciosTeszta
        }
    });

    xhr.open("GET", "http://localhost:8080/api/akcio");

    xhr.send();

}
function uzenet(){
    var data = JSON.stringify({"uzenet": document.getElementById("jatek-valasz").value});

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    
    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4 && this.status === 200) {
        document.getElementById("jatek-valasz").value="";
        alert("Köszönjük,hogy részt vesz a játékunkban!");
      }
    });
    
    xhr.open("POST", "http://localhost:8080/api/jatek");
    xhr.setRequestHeader("Content-Type", "application/json");
    
    xhr.send(data);

}