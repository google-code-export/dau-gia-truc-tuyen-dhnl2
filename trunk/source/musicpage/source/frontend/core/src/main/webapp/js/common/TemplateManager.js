/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

templateManager = {
    listTemplates:new Array(),
    init:function(synchronousFunction){
        var self = this;
        $.get(templateUrl,function(data){

            self.listTemplates = data.split(",");
            if(synchronousFunction instanceof Function) synchronousFunction();
            }
        )
    },
    t:function(keyTemplate){
       for(var i = 0; i < this.listTemplates.length;i++){
           if(this.listTemplates[i].indexOf(keyTemplate)!=-1){
              var value = this.listTemplates[i].split(":::")[1]; 
              return value.trim() ;
           }
       } 
    }
}
       

