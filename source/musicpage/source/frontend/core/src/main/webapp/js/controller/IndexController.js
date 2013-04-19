function IndexController (){
    this.init = function(){
        //whenever controller is new, it will be called

    },
    /**
     * Create view for controling View html
     **/
    this.createView = function(){
        //whenever controller is new, it will be called
        return new IndexView();
    },
    /**
     * first model , using for update view in VIew
      */
    this.createModel = function(){
        //whenever controller is new, it will be called
        var m = new IndexModel();
        m.createOfflineData();
        return m;
    },

    this.playSong = function(index){
        this.model.selectedIndexSong = index;
        this.player.src = this.model.playingSongsList[index].src;
        this.player.play();
    },
    this.onClick = function(e){

    }
}
BaseController.inherits(IndexController);

