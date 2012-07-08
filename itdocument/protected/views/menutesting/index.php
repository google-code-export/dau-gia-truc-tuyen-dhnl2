<?php
$this->breadcrumbs=array(
	'Menutestings',
);

$this->menu=array(
	array('label'=>'Create Menutesting', 'url'=>array('create')),
	array('label'=>'Manage Menutesting', 'url'=>array('admin')),
);
?>

<h1>Menutestings</h1>

<?php $this->widget('zii.widgets.CListView', array(
	'dataProvider'=>$dataProvider,
	'itemView'=>'_view',
)); ?>
