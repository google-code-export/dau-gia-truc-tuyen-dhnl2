This is View YII control</br>
1.Demo using listdata
<?php // start demo using listdata CHtml

    //    echo $arrayitem[0]->songid;
    $listdata = CHtml::listData($arrayitem,'playlistid','playlistname');
    echo Chtml::dropDownList('namecontrol','11'/*<- id value of list */,$listdata);
    echo Chtml::listBox('namecontrol2','12',$listdata);
    /*End show demo using listdata CHtml */ ?>
</br>


2. demo using CactiveForm

<div class="form">

    <?php $form=$this->beginWidget('CActiveForm', array(
        'id'=>'playlist-form',
        'enableAjaxValidation'=>false, "enableClientValidation"=>true
        )); ?>

    <p class="note">Fields with <span class="required">*</span> are required.</p>

    <?php echo $form->errorSummary($model); ?>

    <div class="row">
        <?php echo $form->labelEx($model,'username'); ?>
        <?php echo $form->textField($model,'username',array('size'=>60,'maxlength'=>100)); ?>
        <?php echo $form->error($model,'username'); ?>
    </div>

    <div class="row">
        <?php echo $form->labelEx($model,'playlistname'); ?>
        <?php echo $form->textField($model,'playlistname',array('size'=>60,'maxlength'=>100)); ?>
        <?php echo $form->error($model,'playlistname'); ?>
    </div>

    <div class="row buttons">
        <?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
    </div>

    <?php $this->endWidget(); ?>

</div><!-- form -->

</br>
3. Using Zii.widge</br>
a.CListView . See more in index.php</br>
<div style="width: 100%;"><!-- cai này làm cho cái table nhỏ lại nè-->
<?php
/*
ClistView
Khi sử dụng Clistview bạn cần : 
	1. array Model là danh sách các model sẽ hiển thị
	2. Viewform -> là file php định nghĩa các bố cục hiển thị của model
Một Tip nhỏ để biểu diển ClistItem 3 item in 1 line, 
	1. Ta tạo cho 1 div bao bọc toàn bộ ClistView có width cố định.  Code : style="width: 600px;"
	2. Trong viewform, tao bao bọc lại một div có width bằng 1/3 div ở trên.code : style="width: 200px; float: left;"
	=> như vậy the magic in here is yii auto resize

*/
    $dataProvider=new CActiveDataProvider(Song::model(),
    array(
    'pagination' => array('pageSize' => 3),
    )
    );
    $this->widget('zii.widgets.CListView', array(
		'dataProvider'=>$dataProvider,
		'itemView' => 'ClistViewItem',
		'template'=>'{sorter}</br>{pager}{items}{pager}',/*make some example remove item, or pager*/
		'enableSorting' => true,   /*Enable sorting và sorableAttribute đi chung, dùng 2 cái này để thêm chức năng sort*/
		'sortableAttributes'=>array(
				'name'=>'By name',
			),
    ));
	
	$dataProvider2 = new CArrayDataProvider(Song::model()->findall(),
	array('keyField'=>'songid')
	);
	$this->widget('zii.widgets.CListView', array(
    'dataProvider'=>$dataProvider2,
    'itemView' => 'ClistViewItem',
	'template'=>'{sorter}</br>{pager}{items}{pager}',/*make some example remove item, or pager*/
	'enableSorting' => true,   /*Enable sorting và sorableAttribute đi chung, dùng 2 cái này để thêm chức năng sort*/
	'sortableAttributes'=>array(
            'name'=>'By name',
        ),
	'ajaxUpdate'=>false
    ));
?><!--test widget-->
<div style="clear:both;"></div>
</div>
b.CGridView
<?php 
    $criteria=new CDbCriteria;
    $criteria->compare('playlistid','>1' );
    $dataProvider=new CActiveDataProvider(Playlist::model(),
    array(
    'criteria'=>$criteria,
    'pagination' => array('pageSize' => 2),
    ));

    $this->widget('zii.widgets.grid.CGridView', array(
			'columns' => array('username','playlistname',
				array('name'=>'Bank_Contact_Email_1','type'=>'raw','value'=>'$abc = $data->playlistid'),
				array('class'=>'CLinkColumn','url'=>'$data->playlistid','urlExpression'=>"Yii::app()->createUrl('printjob/update',array('id'=>\$data->playlistid))",),
			),
			'dataProvider'=>$dataProvider,
		)
	);
