/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/12/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
function BannerImageDetailController(){
    this.createView = function(){
        return new BannerImageDetailView();
    }

}
BaseController.inherits(BannerImageDetailController);

