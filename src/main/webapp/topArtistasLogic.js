var xhttp = new XMLHttpRequest();


window.onload = function() {
    requestTopArtistas();
    
};

function requestTopArtistas()
{
    xhttp.open("GET", "topArtistasServlet", true);
    xhttp.send();
}
    
function mostrarDatos(respuesta)
{


   var datosSeparados = respuesta.split("ñ"); 
   var autor1= datosSeparados[0];
   var fotoAutor1 = datosSeparados[1];
   var obrasNum1=datosSeparados[2];
   var obraFav1=datosSeparados[3];

   var autor2= datosSeparados[4];
   var fotoAutor2 = datosSeparados[5];
   var obrasNum2=datosSeparados[6];
   var obraFav2=datosSeparados[7];

   var autor3= datosSeparados[8];
   var fotoAutor3 = datosSeparados[9];
   var obrasNum3=datosSeparados[10];
   var obraFav3=datosSeparados[11];



   
   document.getElementById("autor1").innerHTML = autor1; 
   document.getElementById("fotoAutor1").src = fotoAutor1;
   document.getElementById("obrasNum1").innerHTML = obrasNum1;
   document.getElementById("obraFav1").innerHTML = obraFav1;

   document.getElementById("autor2").innerHTML = autor2; 
   document.getElementById("fotoAutor2").src = fotoAutor2;
   document.getElementById("obrasNum2").innerHTML = obrasNum2;
   document.getElementById("obraFav2").innerHTML = obraFav2;

   document.getElementById("autor3").innerHTML = autor3; 
   document.getElementById("fotoAutor3").src = fotoAutor3;
   document.getElementById("obrasNum3").innerHTML = obrasNum3;
   document.getElementById("obraFav3").innerHTML = obraFav3;
   
}
xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        mostrarDatos(this.responseText); 
    }
}




