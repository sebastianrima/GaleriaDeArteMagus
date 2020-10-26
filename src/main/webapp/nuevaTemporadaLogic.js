var xhttp = new XMLHttpRequest();
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre = url.searchParams.get("n");;

function validarDatos() {
    //recolectar info
    var nombre = document.getElementById("nombreText1").value;
    var descripcion = document.getElementById("descripcionText1").value;
    var fecha = document.querySelector('input[type="date"]').value;


    if (nombre == "" || descripcion == "" || fecha == "") {
        alert("Llene todos los campos...");
    } else {
        guardarTemporada(nombre, fecha, descripcion);

    }

}
function guardarTemporada(nombre, fecha, descripcion) {
    var myInfo = nombre + ",," + fecha + ",," + descripcion;
    var colorTexto = document.getElementById("colorSelect");
    var color = colorTexto.options[colorTexto.selectedIndex].text;
   
    xhttp.open("GET", "guardarTemporada?data=" + myInfo+"&color="+color, true);
    xhttp.send();
}


xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200 && this.responseText !== "") {
        alert("La temporada se guardó correctamente");
        goToMain();
    } else if (this.readyState === 4 && this.status === 200) {
        alert("¡Ha ocurrido un problema con el servidor por favor intente más tarde!");
    }
}

function goToMain() {
    top.window.location = "/main.html?u=" + userName + "&n=" + nombre;
}











