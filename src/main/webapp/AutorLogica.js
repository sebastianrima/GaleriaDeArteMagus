var xhttp = new XMLHttpRequest();
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre=url.searchParams.get("n");
var codigo=url.searchParams.get("c");
var cod1="";
var cod2="";
var cod3="";
window.onload = function () {
    myInfo = "";
    requestSubastaActual();
};

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        Inicio(this.responseText);
    }
}

function Inicio(respuesta)
{
    var Separados = respuesta.split(",,");
    var NombreAutor = Separados[4];
    var imgAutor = Separados[6];
    var Nacionalidad = Separados[2];
    var Puntaje = Separados[5];
    var Descripcion = Separados[1];
    var NombreObra1 = Separados[8];
    var PrecioObra1 = Separados[9];
    var FechaObra1 = Separados[11];
    var Descripcion1 = Separados[17];
    var NombreObra2 = Separados[26];
    var PrecioObra2 = Separados[27];
    var FechaObra2 = Separados[29];
    var Descripcion2 = Separados[35];
    var NombreObra3 = Separados[44];
    var PrecioObra3 = Separados[45];
    var FechaObra3 = Separados[47];
    var Descripcion3 = Separados[53];
    var imgObra1 = Separados[10];
    var imgObra2 = Separados[28];
    var imgObra3 = Separados[46];
    cod1= Separados[7];
    cod2= Separados[25];
    cod3= Separados[43];

alert(respuesta);
    document.getElementById("NombreAutor").innerHTML = NombreAutor;
    document.getElementById("FotoAutor").src= imgAutor;
    document.getElementById("ImgObra1").src= imgObra1;
    document.getElementById("ImgObra2").src= imgObra2;
    document.getElementById("ImgObra3").src= imgObra3;
    document.getElementById("DatosAutor").innerHTML = "Nacionalidad: " + Nacionalidad + " <br/>Puntaje: " + Puntaje + " <br/>Descripción: " + Descripcion + "<br/>";
    document.getElementById("Datos1").innerHTML = "Nombre: " + NombreObra1 + " <br/>Precio: " + PrecioObra1 + " <br/>Fecha de creacion: " + FechaObra1 + " <br/>Descripción: " + Descripcion1;
    document.getElementById("Datos2").innerHTML = "Nombre: " + NombreObra2 + " <br/>Precio: " + PrecioObra2 + " <br/>Fecha de creacion: " + FechaObra2 + " <br/>Descripción: " + Descripcion2;
    document.getElementById("Datos3").innerHTML = "Nombre: " + NombreObra3 + " <br/>Precio: " + PrecioObra3 + " <br/>Fecha de creacion: " + FechaObra3 + " <br/>Descripción: " + Descripcion3;
}
function requestSubastaActual()
{
    xhttp.open("GET", "AutorServlet?data="+codigo, true);
    xhttp.send();
}

function llevaObra1(){
    location = '/obraVista.html?u=' + userName + "&n=" + nombre+ "&c=" + cod1;
}
function llevaObra2(){
    location = '/obraVista.html?u=' + userName + "&n=" + nombre+ "&c=" + cod2;
}
function llevaObra3(){
    location = '/obraVista.html?u=' + userName + "&n=" + nombre+ "&c=" + cod3;
}