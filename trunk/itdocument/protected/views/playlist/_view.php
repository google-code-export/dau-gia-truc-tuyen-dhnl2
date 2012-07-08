<div class="view">

	<b><?php echo CHtml::encode($data->getAttributeLabel('playlistid')); ?>:</b>
	<?php echo CHtml::link(CHtml::encode($data->playlistid), array('view', 'id'=>$data->playlistid)); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('username')); ?>:</b>
	<?php echo CHtml::encode($data->username); ?>
	<br />

	<b><?php echo CHtml::encode($data->getAttributeLabel('playlistname')); ?>:</b>
	<?php echo CHtml::encode($data->playlistname); ?>
	<br />


</div>