/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/8/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
function TopAlbumModel (){
    this.createOfflineData = function(){
        this.listAlbum = [{ "x": 1, "y": 4, "x2": 299, "y2": 151, "width": 298, "height": 147, "boundWidth": 1366, "boundHeight": 206, "title": "Trịnh công sơn - immortal"    }, { "x": 304, "y": 56, "x2": 544, "y2": 204, "width": 240, "height": 148, "boundWidth": 1366, "boundHeight": 206, "title": "Mặt trời lạnh"    }, { "x": 548, "y": 100, "x2": 662, "y2": 203, "width": 114, "height": 103, "boundWidth": 1366, "boundHeight": 206, "title": "Taylor swilf - You belong with me"    }, { "x": 548, "y": 4, "x2": 662, "y2": 95, "width": 114, "height": 91, "boundWidth": 1366, "boundHeight": 206, "title": "Lady gaga - LomeGame"    }, { "x": 666, "y": 1, "x2": 871, "y2": 203, "width": 205, "height": 202, "boundWidth": 1366, "boundHeight": 206, "title": "Lương Bích Hữu - hoc cách đi một mình"    }, { "x": 877, "y": 2, "x2": 1100, "y2": 139, "width": 223, "height": 137, "boundWidth": 1366, "boundHeight": 206, "title": "Nhạc film hàn quốc mới nhất vol 8"    }, { "x": 1105, "y": 0, "x2": 1365, "y2": 205, "width": 260, "height": 205, "boundWidth": 1366, "boundHeight": 206, "title": "tâm sự người lính trẻ"    }]
    }
}
// sample model {"x":307,"y":56,"x2":545,"y2":203,"width":238,"height":147,"boundWidth":1366,"boundHeight":206}
/**
 *
 * */
function TagPosition(title, x ,y ,x2, y2, w,h,bw,bh){
    this.x = x;
    this.y = y;
    this.x2 = x2;
    this.y2 = y2;
    this.width = w;
    this.height = h;
    this.boundWidth = bw;
    this.boundHeight = bh;
    this.title = title;

}
