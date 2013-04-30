/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerView(){
    this.updateView = function(){
        //init view
        var barPlay = $("#mediaPlayerPanel #process2");
        var parentWidth = parseInt(barPlay.parent().css("width"), 10);
        barPlay.css("width", 0);
    }
    this.togglePlayButton = function(){
        $("#mediaPlayerPanel #play").removeClass("pause");
        $("#mediaPlayerPanel #play").addClass("play");
    }
    this.togglePauseButton = function(){
        $("#mediaPlayerPanel #play").removeClass("play");
        $("#mediaPlayerPanel #play").addClass("pause");
    }
    this.updateCssPlayingIndex = function(){
        var index = this.model.currentPlayIndex;
        var listLis = $("#listSongsPlaying li");
        for(var i = 0 ; i<listLis.length;i++ ){
            if(listLis [i].className.indexOf("selectedSong")!=-1){
                $(listLis [i]).removeClass("selectedSong");
            }

            if(i==index){
                $(listLis [i]).addClass("selectedSong");
            }
        }
    }
    this.activeProcessBar = function(){
        $("#mediaPlayerPanel #process2").removeClass ("deactive");
    }
    this.deactiveProcessBar = function(){
        $("#mediaPlayerPanel #process2").addClass ("deactive");
    }
    this.updateProcessBar = function(){
        var self = pagesManager.controllers[IndexPlayerController];
        var player = self.model.player;
        //TODO : calculate current process playing -> currentTime , duration
        //TODO : process buffered   buffered

        var barPlay =  $("#mediaPlayerPanel #process2");
        var parentWidth = parseInt( barPlay.parent().css("width"),10);
        var percentOfProcess = (player.currentTime/ player.duration) * parentWidth ;
        console.log("percentOfProcess ".concat(percentOfProcess) + " currentTime ".concat(player.currentTime) + " duration ".concat(player.duration));
        if(!player.paused)barPlay.css("width", percentOfProcess )  ;
    }
    this.updateBufferBar = function(){
        var player = this.model.player;
        if(player.buffered.length != 0){
            console.log("buffered ".concat("{ ".concat(" "+player.buffered.start(0)).concat(" "+player.buffered.end(0))));
            var barPlay =  $("#mediaPlayerPanel #process1");
            var start = player.buffered.start(0);
            var end = player.buffered.end(0);
            var parentWidth = parseInt( barPlay.parent().css("width"),10);
            var width = ((end-start)/player.duration) * parentWidth;
            var marginLeft = (start/player.duration) * parentWidth;
            barPlay.css("width", width )  ;
            barPlay.css("marginLeft", marginLeft )  ;
        }
    }
}
BaseView.inherits(IndexPlayerView)