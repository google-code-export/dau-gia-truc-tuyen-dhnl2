/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/8/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
function TopAlbumController(){
    this.init = function(){

    },
    this.createModel = function(){
        var model = new TopAlbumModel(this);
        model.createOfflineData();
        return model;
    },
    this.onClick = function(){

    },
    this.createView = function(){
        return new TopAlbumView();
    }
}
BaseController.inherits(TopAlbumController);