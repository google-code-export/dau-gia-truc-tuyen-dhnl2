/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/12/13
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
function BannerImageDetailView(){
    this.updateView = function(){
        $("#listAlbumTags")[0].innerHTML = "";
        var self = this;
        $("#listAlbumTags").jScrollPane();
        $("#currentShowingImage img").Jcrop({
                    onSelect: self.onSelectFirstTime,
                    onChange: self.onChange
                }, function() {
            self.model.currentImageEditor = this;
        });
    }
    this.getMainNode =function(){
        return "bannerImageDetail";
    }
    this.onSelectFirstTime = function(e){
        // occurred when drag and release mouse complete
        //onSelect{"x":283,"y":51,"x2":816,"y2":191,"w":533,"h":140}
        var view = pagesManager.controllers[BannerImageDetailController].view;
        var api = $("#listAlbumTags").data('jsp');//guide of Jscrollpane

        //create Li and add addButton
        var liString = templateManager.t("templateAlbumTag");
        liString = liString.replace("removeTagButton","addTagButton");
        liString = liString.replace("#text1#","please add a tag album");
        var li=$(liString);
        //active button addTag
        li.children()[3].style.webkitAnimation = "effectActiveButtonTag 1s";
        setTimeout(function(){li.find(".addTagButton").addClass("activeButton");},1000);

        //add autocomplete field
        $(li.children()[0]).addClass("undisplayed");
        var autoTextfield = document.createElement("input");
        autoTextfield.className +=" autotextBannerAlbum";
        autoTextfield.type = "text";
        li.prepend(autoTextfield);

        //update listAlbumTags JscrollPane
        api.getContentPane().append(li);
        api.reinitialise();
        api.scrollToBottom();
        view.model.tempTag = new TagPosition(e,this.getBounds());

        //change state of method onSelect
        view.ctrl.processOnClick = view.ctrl.onClickAddingState;
        this.setOptions({
            onSelect:view.onSelectAddedNewItem
        });
    }
    this.onSelectAddedNewItem = function(e){
        var view = pagesManager.controllers[BannerImageDetailController].view;
        view.model.tempTag.update(e,this.getBounds());
    }
    this.onChange = function(e){
        //occured when hover

    }
    this.updateAddTagEvent = function(e){
        e.target.className = "removeTagButton";
        e.target.style.webkitAnimation = "effectDeactiveButtonTag 1s";
        this.model.currentImageEditor.release();

        //get value of textfield
        var albumName = $(e.target.parentNode).children()[0].value;
        //hide textfield
        $(e.target.parentNode).children()[0].className +=" undisplayed";
        //show and settext albumName
        $($(e.target.parentNode).children()[1]).removeClass("undisplayed");
        $(e.target.parentNode).children()[1].innerHTML = albumName;
        this.model.currentImageEditor.setOptions({
                    onSelect:this.onSelectFirstTime
                });
    }
    this.showTagPosition = function(index){
        var tagPosition = this.model.listAlbumTags[index];
        this.model.currentImageEditor.animateTo([tagPosition.x,tagPosition.y,tagPosition.x2,tagPosition.y2]);
    }
    this.changeStateEditPosition = function(e){
        //set current tagPosition to tempTag
        var index = $(e.target.parentNode).index();
        this.model.tempTag = this.model.listAlbumTags[index];

        //make effect for edit buttontag
        e.target.style.webkitAnimation = "effectActiveButtonTag 1s";
        setTimeout(function(){
            $(e.target.parentNode).find(".editTagButton").addClass("activeButton");
            e.target.style.webkitAnimation = "";
        },1000);

        //show position and autocomplete
        this.showTagPosition(index);
        this.showAutoComplete(e);

        this.model.currentImageEditor.setOptions({
                    onSelect:this.onSelectEditPosition
                });
    }
    this.onSelectEditPosition = function(e){
        var view = pagesManager.controllers[BannerImageDetailController].view;
        view.model.tempTag.update(e,this.getBounds());
    }
    this.showAutoComplete = function(e){
        $(e.target.parentNode).find("input").removeClass("undisplayed");
        $(e.target.parentNode).find("span").addClass("undisplayed");
    }
    this.updateEditTagEvent = function(e){
        //update albumname
        var liParent = $(e.target.parentNode);
        var albumName = liParent.find("input")[0].value;
        liParent.find("input").addClass("undisplayed");
        liParent.find("span")[0].innerHTML = albumName;
        liParent.find("span").removeClass("undisplayed");

        //clear effect edit button
        liParent.find(".editTagButton")[0].style.webkitAnimation = "effectDeactiveButtonTag 1s";
        setTimeout(function(){liParent.find(".editTagButton").removeClass("activeButton");},1000);

        //change state of Jcrop to firstNew
        this.model.currentImageEditor.setOptions({
                    onSelect:this.onSelectFirstTime
                });

        //release position box
        this.model.currentImageEditor.release();
    }
    this.updateRemoveEvent = function(e){
        //remove item in listAlbumTags
        e.target.parentNode.remove();
        var api = $("#listAlbumTags").data('jsp');
        api.reinitialise();

        //release position box
        this.model.currentImageEditor.release();
    }
}
BaseView.inherits(BannerImageDetailView);