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

        for(var i = 0; i< listAlbum.length; i++){
            var li = document.createElement("li");
            li.style.height = listAlbum[i].height+"px";
            li.style.width = listAlbum[i].width+"px";
            li.style.top = listAlbum[i].top+"px";
            li.style.left = listAlbum[i].left+"px";
            li.style.position = "absolute";
            li.style.border = "solid red";

            ulListAlbumPosition.appendChild(li);
        }

    }
}

BaseView.inherits(TopAlbumView);
