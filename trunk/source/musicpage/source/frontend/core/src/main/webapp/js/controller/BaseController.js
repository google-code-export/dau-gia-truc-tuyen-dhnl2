/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
BaseController = {
    inherits:function(destination) {
          for (var prototype in this) {
            destination[prototype] = this[prototype];
          }
//          return destination;
    }
}
BaseController.prototype = {
    onClick:function(){},
    createView:function(){},
    createModel:function(){},
    init:function(){},
    onKeyDown : function(){}
}