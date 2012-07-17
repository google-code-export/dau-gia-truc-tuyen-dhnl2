<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
<!--                <link rel="stylesheet" href="css/menu.css" type="text/css" media="screen" />-->
<link rel="stylesheet" href="css/postproduct.css" type="text/css" media="screen" />
<!--  Step01: datepicker-->
<link rel="stylesheet" href="jqueryApp/datepicker/themes/ui-lightness/jquery.ui.all.css"/>
<link rel="stylesheet" href="jqueryApp/datepicker/themes/ui-lightness/jquery-ui-1.8.16.custom.css"/>
<link rel="stylesheet" href="jqueryApp/datepicker/timepicker/jquery-ui-timepicker-addon.css"/>

<!--<script src="jqueryApp/jqueryLibs/jquery-1.7.2.js"></script>-->
<script type="text/javascript" src="jqueryApp/jqueryLibs/jquery-ui-1.8.21.custom.js"></script>
<script type="text/javascript" src="jqueryApp/datepicker/jquery.ui.datepicker-vi.js"></script>
<script type="text/javascript" src="jqueryApp/datepicker/timepicker/jquery-ui-timepicker-addon.js"></script>
<script>
    $(function() { 
        $('#ppr_starttime').datetimepicker();
        $("#ppr_starttime").datepicker( $.datepicker.regional[ "vi" ] );
        $('#ppr_endtime').datetimepicker();
        $("#ppr_endtime").datepicker( $.datepicker.regional[ "vi" ] );
    });
</script>
<!--  Step02: ckeditor -->
<script type="text/javascript" src="jqueryApp/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="jqueryApp/ckeditor/lang/_languages.js"></script>

<title></title>
<div id="content">
    <div id="postproduct">
        <?php
        $this->widget('zii.widgets.jui.CJuiTabs', array(
            'tabs' => array(
                'Thông tin cơ bản' => array('content' => $this->renderPartial('postproduct/step01', null, true), 'id' => 'ppr_tab01'),
                'Mô tả chi tiết' => array('content' => $this->renderPartial('postproduct/step02', null, true), 'id' => 'ppr_tab02'),
                'Phương thức thanh toán &vận chuyển' => array('content' => $this->renderPartial('postproduct/step03', null, true), 'id' => 'ppr_tab03'),
                'Chi tiết liên lạc' => array('content' => $this->renderPartial('postproduct/step04', null, true), 'id' => 'ppr_tab04')
            ),
            'options' => array(
//                'collapsible' => true,
                'selected' => 0
            ),
            'htmlOptions' => array(
//                'style' => 'width: 980px;'
            ),
        ));
        ?>
        <div class="ppr_finishbutton">
            <input type="submit" value="Hoàn tất"/>
        </div>
    </div>

</div><!-- close content -->