?>
</br>
--------------------------------CJuiDraggable
<?php
    $this->beginWidget('zii.widgets.jui.CJuiDraggable', array(
    // additional javascript options for the draggable plugin
    'options'=>array(
    'scope'=>'myScope',
    ),
    ));
    echo 'Your draggable content here';
?>
</br>
<?php 
    echo Chtml::image('http://localhost/itdocument/images/questionmark.gif','This is Alternative text' );
?>
<?php
    $this->endWidget();
    /*End widget CJuiDraggable*/ ?>

</br>
CJuiSlider -----------------------------------------------------------</br>
<?php
    $cjuislider = $this->widget('zii.widgets.jui.CJuiSlider', array(
    'id'=>'SliderNomal',
    'value'=>37,
    // additional javascript options for the slider plugin
    'options'=>array(
    'min'=>0,
    'max'=>100,
    'slide'=>'js:function(event, ui) { $("#somecontrol").val(ui.value);}'
    ),
    'htmlOptions'=>array(
    'style'=>'height:10px;'
    ),
    ));
    $actions = $cjuislider->actions();
    print("This is array of actions ");
?>
</br>
<label for="somecontrol">Volume:</label>
<input type="text" id="somecontrol" style="border:0; color:#f6931f; font-weight:bold;" />
</br>
CJuiSliderInput -------------------------------------------------------------------------------
<?php
    $model2 = Song::model()->findByPk(0);
    $this->widget('zii.widgets.jui.CJuiSliderInput', array(
    'model'=>$model2,
    'attribute'=>'rate',
    'name'=>'SliderInputddd',
    'maxAttribute'=>'size',
    // additional javascript options for the slider plugin
    'options'=>array(
    'range'=>true,
    'min'=>0,
    'max'=>24,
    ),
    ));

?>

</br>
CJuiAutoComplete -----------------------------------------</br>
<?php
    $this->widget('zii.widgets.jui.CJuiAutoComplete', array(
    'name'=>'city',
    'source'=>array('ac1', 'ac2', 'ac3', 'Tao lao bi dao'),
    // additional javascript options for the autocomplete plugin
    'options'=>array(
    'minLength'=>'0',
    'select'=>'js:function(event, ui) {
    var source = $( "#city" ).autocomplete( "option", "source" );  alert(\'Selected : \'+source);
    $.get(\'/itdocument/?r=showHelloWorld/AjaxChangeAutocomplete\', function(data) {
    $( "#city" ).autocomplete( "option", "source", data.split(",") );
    alert(data.split(","));
    });}',
    ),
    'htmlOptions'=>array(
    'style'=>'height:20px;'
    ),
    ));
?>
</br>
CDetailView ----------------------------------------------------------</br>
<?php
    $model = Song::model()->findbypk(5);
    $this->widget('zii.widgets.CDetailView', array(
    'data'=>$model,
    'attributes'=>array(
    'songid',             // title attribute (in plain text)
    'name',        // an attribute of the related object "owner"
    'name:html',  // description attribute in HTML
    array(               // related city displayed as a link
    'label'=>'TEO TEOOTOPI',
    'type'=>'raw',
    'value'=>CHtml::link(CHtml::encode($model->songid),
    array('city/view','id'=>$model->songid)),
    ),
    ),
    ));

?>
</br>
CTabView ----------------------------------------------------------</br>
<?php
    //$viewData = array('songList'=>Song::model()->findAll());
    $Tabs     = array(

    'tab1' => array(
    'title' => 'Demo 1 ',
    'view' => '/song/view', /* locate songcontroller -> actionview */
    ),

    'tab2' => array(
    'title' => 'Demo 2',
    'view' => 'nulll', /* locate the view php, locate in views/showhelloworl/nulll.php */
    ),	);
