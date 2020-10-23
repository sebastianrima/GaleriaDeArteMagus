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





