<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'song-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model,'name',array('size'=>60,'maxlength'=>100)); ?>
		<?php echo $form->error($model,'name'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'performer'); ?>
		<?php echo $form->textField($model,'performer',array('size'=>60,'maxlength'=>100)); ?>
		<?php echo $form->error($model,'performer'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'writer'); ?>
		<?php echo $form->textField($model,'writer',array('size'=>60,'maxlength'=>100)); ?>
		<?php echo $form->error($model,'writer'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'genrename'); ?>
		<?php echo $form->textField($model,'genrename',array('size'=>60,'maxlength'=>100)); ?>
		<?php echo $form->error($model,'genrename'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'rate'); ?>
		<?php echo $form->textField($model,'rate'); ?>
		<?php echo $form->error($model,'rate'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'size'); ?>
		<?php echo $form->textArea($model,'size',array('rows'=>6, 'cols'=>50)); ?>
		<?php echo $form->error($model,'size'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'date'); ?>
		<?php echo $form->textField($model,'date'); ?>
		<?php echo $form->error($model,'date'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'resource'); ?>
		<?php echo $form->fileField($model,'resource'); ?>
		<?php echo $form->error($model,'resource'); ?>
	</div>

	<div class="row buttons">
		<?php echo CHtml::submitButton($model->isNewRecord ? 'Create' : 'Save'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->