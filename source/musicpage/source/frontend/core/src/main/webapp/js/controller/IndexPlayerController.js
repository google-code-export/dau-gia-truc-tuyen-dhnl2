/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/15/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerController(){
    this.init = function(){

    }
    this.createView = function(){
        return new IndexPlayerView();
    }
    this.onClick = function(e){

    }

}
BaseController.inherits(IndexPlayerController);