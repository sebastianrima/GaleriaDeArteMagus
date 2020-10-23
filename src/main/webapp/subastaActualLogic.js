var xhttp = new XMLHttpRequest();
var codigo1;
var codigo2;
var codigo3;
var url = new URL(window.location.href);
var userName = url.searchParams.get("u");
var nombre=url.searchParams.get("n");;

window.onload = function () {
    requestSubastaActual();

};
function votar()
{
    var url = new URL(window.location.href);
    var nombre = url.searchParams.get("n");
    if (nombre !== null)
        document.getElementById("welcomeText").innerHTML = "Bienvenido " + nombre;
    else
    {
        alert("Antes de votar por favor inicia sesión");
        window.location = "/";
    }

}
function requestSubastaActual()
{
    xhttp.open("GET", "consegirInfoSubastaActual", true);
    xhttp.send();
}

function mostrarDatos(respuesta)
{
    var datosSeparados = respuesta.split(",,");
    var titulo1 = datosSeparados[0];
    var img1 = datosSeparados[1];
    var texto1 = datosSeparados[2];
    var precio1 = datosSeparados[3];
    codigo1= datosSeparados[4];
    var titulo2 = datosSeparados[5];
    var img2 = datosSeparados[6];
    var texto2 = datosSeparados[7];
    var precio2 = datosSeparados[8];
    codigo2=datosSeparados[9];
    var titulo3 = datosSeparados[10];
    var img3 = datosSeparados[11];
    var texto3 = datosSeparados[12];
    var precio3 = datosSeparados[13];
    codigo3=datosSeparados[14];



    document.getElementById("titulo1").innerHTML = titulo1;
    document.getElementById("titulo2").innerHTML = titulo2;
    document.getElementById("titulo3").innerHTML = titulo3;
    document.getElementById("img1").src = img1;
    document.getElementById("img2").src = img2;
    document.getElementById("img3").src = img3;
    document.getElementById("texto1").innerHTML = texto1;
    document.getElementById("texto2").innerHTML = texto2;
    document.getElementById("texto3").innerHTML = texto3;
    document.getElementById("precio1").innerHTML = "COP $"+precio1;
    document.getElementById("precio2").innerHTML = "COP $"+precio2;
    document.getElementById("precio3").innerHTML = "COP $"+precio3;
    
}
xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        mostrarDatos(this.responseText);
    }
}
function  goToLogIn()
{
    location = '/index.html';
}

function verObra( codigo)
{
    if(codigo === "codigo1")
    {
        codigo = codigo1;
    }
    if(codigo === "codigo2")
    {
        codigo = codigo2;
    }
    if(codigo === "codigo3")
    {
        codigo = codigo3;
    }
    location = '/obraVista.html?u=' + userName + "&n=" + nombre+ "&c=" + codigo;
}

