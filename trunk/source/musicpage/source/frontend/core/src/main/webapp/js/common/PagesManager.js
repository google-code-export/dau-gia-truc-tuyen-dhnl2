/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/6/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Kinh nghiệm: hiển thị dùng id, action event dùng class
 * tại sao. lấy vd tui cần sử dụng lại IndexPlayerControlelr vì nó có các functions
 * cho việc điều khiển bài hát
 * nên tui sẽ viết code html có các bố cục và vị trí giao diện là dùng id.
 * còn khi xử lý hành động onclick , music change , etc thì dùng class để selector
 * như vậy khi dùng ở view mới có id mới vẫn dùng lại đc View của controller cũ. với các class cho trước.
 */

pagesManager = {
    controllers:new Array(),
    currentPage:null,
    showPage:function(page) {
        this.currentPage = page;

        //remove undisplayed class of ids
        var listIds = page.ids;
        //iterate through ids
        for (var i = 0; i < listIds.length; i++) {
            $("#"+listIds[i]).removeClass("undisplayed");
        }


        var listCtrls = page.controllers;
        //iterate through list controllers
        for (var i = 0; i < listCtrls.length; i++) {
            if (!this.controllers[listCtrls[i]]) {
                //check if controller is exist
                this.controllers[listCtrls[i]] = new listCtrls[i];
            }
            var ctrl = this.controllers[listCtrls[i]]; // new Constructor
            var view = ctrl.createView();// create View

            view.ctrl = ctrl;
            ctrl.view = view;
            ctrl.model = ctrl.createModel();

            ctrl.view.model = ctrl.model;
            ctrl.view.updateView();
            ctrl.init(); // run Init()

        }

    }


}
