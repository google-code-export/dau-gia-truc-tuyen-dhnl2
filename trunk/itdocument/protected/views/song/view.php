<?php
$this->breadcrumbs=array(
	'Songs'=>array('index'),
	$model->name,
);

$this->menu=array(
	array('label'=>'List Song', 'url'=>array('index')),
	array('label'=>'Create Song', 'url'=>array('create')),
	array('label'=>'Update Song', 'url'=>array('update', 'id'=>$model->songid)),
	array('label'=>'Delete Song', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->songid),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Song', 'url'=>array('admin')),
);
?>

<h1>View Song #<?php echo $model->songid; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'songid',
		'name',
		'performer',
		'writer',
		'genrename',
		'rate',
		'size',
		'date',
		'resource',
	),
)); ?>
