/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 4/29/13
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
function VolumeController(){
    this.init = function(){

    }

    this.createView = function(){
        return new VolumeView();
    }

    this.onClick = function(e){
         var id = e.target.id;
        switch(id){
            case "volume":
                this.view.showVolumePanel();
                break;
            default:
                    this.view.hideVolumePanel();
            break;
        }
    }
}
BaseController.inherits(VolumeController);
