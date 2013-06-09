/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerController(){
    this.init = function(){
//        this.model.playingSongsList = pagesManager.controllers[IndexController].model.playingSongsList;
        this.model.currentPlayIndex = 0;
        this.handlePlayButton = this.playButtonPausingState ;
        var self = this;
        this.model.player.addEventListener("durationchange", function(e) {
            console.log("durationchange ".concat(e));
            self.view.activeProcessBar();
        });
        this.model.player.addEventListener("progress", function(e) {
            //process occur wh
            console.log("progress ".concat(e));
            self.view.updateBufferBar();
        });
        this.model.player.addEventListener("timeupdate", function(e) {
            //process occur continously
            console.log("timeupdate ".concat(e));
            self.view.updateProcessBar();
        });
        this.model.player.addEventListener("ratechange", function(e) {
            console.log("ratechange ".concat(e));
        });
        this.model.player.addEventListener("ended",function(e){
            console.log("ended ".concat(e));
            self.handleEnd(e);
        });
        //error
        this.model.player.addEventListener("error",function(e){
            console.log("error ".concat(e));
            self.handleError(e);
        });
        this.view.deactiveProcessBar();
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
                this.model.currentPlayIndex < this.model.playingSongsList.length - 1 ? this.model.currentPlayIndex++ : false;
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
            case "processbarPlayer":
                this.handleSeek(e);
                break;
            case "process1":
                this.handleSeek(e);
                break;
            case "process2":
                this.handleSeek(e);
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
                this.view.activeProcessBar();
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
                this.view.deactiveProcessBar();
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
        this.model.player.load();
        this.model.player.play();
    }
    this.handleSeek = function(e){
        var player = this.model.player;
        var _x = e.clientX - $("#mediaPlayerPanel")[0].getBoundingClientRect().left;
        var fullWidth  = parseInt ($("#mediaPlayerPanel").css("width"),10);
        var duration = player.duration;
        player.currentTime = (_x/fullWidth) * duration;
        this.view.updateProcessBar();
    }
    this.handleEnd = function(e){
        this.view.deactiveProcessBar();
        this.model.currentPlayIndex < this.model.playingSongsList.length - 1 ? this.model.currentPlayIndex++ : false;
        this.playCurrentSong();
        this.view.updateCssPlayingIndex();

    }
    this.handleError = function(e){
        //TODO:  update css for the song which can not be loaded

    }
}
BaseController.inherits(IndexPlayerController);