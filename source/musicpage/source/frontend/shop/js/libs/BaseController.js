/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/7/13
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 */
BaseController = function  () {
    this.createView=function(){}.isAbstract();
    this.createModel=function(){}.isAbstract();
    this.refreshController=function(){}.isAbstract();
    this.createEvents=function(){}.isAbstract();
    this.init=function(){
        this.createEvents();
        var view = this.createView();// create View

        view.ctrl = this;
        this.view = view;
        this.model = this.createModel();

        this.view.model = this.model;
        this.view.updateView();

    }.isFinal();
}