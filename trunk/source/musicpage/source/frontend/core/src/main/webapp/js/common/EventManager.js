/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
eventManager = {
    init : function(){
        $("body").click(this.onclick);
    },
    onclick : function (e){
        //e.taget
        var currentPage = pagesManager.currentPage;
        for(var i = 0;i < currentPage.length;i++){
            pagesManager.controllers[currentPage[i]].onclick(e);
        }
    }
}
