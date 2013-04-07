/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 */
BaseView = {
    inherits:function(destination) {
        for (var prototype in this) {
            destination[prototype] = this[prototype];
        }
    }
}
BaseView.prototype = {
    updateView:function(){}
}