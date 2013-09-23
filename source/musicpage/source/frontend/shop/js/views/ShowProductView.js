ShowProductView.inherits(BaseView);
function ShowProductView (){
    this.PAGE_BAR = "number_of_page";
    this.CONTENT_RIGHT = "templatemo_content_right";
    this.updateView = function(){
        console.log("updateView");
        if(this.model.data){
            this.fillContentRight(this.model.data.listProducts);
        }
    }
    this.fillContentRight = function(listP){
        var mainNode = $("#"+this.CONTENT_RIGHT);
        var itemNode = $("#"+this.CONTENT_RIGHT+"_item");
        var itemNodeWidth = $("#"+this.CONTENT_RIGHT+"_item_width");
        var itemNodeHeight = $("#"+this.CONTENT_RIGHT+"_item_height");
        mainNode.empty();
        var length = listP.length;
        for (var i=0;i<length;i++){
            var d1 =  itemNode.clone();
            d1[0].id = "";
            mainNode.append(d1);
            if(i%2==0){
                mainNode.append(itemNodeWidth.clone());
            } else {
                mainNode.append(itemNodeHeight.clone());
            }

            //TODO update d1 data, by listP[i]
            var title = d1.children()[0];
            var productCode = title.children[0];
            var image = d1.children()[1];
            var description = d1.children()[2].children[0];
            var price = d1.children()[2].children[1];

            title.innerText = listP[i].name+" "+listP[i].productCode;
            productCode.innerText = listP[i].productCode;
            image.src = listP[i].urlImage;
            description.innerText = listP[i].description?listP[i].description:"N/A";
            price.innerText = listP[i].price;
        }
        mainNode.children().removeClass("hidden");

        //------ add paging
        var pageBar = $(document.createElement("div"));
        pageBar[0].id = this.PAGE_BAR;
        mainNode.append(pageBar);

        var pageLeft = $(document.createElement("div"));
        pageLeft[0].id = this.PAGE_BAR+"left";
        pageLeft.addClass("left");

        var pageRight = $(document.createElement("div"));
        pageRight[0].id = this.PAGE_BAR+"right";
        pageRight.addClass("right")

        pageBar.append(pageLeft);
        pageBar.append(pageRight);
    }
}