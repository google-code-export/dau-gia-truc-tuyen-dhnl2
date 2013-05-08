/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/12/13
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
function BannerImageDetailController(){
    this.createView = function(){
        return new BannerImageDetailView();
    }
    this.init = function(){
        this.processOnClick = this.onClickNormalState;
    }
    this.onClick = function(e){
        this.processOnClick(e);
    }
    this.onClickNormalState = function(e){
        var id = e.target.id;
        var className = e.target.className;
        switch (id){

        }

        if(className.indexOf("selectTagButton")!=-1){
            var index = $(e.target.parentNode).index();
            this.view.showTagPosition(index);
        }else if(className.indexOf("editTagButton")!=-1){
            this.view.changeStateEditPosition(e);
            this.processOnClick = this.onClickEdittingState;
        }else if(className.indexOf("removeTagButton")!=-1){
            var index = $(e.target.parentNode).index();
            delete this.model.listAlbumTags[index];
            this.model.listAlbumTags.splice(index,1);
            this.view.updateRemoveEvent(e);
        }

    }
    this.onClickAddingState = function(e){
        var className = e.target.className;
        if(className.indexOf("activeButton")!=-1&&className.indexOf("addTagButton")!=-1){
            var title = $(e.target.parentElement).find('input')[0].value;
            this.model.tempTag.title = title;
            this.model.listAlbumTags.push(this.model.tempTag);
            this.model.tempTag = undefined;
            this.view.updateAddTagEvent(e);
            this.processOnClick = this.onClickNormalState;
        }
    }
    this.onClickEdittingState = function(e){
        var className = e.target.className;
        if(className.indexOf("activeButton")!=-1&&className.indexOf("editTagButton")!=-1){
            var title = $(e.target.parentElement).find('input')[0].value;
            this.model.tempTag.title = title;
            var index = $(e.target.parentNode).index();
            this.model.listAlbumTags[index] = this.model.tempTag;
            this.model.tempTag = undefined;
            this.view.updateEditTagEvent(e);
            this.processOnClick = this.onClickNormalState;
        }
    }
    this.createModel = function(){
        return new BannerImageDetailModel();
    }
}
BaseController.inherits(BannerImageDetailController);

