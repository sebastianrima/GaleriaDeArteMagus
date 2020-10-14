var xhttp = new XMLHttpRequest();


window.onload = function() {
    requestTemporada();
    
};
function requestTemporada()
{
    xhttp.open("GET", "consegirInfoTemporadaActual", true);
    xhttp.send();
    
}
    
function mostrarDatos(respuesta)
{
    var datosSeparadosTemporada = respuesta.split("ñ");
    for (var i=0; i < datosSeparadosTemporada.length; i++) {
      alert(datosSeparadosTemporada[i]);
   }
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
