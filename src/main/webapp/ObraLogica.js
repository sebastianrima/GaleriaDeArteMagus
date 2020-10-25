var xhttp = new XMLHttpRequest();
var xhttp1 = new XMLHttpRequest();
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre = url.searchParams.get("n");
var myInfo = url.searchParams.get("c");
var PrecioDeSalida;

window.onload = function () {
    requestSubastaActual();
};

xhttp1.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        alert(this.responseText);
    }
}

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
    var NombreObra = Separados[1];
    var imgObra = Separados[3];
    var imgAutor = Separados[19];
    var NombreAutor = Separados[17];
    PrecioDeSalida = Separados[2];
    var ValorActual = Separados[23]*( PrecioDeSalida - PrecioDeSalida*0.95)+  (PrecioDeSalida * 0.8);

    document.getElementById("NombreObra").innerHTML = NombreObra;
    document.getElementById("NombreAutor").innerHTML = NombreAutor;
    document.getElementById("imgObra").src = imgObra;
    document.getElementById("imgAutor").src = imgAutor;
    document.getElementById("PrecioDeSalida").innerHTML = "Precio de salida: COP$" + PrecioDeSalida;
    document.getElementById("PrecioSubasta").innerHTML = "Precio de subasta: COP$" + PrecioDeSalida * 0.8;
    document.getElementById("ValorActual").innerHTML = "Valor actual: COP $" + ValorActual;
    var valor=(Separados[23]+1)*( PrecioDeSalida - PrecioDeSalida*0.95)+(PrecioDeSalida*0.8);
    document.getElementById("BotonPuja").innerHTML="Pujar por: COP $"+valor;
}

function requestSubastaActual()
{
    xhttp.open("GET", "getObraSubasta?data=" + myInfo, true);
    xhttp.send();
}

function pujar(){
    if (userName !== null)
    {
        xhttp1.open("GET", "SubastaPuja?u=" + userName+"&o="+myInfo, true);
    xhttp1.send();
        
    }
    else
        alert("inicie sesion primero!!");
    
}