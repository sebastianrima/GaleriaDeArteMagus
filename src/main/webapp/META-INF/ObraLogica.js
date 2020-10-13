var xhttp = new XMLHttpRequest();
window.onload = Inicio;
function Inicio()
{
    document.getElementById("NombreObra").innerHTML= "La Monalisa";
    document.getElementById("NombreAutor").innerHTML= "Nikolaos de esparta";
    document.getElementById("PrecioDeSalida").innerHTML= "Precio de salida: "+ "50$";
    document.getElementById("PrecioSubasta").innerHTML= "Precio de subasta: "+"50$";
    document.getElementById("ValorActual").innerHTML= "Valor actual: "+ "50$";
    document.getElementById("TiempoRestante").innerHTML= "1"+ "H restante";
}

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        alert(this.responseText);
        var NomObra=Request.getParameter(NombreObra);
        Document.NombreObra.innerHTML= "Nicolaos"
    }
}
function guardarCliente()
{
    //recolectar info
    var Name = document.getElementById("nombre").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("pass").value;
    var correo = document.getElementById("correo").value;
    var telefono = document.getElementById("telefono").value;
    var myInfo =Name+","+userName+","+password+","+correo+","+telefono;
 
    xhttp.open("GET", "guardarCliente?data="+myInfo, true);
    xhttp.send();

}