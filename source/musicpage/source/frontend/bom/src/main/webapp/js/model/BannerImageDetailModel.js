/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/12/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
function BannerImageDetailModel(){
    this.listAlbumTags = [];
    this.tempTag = null;
    this.listAlbumName; // this list call from server
    this.createOfflineData = function(){
        this.listAlbumName = ['Lady gaga','Trinh Cong son','Cao thai son','Phu du','Top nhac han no1','Pede la tat ca','Luyen vo tren nui ta lon','kiep co hon','Doi FA','']
    }
}