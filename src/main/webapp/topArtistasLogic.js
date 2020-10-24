var xhttp = new XMLHttpRequest();


window.onload = function () {
    //requestTopArtistas();
    mostrarDatos(respuesta)
};

xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        alert(this.responseText);
        mostrarDatos(this.responseText);
    }
}

function requestTopArtistas() {
    xhttp.open("GET", "topArtistasServlet", true);
    xhttp.send();
}

function mostrarDatos(respuesta) {
    //alert(respuesta);
    var Separados = respuesta.split(",,");
    //alert(Separados.length);
    for (var i = 0; i < Separados.length - 1; i += 5) {
        var CodigoArtista = Separados[i];
        var nombreArtista = Separados[i + 1];
        var foto = Separados[i + 2];
        var descripcion = Separados[i + 3];
        var puntaje = Separados[i + 4];
        var posicion = i + 1;
        //AñadirDiv(nombreArtista, foto, descripcion, puntaje, posicion);

    }



}

function AñadirDiv(nombreArtista, foto, descripcion, puntaje, posicion) {

    var div = document.createElement("div");
    div.style.setProperty('height', '10%');
    div.className = "listado";
    div.id = "iteracion" + nombreArtista;
    document.getElementById("primerDiv").appendChild(div);
    document.getElementById("iteracion" + nombreArtista).innerHTML = "<div class=\"numero\"> <h2>" + posicion + "</h2> </div><div class=\"vl\"></div><div class=\"nombre\"><h3>Autor: <center id=\" autor\"><br>" + nombreArtista + "</center></h3></div><div class=\"obrasNum\"> <h3>Obras: <center id=\"obrasNum\"><br>5</center></h3></div><div class =\"puntaje\"><h3>Puntaje: <center id=\"puntaje\"><br>" + puntaje + "</center></h3></div><div><img class=\"fotoAutor\"  src=\"" + foto + "\"></div> ";

}















