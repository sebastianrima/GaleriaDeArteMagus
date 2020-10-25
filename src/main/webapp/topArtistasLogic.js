var xhttp = new XMLHttpRequest();
var xhttp1 = new XMLHttpRequest();
var url = new URL(window.location.href);
var codigo = url.searchParams.get("c");
var user = url.searchParams.get("u");
var nombre = url.searchParams.get("n");
window.onload = function () {
    requestTopArtistas();
};

xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        mostrarDatos(this.responseText);
    }
}

xhttp1.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        Alres(this.responseText);
        //alert(this.responseText);
    }
}

function requestTopArtistas() {
    xhttp.open("GET", "topArtistasServlet", true);
    xhttp.send();
}

function mostrarDatos(respuesta) {
    var Separados = respuesta.split(",,");
    var contador = 0;
    
        for (var i = 0; i < Separados.length - 1; i += 5) {
        var codigoArtista = Separados[i];
        var nombreArtista = Separados[i + 1];
        var foto = Separados[i + 2];
        var descripcion = Separados[i + 3];
        var puntaje = Separados[i + 4];
        contador += 1;
        //alert(codigoArtista);
        var codIdent = codigoArtista;
        traerNumObras(codigoArtista);

        AñadirDiv(nombreArtista, foto, descripcion, puntaje, contador, codigoArtista);
    }
}

function AñadirDiv(nombreArtista, foto, descripcion, puntaje, contador, codigoArtista) {

    var div = document.createElement("div");
    div.style.setProperty('height', '10%');
    div.className = "listado";
    div.id = "iteracion" + nombreArtista;
    document.getElementById("primerDiv").appendChild(div);
    document.getElementById("iteracion" + nombreArtista).innerHTML = "<div class=\"numero\"> <h2>" + contador + "</h2> </div><div class=\"vl\"></div><div class=\"nombre\"><h3>Autor: <center id=\" autor\"><br>" + nombreArtista + "</center></h3></div><div class=\"obrasNum\"> <h3>Obras: <center id=\"obrasNum\"><br></center></h3></div><div class =\"puntaje\"><h3>Puntaje: <center id=\"puntaje\"><br>" + puntaje + "</center></h3></div><div><img class=\"fotoAutor\"  src=\"" + foto + "\"></div> ";
    document.getElementById("iteracion" + nombreArtista).setAttribute("onClick", "irAAutor(\"" + codigoArtista + "\")");
    // alert(codigoArtista);

}

function irAAutor(codigoArtista) {
    location = '/Autor.html?u=' + user + "&n=" + nombre + "&c=" + codigoArtista;
}

function  traerNumObras(codigoB)
{
    xhttp1.open("GET", "numeroObrasServlet?data=" + codigoB, true);
    xhttp1.send();
}
function Alres(respuesta) {
    alert(respuesta);
}














