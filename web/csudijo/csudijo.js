window.onload = function () {
    legnepszerubb()
}
function legnepszerubb() {

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById("legnepszerubb").innerHTML = JSON.parse(this.responseText).etelNev
        }
    });

    xhr.open("GET", "http://localhost:8000/api/legnepszerubb");

    xhr.send();
}

function vendegkonyv() {
    var data = JSON.stringify({ "bejegyzes": document.getElementById('bejegyzes').value });
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById('bejegyzes').value='';
            alert("Köszönjük a bejegyzését!")
        }
    });

    xhr.open("POST", "http://localhost:8000/api/vendegkonyv");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(data);

}