var xhttp = new XMLHttpRequest();


window.onload = function() {
    requestTemporada();
    getUser();
};
function getUser()
{
    var url = new URL(window.location.href);
    var nombre = url.searchParams.get("n");
    if (nombre !== null)
        document.getElementById("welcomeText").innerHTML = "Bienvenido "+nombre;
}
function requestTemporada()
{
    xhttp.open("GET", "consegirInfoTemporadaActual", true);
    xhttp.send();
}
    
function mostrarDatos(respuesta)
{
   var datosSeparadosTemporada = respuesta.split("ñ"); 
   var titulo= datosSeparadosTemporada[0];
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
    location='/index.html' ;
}

function goToSubastas()
{
    location='/subastaActual.html' ;
}
function goToTopArtista()
{
    location='/topArtistas.html' ;
}
function goToArtistaTemporada()
{
    location='/Autor.html' ;
}