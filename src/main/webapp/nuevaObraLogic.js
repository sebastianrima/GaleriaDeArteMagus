var xhttp = new XMLHttpRequest();
var xhttp1 = new XMLHttpRequest();


xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        mostrarArtistas(this.responseText);
        fillAutorSelect(this.responseText);
    }
}

function mostrarArtistas(respuesta) {
    var respuestaSplited = respuesta.split(",");
    var opciones = "";


    for (var i = 0; i < respuestaSplited.length; i += 2)
    {
        opciones += "<option value=\"" + respuestaSplited[i] + "\">" + respuestaSplited[i + 1] + "</option>";
    }

    document.getElementById("autorSelect").innerHTML = opciones;

}

window.onload = function () {
    requestAutorInfo();
};

function requestAutorInfo() {
    xhttp.open("GET", "nuevaObraServlet", true);
    xhttp.send();
}

function fillAutorSelect(respuesta) {
    var datosSeparados = respuesta.split(",");

    //For hasta largo arreglo

    document.getElementById("autorSelect");
}


function validarDatos() {
    //recolectar info
    var nombre = document.getElementById("nombreText1").value;
    var descripcion = document.getElementById("descripcionText1").value;
    var precioBase = document.getElementById("precioText1").value;
    var fecha = document.querySelector('input[type="date"]').value;
    var tipoTexto = document.getElementById("TipoSelector");
    var tipo = tipoTexto.options[tipoTexto.selectedIndex].value;
    var colorTexto = document.getElementById("colorSelect");
    var color = colorTexto.options[colorTexto.selectedIndex].text;
    var emocion = document.getElementById("emocionText1").value;
    var tematica = document.getElementById("tematicaText1").value;
    var movimiento = document.getElementById("movimientoText1").value;
    var imagen = document.getElementById("urlText1").value;
    var autorTexto = document.getElementById("autorSelect");
    var autor = autorTexto.options[autorTexto.selectedIndex].value;

    if (nombre == "" || descripcion == "" || precioBase == "" || fecha == "" || tipo == "" || color == "Escoger" || emocion == "" || tematica == "" || movimiento == "" || imagen == "" || autor == "") {
        alert("Llene todos los campos...");
    } else {
        if (isNaN(precioBase)) {
            alert("El precio debe ser un número...");
        } else {
            guardarObra(nombre, precioBase, imagen, fecha, tipo, color, emocion, tematica, movimiento, descripcion, autor);
        }
    }

}
function guardarObra(nombre, precioBase, imagen, fecha, tipo, color, emocion, tematica, movimiento, descripcion, autor)
{

    var myInfo = nombre + ",," + precioBase + ",," + imagen + ",," + fecha + ",," +
            tipo + ",," + color + ",," + emocion + ",," + tematica + ",," + movimiento + ",," + descripcion + ",," + autor;
    xhttp1.open("GET", "guardarObra?data=" + myInfo, true);
    xhttp1.send();
}


xhttp1.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200 && this.responseText !== "")
    {
        alert("La obra se guardo correctamenta");
        goToMain();
    } else if (this.readyState === 4 && this.status === 200)
    {
        alert("¡Ha ocurrido un problema con el servidor por favor intente más tarde!");
    }
}

function goToMain()
{
    top.window.location = "/main.html";
}











