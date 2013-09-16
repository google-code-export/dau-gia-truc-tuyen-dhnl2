var urlShop = "http://127.0.0.1:8080/musicpage-service/rest/shop/topdown"

var pathHtml = [
"html/ShowProduct.html" ,
"html/SpCloneItem.html"
]
var pathCss = "css/style.less";

var pathScript = [
//"js/libs/oops.js",
"js/libs/less-1.3.3.min.js",
//"js/libs/PagesManager.js",
//"js/models/example.js",
//"js/libs/BaseController.js",
//"js/libs/BaseView.js",

//"js/controllers/ShowProductController.js",
//"js/views/ShowProductView.js",
//"js/models/ShowProductModel.js",
//"js/Pages.js",

"js/libs/sampleload.js"
//TODO : if there are more module . just add path of load.js of those modules

]



var indexHtml = 0;
var loadHtml = function(){
	if(indexHtml== pathHtml.length){
		completeLoad();	
	} else {

        $.get(pathHtml[indexHtml],{}, function(data,textStatus,jqXhr) {
            console.log(pathHtml[indexHtml] + " OK");
            $("body").append(data);
            indexHtml++;
            loadHtml();
        }).fail(function(jqxhr, settings, exception){
            console.log(pathHtml[indexHtml] + " "+exception);
        });

//		$("body").append(pathHtml[indexHtml], function(res)
//		{
//		    console.log(pathHtml[indexHtml] + " OK");
//		    indexHtml++;
//		    loadHtml();
//		});
	}
}

var indexPath = 0;
var loadScript = function(){
    //TODO upgrade -> at cindex.html find in index.html with all file script load it
    if(indexPath== pathScript.length){
        loadHtml();
    } else {
		$.getScript(pathScript[indexPath], function(script,textStatus,jqXhr)
		{
		    console.log(pathScript[indexPath] + " "+textStatus);
		    indexPath++;
		    loadScript();
		}).fail(function(jqxhr, settings, exception){
                console.log(pathScript[indexPath] + " "+exception);
        });

//        var script = document.createElement("script");
//        script.src = pathScript[indexPath];
//
//        $("head").append(script);
//        console.log(pathScript[indexPath] + " OK ");
//        indexPath++;
//        loadScript();

    }
}

var loadCss = function(){
    $('head').append( $('<link rel="stylesheet/less" type="text/css" />').attr('href', pathCss) );
    loadScript();
}
loadCss();


var completeLoad = function(){
	console.log("complelete load");
    pagesManager.showPage(Pages.index2);
}