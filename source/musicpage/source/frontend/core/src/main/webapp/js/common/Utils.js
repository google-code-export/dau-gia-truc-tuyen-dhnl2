/**
 * Created by IntelliJ IDEA.
 * User: letuan
 * Date: 4/30/13
 * Time: 10:25 AM
 * To change this template use File | Settings | File Templates.
 */
getUrlPram = function getURLParameter(name) {
    return decodeURI(
        (RegExp(name + '=' + '(.+?)(&|$)').exec(location.search)||[,null])[1]
    );
}

//the code below is a plugin
//length: how many bars
//height: height of the tallest bar
//nowselected: which bar is selected
function drawvolumecontroller(length,height,nowselected){
	document.getElementById("volumcontroller").innerHTML = "";
	for (i=0;i<length;i++){
		var magassag = 7 + Math.round((1.4)*(length - i)); //where 40 is the container height
		var margintop = height-magassag;
		if (margintop <= 0) {margintop=0;}
		if (i >= nowselected){		//background-color valtozik ameddig epp ki van jelolve
			document.getElementById("volumcontroller").innerHTML = document.getElementById("volumcontroller").innerHTML+'<div  onmouseup="volumecontrolchanged('+i+')" style="background-color:#898989;height:'+magassag+'px;margin-top:'+margintop+'px;" class="volumecontrollerbar"></div>';
		} else {
			document.getElementById("volumcontroller").innerHTML = document.getElementById("volumcontroller").innerHTML+'<div  onmouseup="volumecontrolchanged('+i+')" style="height:'+magassag+'px;margin-top:'+margintop+'px;" class="volumecontrollerbar"></div>';
		}
	}
}
function volumecontrolchanged(newvolume){
	drawvolumecontroller(20,35,newvolume);
	document.getElementById("volumeindicator").innerHTML = newvolume;
//	alert(newvolume);
}
/**
 *
 * @param textfield html object
 * @param model array of strings to display auto complete
 */
function makeAutoComplete (textfield, model){
    $(textfield).addClass('dhx_combo_input');
    var width = textfield.offsetWidth;
    var comboList = $(".dhx_combo_list.dhx_skyblue_list");
    comboList[0].innerHTML = "";
    for(var i = 0 ;i<model.length; i++ ){
        var d = document.createElement('div');
        d.style.width = '100%';
        d.style.overflow = 'hidden';
        d.innerText = model[i];
        comboList.add(d);
        if(i == 0) {
            d.className = "dhx_selected_option combo_dhx_skyblue_sel";
        }
    }
}