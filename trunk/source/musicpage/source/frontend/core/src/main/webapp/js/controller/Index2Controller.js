/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 6/8/13
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
function Index2Controller (){
    this.init = function(){
        //whenever controller is new, it will be called

    },
    /**
     * Create view for controling View html
     **/
    this.createView = function(){
        //whenever controller is new, it will be called
        return new Index2View();
    },
    /**
     * first model , using for update view in VIew
      */
    this.createModel = function(){
        //whenever controller is new, it will be called

        return null;
    },

    this.onClick = function(e){

    }
}
BaseController.inherits(Index2Controller);


