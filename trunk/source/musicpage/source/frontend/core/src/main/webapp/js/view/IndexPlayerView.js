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
    this.togglePlayButton = function(e){
        if(e.target.className.indexOf("play") !=-1){
            $(e.target).removeClass("play");
            $(e.target).addClass("pause");
        } else{
            $(e.target).removeClass("pause");
            $(e.target).addClass("play");
        }

    }
    this.updateCssPlayingIndex = function(e){

    }

}
BaseView.inherits(IndexPlayerView)