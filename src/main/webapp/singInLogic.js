var xhttp = new XMLHttpRequest();

xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        alert(this.responseText);
        location = '/main.html';
    }
}
function validacionCliente() {
    //recolectar info
    var name = document.getElementById("nombre").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("pass").value;
    var correo = document.getElementById("correo").value;
    var telefono = document.getElementById("telefono").value;

    if (name == "" || userName == "" || password == "" || correo == "" || telefono == "") {
        alert("Llene todos los campos...");
    } else {
        if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(correo)) {
            if (isNaN(telefono)) {
                alert("El teléfono debe contener únicamente números...");
            } else {
                alert("Datos melos");
                guardarCliente(name, userName, password, correo, telefono);
            }
        } else {
            alert("Ingrese una dirección válida de correo");
        }
    }
}


function guardarCliente(name, userName, password, correo, telefono)
{
    var myInfo = name + "," + userName + "," + password + "," + correo + "," + telefono;
    xhttp.open("GET", "guardarCliente?data=" + myInfo, true);
    xhttp.send();

}