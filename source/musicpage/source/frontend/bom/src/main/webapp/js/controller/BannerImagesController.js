/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/11/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
function BannerImagesController(){
    this.init = function(){

    }
    this.createView = function(){
        return new BannerImagesView();
    }
}
BaseController.inherits(BannerImagesController);