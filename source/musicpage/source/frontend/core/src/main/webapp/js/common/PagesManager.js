/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/6/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
pagesManager = {
    controllers:new Array(),
    showPage:function(page){
        for (var i = 0; i < page.length; i++) {
            if (this.controllers.indexOf(page[i])==-1) {
                this.controllers.push(new page[i]);
            }
            var ctrl = this.controllers[this.controllers.indexOf(page[i])];
            var view = ctrl.createView();
            view.ctrl = ctrl;
            ctrl.view = view;
            ctrl.model = ctrl.createModel();

            ctrl.view.model = ctrl.model;
            ctrl.view.updateView();
            ctrl.init();

        }

    }
}
pagesManager.controllers.indexOf = function(ctrlClass){
    for(var i = 0;i < this.length; i++){
         if(this[i] instanceof ctrlClass) return i;
    }
    return -1;
}