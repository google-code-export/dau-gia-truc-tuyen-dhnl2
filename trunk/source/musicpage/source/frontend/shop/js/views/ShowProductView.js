ShowProductView.inherits(BaseView);
function ShowProductView (){
    this.updateView = function(){
        console.log("updateView");
        if(this.model.data){
            this.fillContentRight(this.model.data.listProducts);
        }
    }
    this.fillContentRight = function(listP){
        var mainNode = $("#templatemo_content_right");
        var itemNode = $("#templatemo_content_right_item");
        var itemNodeWidth = $("#templatemo_content_right_item_width");
        var itemNodeHeight = $("#templatemo_content_right_item_height");
        mainNode.empty();
        var length = listP.length;
        for (var i=0;i<length;i++){
            var d1 =  itemNode.clone();
            mainNode.append(d1);
            if(i%2==0){
                mainNode.append(itemNodeWidth.clone());
            } else {
                mainNode.append(itemNodeHeight.clone());
            }

            //TODO update d1 data, by listP[i]
        }
        mainNode.children().removeClass("hidden");
    }
}