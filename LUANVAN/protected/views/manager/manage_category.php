<link rel="stylesheet" href="css/manage.css" type="text/css" media="screen" />
<title>manage category</title>
<?php
//$listdata = CHtml::listData($arrayitem, 'playlistid', 'playlistname');
//echo Chtml::listBox('mnc_level01_lb', '100', $listC01);
?>

<?php $this->renderPartial('header'); ?>

<div id="content_manage">
    <div class="manage_category">
        <div class="mnc_search">
            Tìm category: <input id="mnc_search_tf" type="text">
            <input id="mnc_search_bt" name="mnc_search_bt" value="tìm" type="button"/>
            <span id="mnc_search_result">Kết quả tìm kiếm</span>
        </div>
        <div class="mnc_level01">
            <!--    nhap-->
            <select class="mnc_level01_lb" multiple="multiple">	
                <option value="1">PHP</option>
                <option style="display: block;" value="2">.Net</option>
                <option style="display: block;" value="3">Copy</option>
                <option style="display: block;" value="4">Paste</option>
                <option style="display: block;" value="5">Pea</option>
                <option style="display: block;" value="6">Pamp</option>
                <option style="display: block;" value="7">ladaku</option>
                <option selected="selected" style="display: block;" value="8">Zebra</option>
            </select>
            <!--------------->
            <div class="mnc_level01_buttongroup">
                <!--        nhap-->
                <input type="button" value="Xóa"/>
                <input type="button" value="Sửa"/>
                <input type="button" value="Thêm"/>
                <input type="button" value="khóa - nếu cần"/>
                <!----------------->
            </div>

        </div>
        <div class="mnc_level02">
            <select class="mnc_level02_lb" multiple="multiple" >	
                <option value="1">PHP</option>
                <option style="display: block;" value="2">.Net</option>
                <option style="display: block;" value="3">Copy</option>
                <option style="display: block;" value="4">Paste</option>
                <option style="display: block;" value="5">Pea</option>
                <option style="display: block;" value="6">Pamp</option>
                <option style="display: block;" value="7">ladaku</option>
                <option selected="selected" style="display: block;" value="8">Zebra</option>
            </select>
            <div class="mnc_level02_buttongroup">
                <!--        nhap-->
                <input type="button" value="Xóa"/>
                <input type="button" value="Sửa"/>
                <input type="button" value="Thêm"/>
                <!----------------->
            </div>
        </div>
        <div class="mnc_level03">
            <select   class="mnc_level03_lb" multiple="multiple" >	
                <option value="1">PHP</option>
                <option style="display: block;" value="2">.Net</option>
                <option style="display: block;" value="3">Copy</option>
                <option style="display: block;" value="4">Paste</option>
                <option style="display: block;" value="5">Pea</option>
                <option style="display: block;" value="6">Pamp</option>
                <option style="display: block;" value="7">ladaku</option>
                <option selected="selected" style="display: block;" value="8">Zebra</option>
            </select>
            <div class="mnc_level03_buttongroup">
                <!--        nhap-->
                <input type="button" value="Xóa"/>
                <input type="button" value="Sửa"/>
                <input type="button" value="Thêm"/>
                <!----------------->
            </div>
        </div>
    </div>
</div>


<?php $this->renderPartial('footer'); ?>