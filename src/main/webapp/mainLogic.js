var xhttp = new XMLHttpRequest();
var xhttp1 = new XMLHttpRequest();
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre;
window.onload = function () {
    requestTemporada();
    
    getUser();
};


function getUser()
{
    var url = new URL(window.location.href);
    nombre = url.searchParams.get("n");
    if (nombre !== null)
        document.getElementById("welcomeText").innerHTML = "Bienvenido " + nombre;
}
function requestTemporada()
{
    xhttp.open("GET", "consegirInfoTemporadaActual", true);
    xhttp.send();
}

function mostrarDatos(respuesta)
{
    var datosSeparadosTemporada = respuesta.split(",,");
    var titulo = datosSeparadosTemporada[0];
    var img1 = datosSeparadosTemporada[1];
    var img2 = datosSeparadosTemporada[2];
    var textoTemporada = datosSeparadosTemporada[3];

    document.getElementById("NombreTemporadaActual").innerHTML = titulo;
    document.getElementById("contenedorCaracteristicasTemporada").innerHTML = textoTemporada;
    document.getElementById("imagen1").src = img1;
    document.getElementById("imagen2").src = img2;
}
xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        mostrarDatos(this.responseText);
    }
}
function  goToLogIn()
{
    location = '/index.html';
}

function goToSubastas()
{
    location = '/subastaActual.html?u=' + userName + "&n=" + nombre;
 
}
function goToTopArtista()
{
    location = '/topArtistas.html?u=' + userName + "&n=" + nombre;
}
function goToArtistaTemporada()
{
    xhttp1.open("GET", "getMejorArtista", true);
    xhttp1.send();
}
xhttp1.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        location = '/Autor.html?u=' + userName + "&n=" + nombre+ "&c="+this.responseText;
    }
}
function añadirTemporada()
{
    location = '/nuevaTemporada.html?u=' + userName + "&n=" + nombre;
}