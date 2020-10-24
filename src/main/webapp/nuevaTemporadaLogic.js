var xhttp = new XMLHttpRequest();


function validarDatos() {
    //recolectar info
    var nombre = document.getElementById("nombreText1").value;
    var descripcion = document.getElementById("descripcionText1").value;
    var fecha = document.querySelector('input[type="date"]').value;


    if (nombre == "" || descripcion == "" || fecha == "") {
        alert("Llene todos los campos...");
    } else {
        guardarTemporada(nombre, fecha, descripcion);
         alert("Llega aquí");

    }

}
function guardarTemporada(nombre, fecha, descripcion) {
    var myInfo = nombre + ",," + fecha + ",," + descripcion;
    alert(myInfo);
    xhttp.open("GET", "guardarTemporada?data=" + myInfo, true);
    xhttp.send();
}


xhttp.onreadystatechange = function () {
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











