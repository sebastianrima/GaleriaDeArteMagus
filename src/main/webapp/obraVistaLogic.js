var xhttp = new XMLHttpRequest();
var xhttp1 = new XMLHttpRequest();
var tipoMelo = "";
var url = new URL(window.location.href);
var codigo = url.searchParams.get("c");
var user = url.searchParams.get("u");
var nombre = url.searchParams.get("n");
var codigoCliente;
var codigoAutor;

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
    xhttp.open("GET", "vistaObraServlet?c=" + codigo, true);
    xhttp.send();
}

function estaComprada() {
    if (codigoCliente !== "null") {
        document.getElementById("botonComprarObra").innerHTML = "Esta Obra está comprada";
        var btn = document.getElementById("botonComprarObra");
        btn.disabled = true;
        btn.style = "cursor: not-allowed;";
        // btn.style = "transform: none;";
    }
}

function tipoNombre(tipo) {

    if (tipo == 1) {
        tipoMelo = "Pintura";
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
    codigoCliente = datosSeparados[11];
    codigoAutor = datosSeparados[12];
    estaComprada();

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
    alert(codigoAutor);
}

function abrirAutor() {
    location = '/Autor.html?u=' + user + "&n=" + nombre + "&c=" + codigoAutor;
}
function comprarObra()
{
    if (user!= null)
    {
        xhttp1.open("GET", "comprarObra?c=" + codigo + "&u=" + user, true);
    
        xhttp1.send();
        
    }
    
}


xhttp1.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById("botonComprarObra").innerHTML = "Esta Obra está comprada";
        var btn = document.getElementById("botonComprarObra");
        alert("obra comprada con exito");
        btn.disabled = true;
        btn.style = "cursor: not-allowed;";
    }
}