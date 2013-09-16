callService = function(url,data ,success,error){
    $.ajax(urlShop,{
        data:data,

        crossDomain:true,
        success:success,
        statusCode:{
            200:function(res){
                console.log(url + " statusCode 200 "+JSON.stringify(res));
            },
            404:function(res){
                console.log(url + " statusCode 404 "+JSON.stringify(res));
                error(res);
            },
            401:function(res){
                console.log(url + " statusCode 401 "+JSON.stringify(res));
                error(res);
            }
        },
        error:function(res){
            //cause of cancel service
            error(res);
        }

    });
}
