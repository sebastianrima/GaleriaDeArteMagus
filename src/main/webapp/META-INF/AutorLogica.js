var xhttp = new XMLHttpRequest();
window.onload = Inicio;
function Inicio()
{
    alert("!");
    document.getElementById("NombreObra").innerHTML= "La Monalisa";
    document.getElementById("NombreAutor").innerHTML= "Nikolaos de Esparta";
    document.getElementById("PrecioDeSalida").innerHTML= "Precio de salida: "+ "50$";
    document.getElementById("PrecioSubasta").innerHTML= "Precio de subasta: "+"50$";
    document.getElementById("ValorActual").innerHTML= "Valor actual: "+ "50$";
    document.getElementById("TiempoRestante").innerHTML= "1"+ "H restante";
}