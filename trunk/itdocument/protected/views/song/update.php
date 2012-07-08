<?php
$this->breadcrumbs=array(
	'Songs'=>array('index'),
	$model->name=>array('view','id'=>$model->songid),
	'Update',
);

$this->menu=array(
	array('label'=>'List Song', 'url'=>array('index')),
	array('label'=>'Create Song', 'url'=>array('create')),
	array('label'=>'View Song', 'url'=>array('view', 'id'=>$model->songid)),
	array('label'=>'Manage Song', 'url'=>array('admin')),
);
?>

<h1>Update Song <?php echo $model->songid; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>