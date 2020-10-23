var xhttp = new XMLHttpRequest();
var myInfo;
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
    var PrecioDeSalida = Separados[2];
    var PrecioSubasta = Separados[5];
    var ValorActual = Separados[6];
    var TiempoRestante = Separados[7];

    document.getElementById("NombreObra").innerHTML = NombreObra;
    document.getElementById("NombreAutor").innerHTML = NombreAutor;
    document.getElementById("imgObra").src = imgObra;
    document.getElementById("imgAutor").src = imgAutor;
    document.getElementById("PrecioDeSalida").innerHTML = "Precio de salida: " + PrecioDeSalida;
    document.getElementById("PrecioSubasta").innerHTML = "Precio de subasta: " + PrecioSubasta;
    document.getElementById("ValorActual").innerHTML = "Valor actual: " + ValorActual;
    document.getElementById("TiempoRestante").innerHTML = TiempoRestante + "H restante";
}

function requestSubastaActual()
{
    xhttp.open("GET", "getObraSubasta", true);
    xhttp.send();
}
