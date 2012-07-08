<div class="form">

<?php $form=$this->beginWidget('CActiveForm', array(
	'id'=>'song-myformsong-form',
	'enableAjaxValidation'=>false,
)); ?>

	<p class="note">Fields with <span class="required">*</span> are required.</p>

	<?php echo $form->errorSummary($model); ?>

	<div class="row">
		<?php echo $form->labelEx($model,'rate'); ?>
		<?php echo $form->textField($model,'rate'); ?>
		<?php echo $form->error($model,'rate'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'name'); ?>
		<?php echo $form->textField($model,'name'); ?>
		<?php echo $form->error($model,'name'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'performer'); ?>
		<?php echo $form->textField($model,'performer'); ?>
		<?php echo $form->error($model,'performer'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'writer'); ?>
		<?php echo $form->textField($model,'writer'); ?>
		<?php echo $form->error($model,'writer'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'genrename'); ?>
		<?php echo $form->textField($model,'genrename'); ?>
		<?php echo $form->error($model,'genrename'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'size'); ?>
		<?php echo $form->textField($model,'size'); ?>
		<?php echo $form->error($model,'size'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'date'); ?>
		<?php echo $form->textField($model,'date'); ?>
		<?php echo $form->error($model,'date'); ?>
	</div>

	<div class="row">
		<?php echo $form->labelEx($model,'resource'); ?>
		<?php echo $form->textField($model,'resource'); ?>
		<?php echo $form->error($model,'resource'); ?>
	</div>


	<div class="row buttons">
		<?php echo CHtml::submitButton('Submit'); ?>
	</div>

<?php $this->endWidget(); ?>

</div><!-- form -->