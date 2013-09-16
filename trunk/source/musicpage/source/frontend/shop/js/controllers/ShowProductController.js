ShowProductController.inherits(BaseController);
function ShowProductController(){

//    this.init= function(){
//
//    }
    this.createView=function(){
        return new ShowProductView;
    }
    this.createModel=function(){
        this.getProducts(200*10,10);
        return new ShowProductModel();
    }
    this.refreshController=function(){}
    this.createEvents=function(){
        $("#templatemo_container").click(function(){
        });
    }

    this.getProducts = function(start,amount){
        var self = this;

        var data = {
            start:start,
            amount:amount
        };
        var success = function(res){
            console.log("createModel success");
            self.model.setData(res);
        };
        var error = function(res){console.log("createModel error" + JSON.stringify(res));};
        callService(urlShop,data,success,error);
    }
}
