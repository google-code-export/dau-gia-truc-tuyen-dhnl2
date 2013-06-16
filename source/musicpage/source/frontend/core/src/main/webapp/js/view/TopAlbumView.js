/**
 * Created by IntelliJ IDEA.
 * User: tuanlhd
 * Date: 4/8/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
function TopAlbumView(){
    this.TABLE_CLASS = "tableAlbums";
    this.COLUMN_COUNT = 12;
    this.ROW_COUNT = 5;
    this.updateView = function(){
        this.addNewTable();
        this.mergeTable(null,this.TABLE_CLASS,this.model.listMerge);
        this.addSearchTextBox($("."+this.TABLE_CLASS+" tr:eq(0) td:eq(4)"));
        //remove cells
        this.removeCellsByColSpanAndRowSpan(null,this.TABLE_CLASS,this.model.listMerge);
    }

    this.addNewTable = function(){
        // 12 col 5 row
        // w :71 h 105
        var table  = $("<table border='0' ></table>");
        table.addClass(this.TABLE_CLASS);
        for (var i = 0 ; i<this.ROW_COUNT;i++){
            var tr = document.createElement("tr");
            for(var j = 0; j < this.COLUMN_COUNT;j++){
                var td = document.createElement("td");
                $(tr).append(td);
            }
            table.append(tr);
        }
        $("#"+this.getMainNode()).append(table);


    }

    this.mergeTable = function(idTable, classTable, model){
//        var listMerge = this.model.listMerge;
        var listMerge = model;
        for(var i = 0 ;i<listMerge.length;i++){
            var m = listMerge[i];
            var s = "."+classTable+" tr:eq(row) td:eq(column)".replace("row",m.row).replace("column",m.column);
            var td = $(s)[0];
            if(m.rowSpan>1)td.rowSpan = m.rowSpan;
            if(m.colSpan>1)td.colSpan = m.colSpan;
        }
    }

    /**
     *
     * @param idTable
     * @param classTable
     * @param model this.model.listMerge
     */
    this.removeCellsByColSpanAndRowSpan = function(idTable,classTable, model){
        var s = ".classTable tr:eq(row) td:eq(column)".replace("classTable",classTable);
        var listObjectToRemove = new Array;
        var listMerge = model;
        for(var k = 0 ;k<listMerge.length;k++){
            var column = listMerge[k].column;
            var row = listMerge[k].row;
            var rowSpan = listMerge[k].rowSpan;
            var colSpan = listMerge[k].colSpan;
            for(var j = 0;j < rowSpan;j++ ){
                for(var i = 0 ;i<colSpan;i++){
                    if(i==0 && j== 0){

                    }else{
                        var selector = s.replace("column",column+i).replace("row",row + j);
                        listObjectToRemove .push($(selector));
                    }
                }
            }
        }

        for(var i = 0;i<listObjectToRemove.length;i++){
            listObjectToRemove[i].remove();
        }
    }

    this.addImagesToTableByLinear = function(idTable,classTable,model){
        var listTD = $("."+classTable+" td");

        for(var i = 0;i < listTD.length ; i++){
            listTD[i].style.background = "url(ddd)".replace("ddd",model[i].src);
            listTD[i].style.backgroundSize = "100%";
        }

        this.removeImageAtSearchArea(null,this.TABLE_CLASS);
    }
    /**
     *
     * @param parrentElement
     */
    this.addSearchTextBox = function(parrentElement){
        var searchDiv = templateManager.t("templateSearchBanner");
        searchDiv = $(searchDiv);
        $(parrentElement).append(searchDiv);
    }

    this.removeImageAtSearchArea = function(idTable,classTable){
        var td = $("."+classTable+" input").parents("td");
        td[0].style.backgroundImage = "";
    }

    this.setPositionForBanner = function(){
        var listAlbum = this.model.listAlbum;
        var ulListAlbumPosition = $("#listAlbumPosition")[0];
        ulListAlbumPosition.innerHTML = "";
        var widthListAlbum = $("#listAlbumPosition").width();
        var rate = widthListAlbum/ listAlbum[0].boundWidth;
        for(var i = 0; i< listAlbum.length; i++){
            var li = document.createElement("li");
            li.style.height = listAlbum[i].height*rate+"px";
            li.style.width = listAlbum[i].width*rate+"px";
            li.style.top = listAlbum[i].y*rate+"px";
            li.style.left = listAlbum[i].x*rate+"px";
            li.style.position = "absolute";
            li.title =  listAlbum[i].title;
            ulListAlbumPosition.appendChild(li);
        }
    }

    this.getMainNode = function(){
        return "header";
    }
}

BaseView.inherits(TopAlbumView);
