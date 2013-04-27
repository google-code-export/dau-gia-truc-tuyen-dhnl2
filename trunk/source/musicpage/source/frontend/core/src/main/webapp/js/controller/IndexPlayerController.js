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
//        if(!this.updateProcessBarId)
//            this.updateProcessBarId = setInterval(this.updateProcessBar,800);
        var self = this;
        this.model.player.addEventListener("durationchange", function(e) {
            console.log("durationchange ".concat(e))
        });
        this.model.player.addEventListener("progress", function(e) {
            //process occur continously
            console.log("progress ".concat(e));
            self.updateProcessBar();
        });
        this.model.player.addEventListener("ratechange", function(e) {
            console.log("ratechange ".concat(e))
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
        this.model.player.play();
    }
    this.updateProcessBar = function(){
        var self = pagesManager.controllers[IndexPlayerController];
        var player = self.model.player;
        //TODO : calculate current process playing -> currentTime , duration
        //TODO : process buffered   buffered
//        console.log("duration ".concat(player.duration));
//        console.log("seekable ".concat(JSON.stringify(player.seekable)));
        if(player.buffered.length != 0)console.log("buffered ".concat("{ ".concat(" "+player.buffered.start(0)).concat(" "+player.buffered.end(0))));

        var barPlay =  $("#mediaPlayerPanel #process2");
        var parentWidth = parseInt( barPlay.parent().css("width"),10);
        if(!player.paused)barPlay.css("width",(  (player.currentTime/ player.duration) * parentWidth  ))  ;
    }
}
BaseController.inherits(IndexPlayerController);