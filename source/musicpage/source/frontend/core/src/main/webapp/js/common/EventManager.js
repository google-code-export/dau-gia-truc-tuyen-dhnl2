/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
eventManager = {
    init : function(){
        $("body").click(this.onClick);
        $("body").keydown(this.onKeyDown);
    },
    onClick : function (e){
        //TODO: Delay 200 to make effect of class active
        setTimeout(function(){
            var currentPage = pagesManager.currentPage;
            for(var i = 0;i < currentPage.length;i++){
                pagesManager.controllers[currentPage[i]].onClick(e);
            }
        },200);
    },

    onKeyDown : function(e){
        var currentPage = pagesManager.currentPage;
        for (var i = 0; i < currentPage.length; i++) {
            pagesManager.controllers[currentPage[i]].onKeyDown(e);
        }
    }
}
