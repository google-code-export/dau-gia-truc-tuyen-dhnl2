/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerController(){
    this.init = function(){
        this.onClick = this.onClickPausingState;
    }
    this.createView = function(){
        return new IndexPlayerView();
    }
    this.onClickPausingState = function(e){
        var id = e.target.id;
        switch(id){
            case "play":
                this.view.togglePlayButton(e);
                    //TODO : get song at Index -> play it
                    //TODO :
                this.view.updateCssPlayingIndex(e);
                this.onClick = this.onClickPlayingState;
                break;
            default:
                break;
        }
    }
    this.onClickPlayingState = function(e){
        var id = e.target.id;
        switch (id) {
            case "play":
                this.view.togglePlayButton(e);
                this.onClick = this.onClickPausingState;
                break;
            default:
                break;
        }
    }
    this.createModel = function(){
        return new IndexPlayerModel();
    }

}
BaseController.inherits(IndexPlayerController);