/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerController(){
    this.init = function(){
        this.model.playingSongsList = pagesManager.controllers[IndexController].model.playingSongsList;
        this.model.currentPlayIndex = 0;
        this.handlePlayButton = this.playButtonPausingState ;
        if(!this.updateProcessBarId)
            this.updateProcessBarId = setInterval(this.updateProcessBar,500);
    }
    this.createView = function(){
        return new IndexPlayerView();
    }
    this.onClick = function(e){
        var id = e.target.id;
        switch(id){
            case "play":
                this.handlePlayButton(e);
                break;
            case "next":
                this.model.currentPlayIndex < this.model.playingSongsList.length-1 ? this.model.currentPlayIndex++ : false;
                this.view.updateCssPlayingIndex();
                this.playCurrentSong();
                this.view.togglePauseButton();
                break;
            case "previous":
                this.model.currentPlayIndex > 0 ? this.model.currentPlayIndex-- : false;
                this.view.updateCssPlayingIndex();
                this.playCurrentSong();
                this.view.togglePauseButton();
                break;
            default:
                break;
        }
    }
    this.playButtonPausingState = function(e){
        var id = e.target.id;
        switch(id){
            case "play":
                this.view.togglePauseButton();
                this.playCurrentSong();
                this.view.updateCssPlayingIndex();
                this.handlePlayButton = this.playButtonPlayingState;
                break;
            default:
                break;
        }
    }
    this.playButtonPlayingState = function(e){
        var id = e.target.id;
        switch (id) {
            case "play":
                this.view.togglePlayButton(e);
                    //TODO: pause song

                this.handlePlayButton = this.playButtonPausingState;
                break;
            default:
                break;
        }
    }
    this.createModel = function(){
        return new IndexPlayerModel($("#playerObject")[0]);
    }
    this.playCurrentSong = function(){
        this.model.player.src = this.model.playingSongsList[this.model.currentPlayIndex].src;
        this.model.player.play();
    }
    this.updateProcessBar = function(){
        var self = pagesManager.controllers[IndexPlayerController];
        var player = self.model.player;
        //TODO : calculate current process playing -> currentTime , duration
        //TODO : process buffered   buffered
        console.log("duration ".concat(player.duration));
        console.log("seekable ".concat(JSON.stringify(player.seekable)));
        console.log("buffered ".concat("{ ".concat(" "+player.buffered.start(0)).concat(" "+player.buffered.end(0))));
    }
}
BaseController.inherits(IndexPlayerController);