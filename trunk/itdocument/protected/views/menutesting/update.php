<?php
$this->breadcrumbs=array(
	'Menutestings'=>array('index'),
	$model->name=>array('view','id'=>$model->menuid),
	'Update',
);

$this->menu=array(
	array('label'=>'List Menutesting', 'url'=>array('index')),
	array('label'=>'Create Menutesting', 'url'=>array('create')),
	array('label'=>'View Menutesting', 'url'=>array('view', 'id'=>$model->menuid)),
	array('label'=>'Manage Menutesting', 'url'=>array('admin')),
);
?>

<h1>Update Menutesting <?php echo $model->menuid; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>