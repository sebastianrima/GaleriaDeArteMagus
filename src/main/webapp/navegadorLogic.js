var nombre;
var user;
function  goToNuevaObra()
{
    var url = new URL(top.window.location.href);
    nombre = url.searchParams.get("n");
    user= url.searchParams.get("u");

    top.window.location="/index.html?u="+user +"&n="+nombre;
}
function  goToObras()
{
        var url = new URL(top.window.location.href);
    nombre = url.searchParams.get("n");
    user= url.searchParams.get("u");

    top.window.location="/main.html?u="+user +"&n="+nombre;
}
function  goToMain()
{
        var url = new URL(top.window.location.href);
    nombre = url.searchParams.get("n");
    user= url.searchParams.get("u");

    top.window.location="/main.html?u="+user +"&n="+nombre;
}
