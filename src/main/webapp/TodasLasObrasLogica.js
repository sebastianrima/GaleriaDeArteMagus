var xhttp = new XMLHttpRequest();
var respuesta="1,,https://generacionxbox.com/wp-content/uploads/2019/11/overwatch-2.jpg,,3,,5,,https://generacionxbox.com/wp-content/uploads/2019/11/overwatch-2.jpg,,6";
window.onload = function() {
    alert("2");
    TraerObras(respuesta);
};

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        TraerObras(this.responseText); 
    }
}
function TraerObras(respuesta){
    var Separados= respuesta.split(",,");
    alert(Separados.length);
 for(var i=0; i<Separados.length;i+=3){
    var NombreObra=Separados[i];
    var imgObra= Separados[i+1];
    var PrecioSalida= Separados[i+2]
    AñadirTabla(NombreObra,imgObra,PrecioSalida);
}
 }

function buscaDatos()
{
    xhttp.open("GET", "TodasLasObrasServlet", true);
    xhttp.send();
}

function AñadirTabla(nombre, img, precio) {
    // Obtener la referencia del elemento body
    var body = document.getElementsByTagName("body")[0];
   
    // Crea un elemento <table> y un elemento <tbody>
    var tabla   = document.createElement("table");
    var tblBody = document.createElement("tbody");
   
    // Crea las celdas
    for (var i = 0; i < 1; i++) {
      // Crea las hileras de la tabla
      var imagen = document.createElement("img"); 
               imagen.setAttribute("src", img); 
               var div = document.createElement("div"); 
               div.appendChild(imagen);
               div.style.setProperty('height','10%');
               div.className= "total";
               div.id="total";
               document.getElementById("total").style.setProperty('height','10%');
               document.body.appendChild(div);
      var hilera = document.createElement("tr");
   
      for (var j = 0; j < 1; j++) {
        // Crea un elemento <td> y un nodo de texto, haz que el nodo de
        // texto sea el contenido de <td>, ubica el elemento <td> al final
        // de la hilera de la tabla
        var celda = document.createElement("td");
        var textoCelda = document.createTextNode(nombre+", "+precio);
        celda.appendChild(textoCelda);
        hilera.appendChild(celda);
      }
   
      // agrega la hilera al final de la tabla (al final del elemento tblbody)
      tblBody.appendChild(hilera);
    }
   
    // posiciona el <tbody> debajo del elemento <table>
    tabla.appendChild(tblBody);
    // appends <table> into <body>
    body.appendChild(tabla);
    // modifica el atributo "border" de la tabla y lo fija a "2";
    tabla.setAttribute("border", "0");
  }