<?php
$this->breadcrumbs=array(
	'Issues'=>array('index'),
	$model->id,
);

$this->menu=array(
	array('label'=>'List Issue', 'url'=>array('index')),
	array('label'=>'Create Issue', 'url'=>array('create')),
	array('label'=>'Update Issue', 'url'=>array('update', 'id'=>$model->id)),
	array('label'=>'Delete Issue', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->id),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Issue', 'url'=>array('admin')),
);
?>

<h1>View Issue #<?php echo $model->id; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'id',
		'content',
		'create_user_id',
	),
)); ?>
<div id="comments">
    <?php echo $model->commentCount; if($model->commentCount>=1): ?>
        <h3>
            <?php echo $model->commentCount>1 ? $model->commentCount . ' 
                comments' : 'One comment'; ?>
        </h3>
        <?php $this->renderPartial('_comments',array(
            'comments'=>$model->comments,
            )); ?>
        <?php endif; ?>
    <h3>Leave a Comment</h3>
    <?php if(Yii::app()->user->hasFlash('commentSubmitted')): ?>
        <div class="flash-success">
            <?php echo Yii::app()->user->getFlash('commentSubmitted'); ?>
        </div>
        <?php else: ?>
        <?php $this->renderPartial('/comment/_form',array(
            'model'=>$comment,
            )); ?>
        <?php endif; ?>
</div>