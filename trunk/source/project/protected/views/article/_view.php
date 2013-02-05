<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('id_article')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->id_article), array('view', 'id'=>$data->id_article)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('title')); ?>:</b>
	<?php echo CHtml::encode($data->title); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('content')); ?>:</b>
	<?php echo CHtml::encode($data->content); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('subtitle')); ?>:</b>
	<?php echo CHtml::encode($data->subtitle); ?>
	<br />


</div>