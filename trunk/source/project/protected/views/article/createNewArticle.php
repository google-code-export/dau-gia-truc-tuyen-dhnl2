<style type="text/css">
    .article_title {
        margin-bottom: 20px;
        width: 548px;
    }
    .button{
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#feffe8), color-stop(100%,#d6dbbf));
        height: 30px;
        margin-top: 10px;
    }
    
    
</style>
<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


?>

<label> Title </label><br/>
<?php 
echo CHtml::textField("article_title","",array('class'=>'article_title'));
?>
<br/>
<label> Subtitle </label><br/>
<?php 
echo CHtml::textField("article_subtitle","",array('class'=>'article_title'));
?>
<br/>
<label> Content </label><br/>

<textarea id="article_content" name="article_content" rows="4" cols="50">
At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies. 
</textarea>

<?php 
echo CHtml::button("Create new ",array(
    'onClick'=>'sendNewArticle()',
    'class'=>'button'
    ));
?>

<script>
    CKEDITOR.replace( 'article_content', {
	magicline_color: 'blue',
        fullPage: true
    });
    sendNewArticle = function(){
        var title = $("#article_title")[0].value;
        var subtitle = $("#article_subtitle")[0].value;
        var content = CKEDITOR.instances['article_content'].getData();
         $.ajax({
            type: 'POST',
            url:  "<?php echo CHtml::normalizeUrl(array('Article/CreateNewArticle')); ?>",
            data: {
               title:title,
               subtitle:subtitle,
               content:content
            },
            success: function (res) {
            },
            error:function(jqXHR,textStatus,errorThrown ){
                
            },
            dataType: "html"
        }); 
    }
   
</script>

