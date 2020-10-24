var xhttp = new XMLHttpRequest();


xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        alert(this.responseText);
    }
}

window.onload = function () {
    requestAutorInfo();
};

function requestAutorInfo() {
    xhttp.open("GET", "nuevaObraServlet", true);
    xhttp.send();
}

function validarDatos() {
    //recolectar info
    var nombre = document.getElementById("nombreText1").value;
    var descripcion = document.getElementById("descripcionText1").value;
    var fecha = document.querySelector('input[type="date"]').value;
    var duracion = document.getElementById("duracionText1").value;


    if (nombre == "" || descripcion == "" || duracion == "" || fecha == "") {
        alert("Llene todos los campos...");
    } else {
        guardarTemporada(nombre, descripcion, fecha, duracion);
    }

}
function guardarTemporada(nombre, descripcion, fecha, duracion) {
    var myInfo = nombre + ",," + descripcion + ",," + fecha + ",," + duracion;
    alert(myInfo);
    xhttp1.open("GET", "guardarTemporada?data=" + myInfo, true);
    xhttp1.send();
}


xhttp1.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200 && this.responseText !== "") {
        alert(this.responseText);
        alert("La temporada se guardo correctamenta");
        goToMain();
    } else if (this.readyState === 4 && this.status === 200) {
        alert("¡ha ocurrido un problema con el servidor por favor intente más tarde!");
    }
}

function goToMain() {
    top.window.location = "/main.html";
}











