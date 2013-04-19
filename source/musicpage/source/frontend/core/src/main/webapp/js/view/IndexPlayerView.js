/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerView(){
    this.updateView = function(){

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

}
BaseView.inherits(IndexPlayerView)