ShowProductController.inherits(BaseController);
function ShowProductController(){

    this.createView=function(){
        return new ShowProductView;
    }
    this.createModel=function(){
        this.getProducts(200*10,4);
        return new ShowProductModel();
    }

    this.refreshController=function(){

    };

    this.createEvents=function(){
        var self = this;
        $("#templatemo_container").click(function(e){

            var id = e.target.id;
            var className = e.target.className;
            var m = self.model;
            switch(id){
                case "number_of_pageleft":
                    self.getProducts(m.start - m.amount, m.amount);
                    break;

                case "number_of_pageright":
                    self.getProducts(m.start + m.amount, m.amount);
                    break;
            }
        });
    };

    this.getProducts = function(start,amount){
        if(this.skip)
            return;
        this.skip = true;
        var self = this;

        var data = {
            start:start,
            amount:amount
        };
        var success = function(res){
            console.log("getProducts success");
            self.skip = false;
            self.model.start = start;
            self.model.amount = amount;
            self.model.setData(res);
        };
        var error = function(res){
            console.log("getProducts error" + JSON.stringify(res));
            self.skip = false;
        };
        callService(urlShop,data,success,error);
    };
}
