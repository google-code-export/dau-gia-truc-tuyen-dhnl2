function ShowProductModel(){
    this.setData = function(data){
        this.data = data;
        pagesManager.controllers[ShowProductController].view.updateView();
    }
}