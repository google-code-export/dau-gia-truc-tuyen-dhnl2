<?php
$this->breadcrumbs=array(
	'Playlists'=>array('index'),
	$model->playlistid=>array('view','id'=>$model->playlistid),
	'Update',
);

$this->menu=array(
	array('label'=>'List Playlist', 'url'=>array('index')),
	array('label'=>'Create Playlist', 'url'=>array('create')),
	array('label'=>'View Playlist', 'url'=>array('view', 'id'=>$model->playlistid)),
	array('label'=>'Manage Playlist', 'url'=>array('admin')),
);
?>

<h1>Update Playlist <?php echo $model->playlistid; ?></h1>

<?php echo $this->renderPartial('_form', array('model'=>$model)); ?>