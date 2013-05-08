/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/8/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
function TopAlbumView(){
    this.updateView = function(){
        var listAlbum = this.model.listAlbum;
        var ulListAlbumPosition = $("#listAlbumPosition")[0];
        ulListAlbumPosition.innerHTML = "";
        var widthListAlbum = $("#listAlbumPosition").width();
        var rate = widthListAlbum/ listAlbum[0].boundWidth
        for(var i = 0; i< listAlbum.length; i++){
            var li = document.createElement("li");
            li.style.height = listAlbum[i].height*rate+"px";
            li.style.width = listAlbum[i].width*rate+"px";
            li.style.top = listAlbum[i].y*rate+"px";
            li.style.left = listAlbum[i].x*rate+"px";
            li.style.position = "absolute";
            li.title =  listAlbum[i].title;
            ulListAlbumPosition.appendChild(li);
        }

    }

}

BaseView.inherits(TopAlbumView);
