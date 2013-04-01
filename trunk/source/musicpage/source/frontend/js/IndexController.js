function IndexController (){
    this.templatePlayingSongsList = "";
    this.init = function(){
        this.loadOfflineData();
        this.updateView();
    }, 
    this.updateView = function(){
        var listSongsPlaying = this.model.playingSongsList;
        var ulListSongsPlaying = $("#listSongsPlaying")[0];
        ulListSongsPlaying.innerHTML = "";
        for(var i = 0; i< listSongsPlaying.length;i++){
            var li = $(templateManager.t("templatePlayingSongsList"))[0];
            li.innerHTML = li.innerHTML .replace("#text1# ",listSongsPlaying[i].title);
            ulListSongsPlaying.appendChild(li);
        }
    },
    this.loadOfflineData = function(){
        this.model = new IndexModel;
        this.model.createOfflineData();
        
        
    }
};