/*viewdata là array dùng để render dữ liệu cho từng view, giống như render trong controller, ở đây cụ thể là đã dùng renderpartial() */
    $this->widget('CTabView', array('tabs'=>$Tabs,'viewData'=>array ('model' => Song::model()->findbypk(5),'y'=>'99999',),));
?>
CStarRating ----------------------------------------------------------</br>
<?php
$this->widget('CStarRating',array(
				'name'=>'rating',
				'value'=>5,
				'callback'=>"function()
				{	
					$.ajax(
					{
						type: 'POST',
						url: '?r=showhelloworld/ShowViewYii',
						data: 'value='+$(this).val(),
						success: function(msg){alert( 'Data Saved: ' + msg );},
					}
					);
				}"
				));
?>
</br>Cportlet ----------------------------------------------------------</br>
<?php $this->beginWidget('zii.widgets.CPortlet'); ?>
    ...insert content here...
<?php $this->endWidget(); ?>
</br>Cdialog ----------------------------------------------------------</br>
<?php
$this->beginWidget('zii.widgets.jui.CJuiDialog', array(
    'id'=>'mydialog',
    // additional javascript options for the dialog plugin
    'options'=>array(
        'title'=>'Dialog box 1',
        'autoOpen'=>false,
    ),
));

    echo 'dialog content here';

$this->endWidget('zii.widgets.jui.CJuiDialog');

// the link that may open the dialog
echo CHtml::link('open dialog', '#', array(
   'onclick'=>'$("#mydialog").dialog("open"); return false;',
));
?>
<?php
$this->beginWidget('zii.widgets.jui.CJuiDroppable', array(
    // additional javascript options for the droppable plugin
    'options'=>array(
        'scope'=>'myScope',
    ),
));
    echo 'Your droppable content here'."</br>";
	echo 'Your droppable content here'."</br>";
	echo 'Your droppable content here'."</br>";
	echo 'Your droppable content here'."</br>";
	echo 'Your droppable content here'."</br>";
$this->endWidget();

?>
</br>CJuiProgressBar ----------------------------------------------------------</br>
<?php
$this->widget('zii.widgets.jui.CJuiProgressBar', array(
    'value'=>75,
    // additional javascript options for the progress bar plugin
    'options'=>array(
        'change'=>'js:function(event, ui) {}',
    ),
    'htmlOptions'=>array(
        'style'=>'height:20px;'
    ),
));
?>
</br>CJuiResizable ----------------------------------------------------------</br>
<?php
$this->beginWidget('zii.widgets.jui.CJuiResizable', array(
    // additional javascript options for the resizable plugin
    'options'=>array(
        'minHeight'=>'150',
    ),
));
    echo 'Your Resizable content here';

$this->endWidget();

?>
</br>CJuiSelecable ----------------------------------------------------------</br>
<?php
$this->widget('zii.widgets.jui.CJuiSelectable', array(
    'items'=>array(
        'id1'=>'Item 1',
        'id2'=>'Item 2',
        'id3'=>'Item 3',
    ),
    // additional javascript options for the selectable plugin
    'options'=>array(
        'delay'=>'300',
    ),
));

?>
</br>CJuiSelecable ----------------------------------------------------------</br>
CJuiSortable makes selected elements sortable by dragging with the mouse. 
<?php
$this->widget('zii.widgets.jui.CJuiSortable', array(
    'items'=>array(
        'id1'=>'Item 1',
        'id2'=>'Item 2',
        'id3'=>'Item 3',
    ),
    // additional javascript options for the accordion plugin
    'options'=>array(
        'delay'=>'300',
    ),
));
?>
</br>CJuiTabs ----------------------------------------------------------</br>
<?php
$this->widget('zii.widgets.jui.CJuiTabs', array(
    'tabs'=>array(
        'StaticTab 1'=>'Content for tab 1',
        'StaticTab 2'=>array('content'=>'Content for tab 2', 'id'=>'tab2'),
        // panel 3 contains the content rendered by a partial view
        'AjaxTab'=>array('ajax'=>'?r=song'),
    ),
    // additional javascript options for the tabs plugin
    'options'=>array(
        'collapsible'=>true,
    ),
));
?>