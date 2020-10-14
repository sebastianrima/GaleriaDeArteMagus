var xhttp = new XMLHttpRequest();


window.onload = function() {
    requestTemporada();
    
};
function requestTemporada()
{
    xhttp.open("GET", "consegirInfoTemporadaActual", true);
    xhttp.send();
    
}
xhttp.onreadystatechange = function ()
{
    if (this.readyState === 4 && this.status === 200)
    {
        alert(this.responseText);
    }
}
