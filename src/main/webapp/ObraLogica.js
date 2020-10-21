var xhttp = new XMLHttpRequest();

window.onload = function() {
    myInfo="1";
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
    var Separados= respuesta.split(",");
    var NombreObra=Separados[0];
    var imgObra= Separados[1];
    var imgAutor= Separados[2]
    var NombreAutor= Separados[3];
    var PrecioDeSalida= Separados[4];
    var PrecioSubasta=Separados[5];
    var ValorActual=Separados[6];
    var TiempoRestante=Separados[7];

    document.getElementById("NombreObra").innerHTML= NombreObra;
    document.getElementById("NombreAutor").innerHTML= NombreAutor;
    document.getElementById("imgObra").innerHTML= imgObra;
    document.getElementById("imgAutor").innerHTML= imgAutor;
    document.getElementById("PrecioDeSalida").innerHTML= "Precio de salida: "+ PrecioDeSalida;
    document.getElementById("PrecioSubasta").innerHTML= "Precio de subasta: "+PrecioSubasta;
    document.getElementById("ValorActual").innerHTML= "Valor actual: "+ ValorActual;
    document.getElementById("TiempoRestante").innerHTML= TiempoRestante+ "H restante";
}

function requestSubastaActual()
{
    xhttp.open("GET", "obraServlet?data="+myInfo, true);
    xhttp.send();
}
