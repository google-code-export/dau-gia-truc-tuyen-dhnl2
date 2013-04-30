/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 4/29/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
function VolumeView(){
    this.updateView = function(){
        //TODO : hide volume panel, only display when click volume
        $("#volumePanel").addClass("undisplayed");
    }

    this.getMainNode = function(){
        return "volumePanel";
    }
    this.hideVolumePanel = function (){
        $("#volumePanel").addClass("undisplayed");
    }
    this.showVolumePanel = function(){
        $("#volumePanel").removeClass("undisplayed");

    }
}
BaseView.inherits(VolumeView);