var xhttp = new XMLHttpRequest();
var tipoMelo = "";

window.onload = function () {
    myInfo = "";
    requestObraInfo();
};

xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        mostrarDatos(this.responseText);
    }
}

function requestObraInfo() {
    xhttp.open("GET", "vistaObraServlet", true);
    xhttp.send();
}

function tipoNombre(tipo) {

    if (tipo == 1) {
        tipoMelo = "Pinutra";
    } else {
        tipoMelo = "Escultura";
    }
}


function mostrarDatos(respuesta) {

    var datosSeparados = respuesta.split(",,");
    var tituloObra = datosSeparados[0];
    var descripcion = datosSeparados[1];
    var precioBaseObra = datosSeparados[2];
    var fechaCreacion = datosSeparados[3];
    var tipo = datosSeparados[4];
    var color = datosSeparados[5];
    var emocion = datosSeparados[6];
    var tematica = datosSeparados[7];
    var movimiento = datosSeparados[8];
    var obraPicture = datosSeparados[9];
    var autorObra1 = datosSeparados[10];
    tipoNombre(tipo);

    document.getElementById("tituloObra1").innerHTML = tituloObra;
    document.getElementById("descripcionObra1").innerHTML = descripcion;
    document.getElementById("precioBaseObra1").innerHTML = precioBaseObra;
    document.getElementById("fechaC").innerHTML = fechaCreacion;
    document.getElementById("tipo").innerHTML = tipoMelo;
    document.getElementById("color").innerHTML = color;
    document.getElementById("emocion").innerHTML = emocion;
    document.getElementById("tematica").innerHTML = tematica;
    document.getElementById("movimiento").innerHTML = movimiento;
    document.getElementById("obraPicture1").src = obraPicture;
    document.getElementById("autorObra1").innerHTML = autorObra1;
}