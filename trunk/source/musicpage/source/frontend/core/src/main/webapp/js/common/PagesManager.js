/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/6/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
pagesManager = {
    controllers:new Array(),
    currentPage:null,
    showPage:function(page) {
        this.currentPage = page;
        for (var i = 0; i < page.length; i++) {
            if (!this.controllers[page[i]]) {
                this.controllers[page[i]] = new page[i];
            }
            var ctrl = this.controllers[page[i]];
            var view = ctrl.createView();
            $("#"+view.getMainNode()).removeClass("undisplayed");
            view.ctrl = ctrl;
            ctrl.view = view;
            ctrl.model = ctrl.createModel();

            ctrl.view.model = ctrl.model;
            ctrl.view.updateView();
            ctrl.init();

        }

    }
}
