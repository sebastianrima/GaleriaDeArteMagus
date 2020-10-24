var xhttp = new XMLHttpRequest();
var respuesta="";
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombreU=url.searchParams.get("n");
var codigo=url.searchParams.get("c");
window.onload = function() {
    buscaDatos();
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
    for(var i=0; i<Separados.length-1;i+=4){
    var NombreObra=Separados[i];
    var imgObra= Separados[i+1];
    var PrecioSalida= Separados[i+2];
    var codigo= Separados[i+3];
    AñadirTabla(NombreObra,imgObra,PrecioSalida,codigo);
}
 }

function buscaDatos()
{
    xhttp.open("GET", "ServletTodasLasObras", true);
    xhttp.send();
}

function AñadirTabla(nombre, img, precio,codigo) {
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
               imagen.setAttribute("onClick","irAObra(\""+codigo+"\")");
               var div = document.createElement("div"); 
               div.appendChild(imagen);
               div.style.setProperty('height','10%');
               var contenedorTitulo = document.createElement("h1");
               var titulo1 = document.createTextNode(nombre);
               contenedorTitulo.appendChild(titulo1);
               var contenedorPrecio = document.createElement("p");
               var precio = document.createTextNode("Cop$"+precio);
               contenedorPrecio.appendChild(precio);

                
                div.appendChild(contenedorTitulo);
                div.appendChild(contenedorPrecio);
               document.body.appendChild(div);
   
   
     
    }
   
  
  }
  
  
  function irAObra(codigo)
  {
      location = '/obraVista.html?u=' + userName + "&n=" + nombreU+ "&c=" + codigo;
  }