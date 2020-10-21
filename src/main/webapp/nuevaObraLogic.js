var xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
           alert(this.responseText);
           fillAutorSelect(this.responseText);
    }
}

window.onload = function() {
    requestAutorInfo();
};

function requestAutorInfo(){
    xhttp.open("GET", "nuevaObraServlet", true);
    xhttp.send();
}

function fillAutorSelect(respuesta){
    var datosSeparados = respuesta.split(",");
    
    //For hasta largo arreglo
    
    document.getElementById("autorSelect");
}
function guardarObra()
{
    //recolectar info
    var nombre = document.getElementById("nombreText1").value;
    var descripcion = document.getElementById("descripcionText1").value;
    var precioBase = document.getElementById("precioText1").value;
    var fecha = document.querySelector('input[type="date"]').value;
    var tipoTexto = document.getElementById("TipoSelector");
    var tipo = tipoTexto.options[tipoTexto.selectedIndex].value;
    var colorTexto = document.getElementById("colorSelect");
    var color= colorTexto.options[colorTexto.selectedIndex].value;
    var emocion = document.getElementById("emocionText1").value;
    var tematica = document.getElementById("tematicaText1").value;
    var movimiento = document.getElementById("movimientoText1").value;
    var imagen = document.getElementById("urlText1").value;
    var autorTexto = document.getElementById("autorSelect");
    var autor= autorTexto.options[autorTexto.selectedIndex].value;
    
    var myInfo = ","+nombre+","+descripcion+","+precioBase+","+fecha+","+
    tipo+","+color+","+emocion+","+tematica+","+movimiento+","+imagen+","+autor+","+codCliente;
    
    alert(myInfo);
    xhttp.open("GET", "nuevaObraServlet?data="+myInfo, true);
    xhttp.send();
}