<!---  Team --->
<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="css/login.css" media="screen" />
<!--  datepicker-->
<link rel="stylesheet" href="jqueryApp/datepicker/themes/base/jquery.ui.all.css">
<script type="text/javascript" src="js/alogin.js"></script>
<script src="jqueryApp/jqueryLibs/jquery-1.7.2.js"></script>
<script src="jqueryApp/datepicker/jquery.ui.core.js"></script>
<script src="jqueryApp/datepicker/jquery.ui.widget.js"></script>
<script src="jqueryApp/datepicker/jquery.ui.datepicker.js"></script>
<script src="jqueryApp/datepicker/jquery.ui.datepicker-vi.js"></script>
<script>
    //            $(function() {
    //                $( "#rg_birthday" ).datepicker();
    //            });
    $(function() {
        $( "#rg_birthday" ).datepicker({
            changeMonth: true,
            changeYear: true
        });
        $( "#datepicker" ).datepicker( $.datepicker.regional[ "vi" ] );
    });
</script>
<!---  Team --->
<div id="content">
    <div id="register_form" class="register_form">
        <div class="rg_title">Đăng Ký Thành Viên</div>
        <?php
        $form = $this->beginWidget('CActiveForm', array(
            'id' => 'user-form',
                ));
        ?>
        <!--<form action="" >-->
<?php echo $form->errorSummary($model); ?>
        <div class="rg_left">
            <div> 
                <label>Họ:</label>
<?php echo $form->textField($model, 'last_name', array('id' => 'rg_lastname')); ?>
<?php echo $form->error($model, 'last_name'); ?>
            </div>
            <div>
                <label class="rg_lfn">Tên:</label>
<?php echo $form->textField($model, 'first_name', array('id' => 'rg_firstname')); ?>
<?php echo $form->error($model, 'first_name'); ?>
            </div>
            <div>
                <label>Tên đăng nhập:</label>
<?php echo $form->textField($model, 'username', array('id' => 'rg_uname')); ?>
<?php echo $form->error($model, 'username'); ?>
            </div>
            <div>
                <label>Email:</label>
<?php echo $form->textField($model, 'email', array('id' => 'rg_email')); ?>
<?php echo $form->error($model, 'email'); ?>
            </div>
            <div>
                <label>Nhập lại email:</label>
                <input type="text" name="rg_reemail" id="rg_reemail" />
            </div>
            <div> 
                <label>Số điện thoại:</label>
<?php echo $form->textField($model, 'phone_number', array('id' => 'rg_phone')); ?>
<?php echo $form->error($model, 'phone_number'); ?>
            </div>
            <div>
                <label class="rg_lbirth">Ngày sinh:</label>
<?php echo $form->textField($model, 'birthday', array('id' => 'rg_birthday')); ?>
<?php echo $form->error($model, 'birthday'); ?>
            </div>
            <div>
                <label>Giới tính:</label>
                <?php echo $form->radioButton($model, 'gender', array('id' => 'nam', 'value' => 'nam', 'checked' => 'checked')); ?> Nam &nbsp;
<?php echo $form->radioButton($model, 'gender', array('id' => 'nu', 'value' => 'nu')); ?> Nữ
<?php echo $form->error($model, 'birthday'); ?>
            </div>
            <div> 
                <label>Chỗ ở hiện nay:</label>
<?php echo $form->textField($model, 'address', array('id' => 'rg_address')); ?>
<?php echo $form->error($model, 'address'); ?>
            </div>

            <!-- quan huyen -->
<?php echo $form->dropDownList($model, 'district', array('a' => 'Quận/Huyện', 'b' => 'Ba ria vung tau'), array('id' => 'rg_district')); ?>
            <?php echo $form->error($model, 'district'); ?>
            <!-- quan huyen -->
            <!-- Tinh thanh -->
<?php echo $form->dropDownList($model, 'province', array('a' => 'Tỉnh/Thành', 'b' => 'Ba ria vung tau'), array('id' => 'rg_province')); ?>
<?php echo $form->error($model, 'province'); ?>
            <!-- Tinh thanh -->

        </div>
        <div class="rg_right">
            <div class="rg_captcha">
                <div><label>Chứng minh bạn không phải là Rô-bot</label></div>
                <div><img id="rg_captcha_img" src="images2/captcha/captcha.jpg" alt="captcha"/></div>
                <div><span>Nhập chính xác 2 từ như hình...</span></div>
                <div style="display: inline-block;">
                    <input type="text" id="rg_captcha" name="rg_captcha"/>
                </div>
                <div class="rg_captcha_reload_btn">
                    <a id="rg_captcha_reload_btn" href="javascript:Recaptcha.refreshCaptcha()" title="Tạo mã xác nhận khác"> 
                        <span>Tạo mã xác nhận khác - Bạn sẽ ko thấy</span></a>
                </div>
            </div>
            <div class="rg_agree">
                <input id="rg_agree" type="checkbox">
                <label for="rg_agree">
                    Tôi đồng ý với <a href="link toi dieu khoan dich vu" target="_blank"> Điều khoản dịch vụ của website</a></label>
            </div>
            <div class="rg_warn">Có 5 thông tin chưa hoàn tất.
                Vui lòng nhập đầy đủ thông tin yêu cầu</div>
            <div>

<?php echo CHtml::submitButton($model->isNewRecord ? 'Đăng ký' : 'Save', array('class' => 'rg_button')); ?>
            </div>
        </div>
    </div>

<?php $this->endWidget(); ?>
</div><!-- close content -->

