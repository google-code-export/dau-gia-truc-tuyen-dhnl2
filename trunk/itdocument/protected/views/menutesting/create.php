<?php
$this->breadcrumbs=array(
	'Menutestings'=>array('index'),
	'Create',
);

$this->menu=array(
	array('label'=>'List Menutesting', 'url'=>array('index')),
	array('label'=>'Manage Menutesting', 'url'=>array('admin')),
);
?>

<h1>Create Menutesting</h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>