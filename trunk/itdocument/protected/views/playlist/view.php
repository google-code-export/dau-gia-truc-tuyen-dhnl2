<?php
$this->breadcrumbs=array(
	'Playlists'=>array('index'),
	$model->playlistid,
);

$this->menu=array(
	array('label'=>'List Playlist', 'url'=>array('index')),
	array('label'=>'Create Playlist', 'url'=>array('create')),
	array('label'=>'Update Playlist', 'url'=>array('update', 'id'=>$model->playlistid)),
	array('label'=>'Delete Playlist', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->playlistid),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Playlist', 'url'=>array('admin')),
);
?>

<h1>View Playlist #<?php echo $model->playlistid; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'playlistid',
		'username',
		'playlistname',
	),
)); ?>
