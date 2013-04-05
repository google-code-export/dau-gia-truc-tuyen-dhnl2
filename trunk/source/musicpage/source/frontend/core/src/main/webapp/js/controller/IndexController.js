function IndexController (){
    this.init = function(){
        this.loadOfflineData();
        this.updateView();
        this.player = $("#playerObject")[0];
        this.playSong(0);
    }, 
    this.updateView = function(){
        var listSongsPlaying = this.model.playingSongsList;
        var ulListSongsPlaying = $("#listSongsPlaying")[0];
        ulListSongsPlaying.innerHTML = "";
        for(var i = 0; i< listSongsPlaying.length;i++){
            var stringLi =  templateManager.t("templatePlayingSongsList");
            stringLi = stringLi.replace("#text1#",listSongsPlaying[i].title);
            var li = $(stringLi)[0];
            ulListSongsPlaying.appendChild(li);
            $(li.children[4]).removeClass("undisplayed");
            $(li.children[1]).removeClass("undisplayed");
            $(li.children[2]).removeClass("undisplayed");
            $(li.children[3]).removeClass("undisplayed");
        }
        
        $('#listSongsPlaying').jScrollPane();
    },
    this.loadOfflineData = function(){
        this.model = new IndexModel;
        this.model.createOfflineData();
    },
    this.playSong = function(index){
        this.model.selectedIndexSong = index;
        this.player.src = this.model.playingSongsList[index].src;
        this.player.play();
    }
    
}

