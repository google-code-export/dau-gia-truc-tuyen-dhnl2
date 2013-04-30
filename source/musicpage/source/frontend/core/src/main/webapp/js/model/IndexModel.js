function IndexModel () {
    this.playingIndexSong = 0,
    this.createOfflineData = function(){
        var srcO = getUrlPram("link");//http://data.chiasenhac.com/downloads/1049/2/1048194-d50e352c/320/Toi%20Ru%20Em%20Ngu%20-%20Khanh%20Ly%20[MP3%20320kbps].mp3
        this.playingSongsList = [
            {title:"Just dance - LadyGaga",src:srcO},
            {title:"Poker face - LadyGaga",src:srcO},
            {title:"Bad romance - LadyGaga",src:"http://,..."},
            {title:"Paparazzi - LadyGaga",src:"http://,..."},
            {title:"TelePhone - LadyGaga",src:"http://,..."},
            {title:"Just dance - LadyGaga",src:srcO},
            {title:"Poker face - LadyGaga",src:srcO},
            {title:"Bad romance - LadyGaga",src:"http://,..."},
            {title:"Paparazzi - LadyGaga",src:"http://,..."},
            {title:"TelePhone - LadyGaga",src:"http://,..."},
            ];

        this.songsResultList = [
            {title:"jjjjjjjjjjjj",src:"http://,...",artist:"abcx",listenCount:213124},
            {title:"5555515151",src:"http://,...",artist:"abcx",listenCount:213124},
            {title:"15151515",src:"http://,...",artist:"abcx",listenCount:213124},
            {title:"3312341212",src:"http://,...",artist:"abcx",listenCount:213124},
            {title:"7778787878",src:"http://,...",artist:"abcx",listenCount:213124},
            {title:"09090909090909",src:"http://,...",artist:"abcx",listenCount:213124},
        ];

        this.categories = [
            {title:"POP",link:"http://,..."},
            {title:"ROCK",link:"http://,..."},
            {title:"DAN CA",link:"http://,..."},
            {title:"RAP",link:"http://,..."},
            {title:"KHAC",link:"http://,..."},
        ];
    }
}

