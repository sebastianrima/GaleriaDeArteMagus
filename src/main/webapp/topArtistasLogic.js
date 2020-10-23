var xhttp = new XMLHttpRequest();


window.onload = function () {
    requestTopArtistas();

};

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        mostrarDatos(this.responseText);
    }
}

function requestTopArtistas()
{
    xhttp.open("GET", "topArtistasServlet", true);
    xhttp.send();
}

function mostrarDatos(respuesta)
{
    var Separados = respuesta.split(",,");
    alert(Separados.length);
    for (var i = 0; i < Separados.length; i += 5) {
        var CodigoArtista = Separados[i];
        var nombreArtista = Separados[i + 1];
        var foto = Separados[i + 2];
        var descripcion = Separados[i + 3];
        var puntaje = Separados[i + 4];
        AñadirDiv(nombreArtista, foto, descripcion, puntaje);
    }
    var datosSeparados = respuesta.split(",,");
    var autor = datosSeparados[0];
    var fotoAutor = datosSeparados[1];
    var obrasNum = datosSeparados[2];
    var obraFav = datosSeparados[3];

    document.getElementById("autor").innerHTML = autor;
    document.getElementById("fotoAutor").src = fotoAutor;
    document.getElementById("obrasNum").innerHTML = obrasNum;
    document.getElementById("obraFav").innerHTML = obraFav;

}

function añadirDiv(nombreArtista, foto, descripcion, puntaje) {
document.getElementById("primerDiv").innerHTML ="<div class=\"numero\"> <h2>1</h2> </div><div class=\"vl\"></div><div class=\"nombre\"><h3>Autor: <center id=\"autor\"><br>Tubert Gil</center></h3></div><div class=\"obrasNum\"> <h3>Obras: <center id=\"obrasNum\"><br>5</center></h3></div><div class =\"puntaje\"><h3>Puntaje: <center id=\"puntaje\"><br>200</center></h3></div><div><img class=<\"fotoAutor\" id=\"fotoAutor\"src=\"Imagenes/tubertGil.jpg\"></div> ";
}















