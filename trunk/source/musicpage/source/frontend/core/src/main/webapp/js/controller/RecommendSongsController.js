/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 6/16/13
 * Time: 6:38 PM
 * To change this template use File | Settings | File Templates.
 */

function RecommendSongsController(){
    this.init = function(){
        //whenever controller is new, it will be called

    },
    /**
     * Create view for controling View html
     **/
    this.createView = function() {
        //whenever controller is new, it will be called
        return new RecommendSongsView();
    },
    this.createModel = function(){
        //whenever controller is new, it will be called
        var m = new RecommendSongsModel();
        m.createOfflineData();
        return m;
    },
    this.onClick = function(e){

    }
}

BaseController.inherits(RecommendSongsController);
