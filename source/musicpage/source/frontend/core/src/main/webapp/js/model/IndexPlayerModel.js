/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/16/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
function IndexPlayerModel(htmlPlayer){
    var srcO = getUrlPram("link");//http://data.chiasenhac.com/downloads/1049/2/1048194-d50e352c/320/Toi%20Ru%20Em%20Ngu%20-%20Khanh%20Ly%20[MP3%20320kbps].mp3
    this.player = htmlPlayer;
    this.currentPlayIndex = 0;
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
}