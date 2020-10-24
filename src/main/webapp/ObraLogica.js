var xhttp = new XMLHttpRequest();
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre=url.searchParams.get("n");
var myInfo= url.searchParams.get("c");
var PrecioDeSalida;
window.onload = function () {
    requestSubastaActual();
};

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        Inicio(this.responseText);
        alert(this.responseText);
    }
}

function Inicio(respuesta)
{
    alert(respuesta);
    var Separados = respuesta.split(",,");
    var NombreObra = Separados[1];
    var imgObra = Separados[3];
    var imgAutor = Separados[19];
    var NombreAutor = Separados[17];
    PrecioDeSalida = Separados[2];
    var ValorActual = Separados[6];

    document.getElementById("NombreObra").innerHTML = NombreObra;
    document.getElementById("NombreAutor").innerHTML = NombreAutor;
    document.getElementById("imgObra").src = imgObra;
    document.getElementById("imgAutor").src = imgAutor;
    document.getElementById("PrecioDeSalida").innerHTML = "Precio de salida: COP$" + PrecioDeSalida;
    document.getElementById("PrecioSubasta").innerHTML = "Precio de subasta: COP$" + PrecioDeSalida*0.8;
    document.getElementById("ValorActual").innerHTML = "Valor actual: " + ValorActual;
}

function requestSubastaActual()
{
    xhttp.open("GET", "getObraSubasta?data="+myInfo, true);
    xhttp.send();
}
