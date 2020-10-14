var xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        alert(this.responseText);
        location='/main.html';
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