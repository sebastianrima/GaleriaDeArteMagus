var xhttp = new XMLHttpRequest();
var userName="";
xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200 && this.responseText!=="false")
    {
        location='/main.html?u='+userName+"&n="+this.responseText;
    }else if (this.readyState===4 )
    {
        alert("credenciales incorrectas");
    }
}
function logIn()
{
    //recolectar info
    userName = document.getElementById("userName").value;
    var password = document.getElementById("pass").value;
    var myInfo= userName+","+password;
    if(password!=="" && userName!=="")
    {
        xhttp.open("GET", "logearse?data="+myInfo, true);
        xhttp.send();
    }else
    {
        alert("porfavor llena todos los campos");
    }
    
}
function  goToCreateAcoutn()
{
    location='/singin.html' ;
}