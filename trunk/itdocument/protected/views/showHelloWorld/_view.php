<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('songid')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->songid), array('view', 'id'=>$data->songid)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('name')); ?>:</b>
	<?php echo CHtml::encode($data->name); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('performer')); ?>:</b>
	<?php echo CHtml::encode($data->performer); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('writer')); ?>:</b>
	<?php echo CHtml::encode($data->writer); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('genrename')); ?>:</b>
	<?php echo CHtml::encode($data->genrename); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('rate')); ?>:</b>
	<?php echo CHtml::encode($data->rate); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('size')); ?>:</b>
	<?php echo CHtml::encode($data->size); ?>
	<br />

	<?php /*
	<b><?php echo CHtml::encode($data->getAttributeLabel('date')); ?>:</b>
	<?php echo CHtml::encode($data->date); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('resource')); ?>:</b>
	<?php echo CHtml::encode($data->resource); ?>
	<br />

	*/ ?>

</div>