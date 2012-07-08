<?php
    $this->breadcrumbs=array(
    'Show Hello World',
    );?>
<h1><?php echo $this->id . '/' . $this->action->id; ?></h1>

<p> <? $ccc = $data->toArray();
        echo ($ccc[3]); ?> 
</p>
<p>
    <?php echo CHtml::Link("Goodbye",array('showHelloWorld/index'));?> 
</p> 
<br />
<? echo Chtml::activeCheckBox($song, "songid"); echo chtml::activeLabel($song, "name"); ?>
<br />
<?php $retrieve =  Song::model()->findByPk($song->songid);
    echo " Here ". $retrieve->name." | ".$song->songid;
?><!-test Song---->
<?
    $dataProvider=new CActiveDataProvider(Song::model(),
    array(
    'pagination' => array('pageSize' => 6),
    'totalItemCount' => $count,
    )
    );
    $this->widget('zii.widgets.CListView', array(
    'dataProvider'=>$dataProvider,
    'itemView' => '_view'
    ));
?><!--test widget-->
<input type="button" name="asd" id="123" value="okaaaaaa" align="center">
