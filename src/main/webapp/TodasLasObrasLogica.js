var xhttp = new XMLHttpRequest();
var respuesta = "";
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombreU = url.searchParams.get("n");
var Par = url.searchParams.get("p");
var Tex = url.searchParams.get("t");
window.onload = function () {
    if(Par===null||Par===0){
        buscaDatos();
    }else{
    FiltraDatos(Par,Tex);
    }
};

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        TraerObras(this.responseText);
    }
}
function TraerObras(respuesta) {
    var Separados = respuesta.split(",,");
    for (var i = 0; i < Separados.length - 1; i += 4) {
        var NombreObra = Separados[i];
        var imgObra = Separados[i + 1];
        var PrecioSalida = Separados[i + 2];
        var codigo = Separados[i + 3];
        AñadirTabla(NombreObra, imgObra, PrecioSalida, codigo);
    }
}

function buscaDatos()
{
    xhttp.open("GET", "ServletTodasLasObras", true);
    xhttp.send();
}
function FiltraDatos(p,t)
{
    xhttp.open("GET", "ServletTodasLasObras?p="+p+"&t="+t, true);
    xhttp.send();
}

function AñadirTabla(nombre, img, precio, codigo) {
    // Obtener la referencia del elemento body
    var body = document.getElementsByTagName("body")[0];

    // Crea un elemento <table> y un elemento <tbody>
    var tabla = document.createElement("table");
    var tblBody = document.createElement("tbody");

    // Crea las celdas
    for (var i = 0; i < 1; i++) {
        // Crea las hileras de la tabla
        var imagen = document.createElement("img");
        imagen.setAttribute("src", img);
        imagen.setAttribute("onClick", "irAObra(\"" + codigo + "\")");
        var div = document.createElement("div");
        div.appendChild(imagen);
        div.style.setProperty('height', '10%');
        var contenedorTitulo = document.createElement("h1");
        var titulo1 = document.createTextNode(nombre);
        contenedorTitulo.appendChild(titulo1);
        var contenedorPrecio = document.createElement("p");
        var precio = document.createTextNode("COP $" + precio);
        contenedorPrecio.appendChild(precio);


        div.appendChild(contenedorTitulo);
        div.appendChild(contenedorPrecio);
        document.body.appendChild(div);

    }


}


function irAObra(codigo)
{
    location = '/obraVista.html?u=' + userName + "&n=" + nombreU + "&c=" + codigo;
}

function Filtrado() {
    alert("1");
    var FiltradoPor = document.getElementById("FiltradoCombo");
    var Parametro = FiltradoPor.options[FiltradoPor.selectedIndex].text;
    var Texto = document.getElementById("TextoFiltrado").value;
    location = '/TodasLasObras.html?u=' + userName + "&n=" + nombreU + "&p="+Parametro+"&t="+Texto;
}