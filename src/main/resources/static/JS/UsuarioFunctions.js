function eliminar(login){
    swal({
        title: "¿Está seguro de eliminar?",
        text: "Una vez eliminado, ¡no podrá recuperar este registro!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
                url:"/usuario/eliminar/"+login,
                success: function(res){
                    console.log(res);
                }
            });
          swal("¡Puf! ¡Su registro ha sido eliminado!", {
            icon: "success",
          }).then((ok)=>{
              if(ok){
                  location.href="/usuario";
              }
          });
        } else {
          swal("¡Su registro está seguro!");
        }
      });
}






