/**
 * Created by IntelliJ IDEA.
 * User: LeTuan
 * Date: 4/13/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
function TagPosition(eData,bound){
    this.x = eData.x;
    this.y = eData.y;
    this.x2 = eData.x2;
    this.y2 = eData.y2;
    this.width = eData.w;
    this.height = eData.h;
    this.boundWidth = bound[0];
    this.boundHeight = bound[1];
    this.title = undefined;
    this.update = function(eData,bound){
        this.x = eData.x;
        this.y = eData.y;
        this.x2 = eData.x2;
        this.y2 = eData.y2;
        this.width = eData.w;
        this.height = eData.h;
        this.boundWidth = bound[0];
        this.boundHeight = bound[1];
    }
}