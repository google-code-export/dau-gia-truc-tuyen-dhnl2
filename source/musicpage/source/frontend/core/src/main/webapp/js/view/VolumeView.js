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
        $("#volumePanel").css("display","none");
    }

    this.getMainNode = function(){
        return "volumePanel";
    }

}
BaseView.inherits(VolumeView);