$(document).ready(function() {
});

async function iniciarSesion() {
    let datos = {};
    datos.login = document.getElementById("login").value;
    datos.clave = document.getElementById("clave").value;

                                 /**la referecia que no funciona */
    const response = await fetch('/index', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const respuesta = await response.text();
    if (!response.ok) {
        
        alert(respuesta); /**esto lo hice para que me aparezca el mensaje de que reconoce la referencia*/
        alert("Credenciales incorrectas, intente de nuevo");
    } 
}
