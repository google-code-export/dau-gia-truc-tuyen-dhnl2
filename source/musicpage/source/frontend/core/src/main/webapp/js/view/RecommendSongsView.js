/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 6/16/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */

function RecommendSongsView(){
    this.updateView = function(){

        this.updateListSongs(this.model.listSongs);

    }

    this.updateListSongs = function(model){
        var listSongs = $("#recommendSongs .listSongs");
        listSongs.empty();
        for(var i=0;i<model.length;i++){
            var titleDiv = document.createElement("div");
            var artistDiv = document.createElement("div");
            var wrap1 = document.createElement("div");
            $(wrap1).append(titleDiv);
            $(wrap1).append(artistDiv);

            var iconListenDiv = document.createElement("div");
            var iconAddnDiv = document.createElement("div");
            var wrap2 = document.createElement("div");
            $(wrap2).append(iconListenDiv);
            $(wrap2).append(iconAddnDiv);

            var liE = document.createElement("li");
            $(liE).append(wrap1);
            $(liE).append(wrap2);
            listSongs.append(liE);

            $(titleDiv).text(model[i].title);
            $(artistDiv).text(model[i].artist);
        }
    }
}

BaseView.inherits(RecommendSongsView);