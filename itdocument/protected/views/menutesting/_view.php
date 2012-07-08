<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('menuid')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->menuid), array('view', 'id'=>$data->menuid)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('name')); ?>:</b>
	<?php echo CHtml::encode($data->name); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('parrentid')); ?>:</b>
	<?php echo CHtml::encode($data->parrentid); ?>
	<br />


</div>