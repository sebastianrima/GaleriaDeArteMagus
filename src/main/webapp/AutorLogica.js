var xhttp = new XMLHttpRequest();

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
    var NombreAutor = Separados[0];
    var imgAutor = Separados[1];
    var Nacionalidad = Separados[2]
    var Puntaje = Separados[3];
    var Descripcion = Separados[4];
    var NombreObra1 = Separados[5];
    var PrecioObra1 = Separados[6];
    var FechaObra1 = Separados[7];
    var Descripcion1 = Separados[1];
    var NombreObra2 = Separados[5];
    var PrecioObra2 = Separados[6];
    var FechaObra2 = Separados[7];
    var Descripcion2 = Separados[1];
    var NombreObra3 = Separados[5];
    var PrecioObra3 = Separados[6];
    var FechaObra3 = Separados[7];
    var Descripcion3 = Separados[1];

    document.getElementById("NombreAutor").innerHTML = NombreAutor;
    document.getElementById("DatosAutor").innerHTML = "Nacionalidad: " + Nacionalidad + " <br/>Puntaje: " + Puntaje + "/100 <br/>Descripción: " + Descripcion + "<br/>";
    document.getElementById("Datos1").innerHTML = "Nombre: " + NombreObra1 + " <br/>Precio: " + PrecioObra1 + " <br/>Fecha de creacion: " + FechaObra1 + " <br/>Descripción: " + Descripcion1;
    document.getElementById("Datos2").innerHTML = "Nombre: " + NombreObra2 + " <br/>Precio: " + PrecioObra2 + " <br/>Fecha de creacion: " + FechaObra2 + " <br/>Descripción: " + Descripcion2;
    document.getElementById("Datos3").innerHTML = "Nombre: " + NombreObra3 + " <br/>Precio: " + PrecioObra3 + " <br/>Fecha de creacion: " + FechaObra3 + " <br/>Descripción: " + Descripcion3;
}
function requestSubastaActual()
{
    xhttp.open("GET", "AutorServlet", true);
    xhttp.send();
}