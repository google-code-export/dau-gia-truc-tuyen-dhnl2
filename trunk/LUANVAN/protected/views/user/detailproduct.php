<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/detailproduct.css" type="text/css" media="screen" />
<script type="text/javascript" src="jqueryApp/jqueryLibs/jquery-1.7.2.js"></script>
<!--<script src="http://code.jquery.com/jquery-latest.js"></script>-->

<!--        ---- jqzoom_ev-2.3-->
<script src="jqueryApp/jqzoom_ev-2.3/js/jquery.jqzoom-core.js" type="text/javascript"></script>
<link rel="stylesheet" href="jqueryApp/jqzoom_ev-2.3/css/jquery.jqzoom.css" type="text/css"/>
<!--        ---- Carousel-->
<script type="text/javascript" src="jqueryApp/jsor-jcarousel-7bb2e0a/lib/jquery.jcarousel.min.js"></script>
<link rel="stylesheet" type="text/css" href="jqueryApp/jsor-jcarousel-7bb2e0a/skins/lvtdskin/skin.css" />

<script type="text/javascript">
    jQuery(document).ready(function() {
        if ( $('ul#dpr_carousel li').length > 3 ) {
            jQuery('#dpr_carousel').jcarousel();
        }
        else if ( $('ul#dpr_carousel li').length <=1 ) {
            $('#dpr_carousel').hide();
        }
    });
            
    $(document).ready(function() {
        $('.jqzoom').jqzoom({
            zoomType: 'reverse',
            lens:true,
            preloadImages: false,
            alwaysOn:false,
            zoomWidth: 700,
            zoomHeight: 400,
            imageOpacity:0.8
            // ,
            //showEffect: 'fadein',
            //hideEffect: 'fadeout',
            //fadeinSpeed: 'slow',
            //fadeoutSpeed: 'fast'
        });
        //$('.jqzoom').jqzoom();
    });
</script>
<title></title>
<div id="content">
    <div id="info_product">
        <div id="dpr_left" class="dpr_left">
            <div>
                <a href="images/product/l_letuan_001.jpg" class="jqzoom" rel='gal1'  title="Ảnh phóng to" >
                    <img src="images/product/s_letuan_001.jpg"  title="Ảnh nhỏ" id="dpr_s_img"/>
                </a>
            </div>
            <div>
                <span id="dpr_noteviewer">Đưa chuột vào ảnh để xem ảnh phóng to</span>
            </div> 
            <div>
                <ul id="dpr_carousel" class="jcarousel-skin-tango">
                    <li><a class="zoomThumbActive" href='javascript:void(0);' 
                           rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_001.jpg',largeimage: 'images/product/l_letuan_001.jpg'}">
                            <img src='images/product/t_letuan_001.jpg'></a></li>
                    <li><a href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_002.jpg',largeimage: 'images/product/l_letuan_002.jpg'}">
                            <img src='images/product/t_letuan_002.jpg'></a></li>
                    <li><a  href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_003.jpg',largeimage: 'images/product/l_letuan_003.jpg'}">
                            <img src='images/product/t_letuan_003.jpg'></a></li>
                    <li><a  href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_003.jpg',largeimage: 'images/product/l_letuan_003.jpg'}">
                            <img src='images/product/t_letuan_003.jpg'></a></li>
                    <li><a  href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_003.jpg',largeimage: 'images/product/l_letuan_003.jpg'}">
                            <img src='images/product/t_letuan_003.jpg'></a></li>
                    <li><a  href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: 'images/product/s_letuan_003.jpg',largeimage: 'images/product/l_letuan_003.jpg'}">
                            <img src='images/product/t_letuan_003.jpg'></a></li>
                </ul>
            </div>
        </div>
        <div id="dpr_center" class="dpr_center zoom-desc">
            <div id="dpr_titleProduct">tên sản phẩm   ...  ..</div>
            <div class="dpr_maininfo">
                <ul>
                    <li>
                        <label>Tình trạng: </label> mới
                    </li>
                    <li>
                        <label>Giá khởi điểm: </label> 1000 VNĐ
                    </li>
                    <li>
                        <label>Giá mua ngay: </label> không có
                    </li>
                    <li>
                        <label>Bắt đầu lúc: </label> 22:33:05 - 08/07/2012
                    </li>
                    <li>
                        <label>Kết thúc lúc: </label> 22:33:05 - 10/07/2012
                    </li>
                </ul>
            </div>
            <div class="dpr_hotinfo">
                <ul>
                    <li>
                        <label>Giá hiện tại: </label> <span class="dpr_hif">1000</span> <b>VNĐ</b> (bởi <span class="dpr_seller">letuan</span>)
                    </li>
                    <li>
                        <label>Giá khởi điểm: </label> 1000 VNĐ
                    </li>
                    <li>
                        <label>Bước giá: </label> tùy
                    </li>
                    <li>
                        <label>Có: </label> <span class="dpr_hif">32</span> bid đã đặt
                    </li>
                    <li>
                        <label>Còn: </label> <span class="dpr_hif">1</span> giờ <span class="dpr_hif">7</span> phút <span class="dpr_hif">5</span> giây
                    </li>
                </ul>
            </div>
            <div class="dpr_bid">
                <input type="text" id="dpr_tbid" class="dpr_tbid"/>
                <input type="button" value="Đặt bid">
                <label>Đơn vị: 1000VND</label>
            </div>
        </div>


        <div id="dpr_right" class="dpr_right">
            <div class="dpr_sellerinfo">
                <ul>
                    <li>Thông tin người bán</li>
                    <li>letuan</li>
                    <li>100% phản hồi tích cực</li>
                </ul>
                <ul>
                    <li>Email: letuan@yahoo.com</li>
                    <li>Số điện thoại: 0989876543</li>
                    <li>Địa chỉ: 47 đường số 7 tổ 2 khu phố 2 phường Tăng Nhơn Phú B, quận Thủ Đức, tp.Hồ Chí Minh</li>
                </ul>
            </div>
            <div class="dpr_boxchat">
                box chat: để người bán và người mua trò chuyện với nhau
            </div>

        </div>

    </div>

    <div id="detail_info_product">
        <?php
        $this->widget('zii.widgets.jui.CJuiTabs', array(
            'tabs' => array(
                'Mô tả chi tiết' => 'thay bằng trang mô tả chi tiết',
                'Phương thức thanh toán và vận chuyển' => 'thay bằng trang phương thức và vận chuyển của khách hàng',
                'Chi tiết liên lạc' => 'thay bằng trang chi tiết liên lạc'
//                'Mô tả chi tiết' => array('content' => $this->renderPartial('postproduct/step02', null, true), 'id' => 'ppr_tab02'),
//                'Phương thức thanh toán &vận chuyển' => array('content' => $this->renderPartial('postproduct/step03', null, true), 'id' => 'ppr_tab03'),
//                'Chi tiết liên lạc' => array('content' => $this->renderPartial('postproduct/step04', null, true), 'id' => 'ppr_tab04'),
            ),
            'options' => array(
                'collapsible' => true,
                'selected' => 0
            ),
            'htmlOptions' => array(
//                'style' => 'width: 980px;'
            ),
        ));
        ?>
    </div>

</div><!-- close content -->

<script>
    $('.jqzoom img').hover(
    function() {
        //                alert("ngoc");
        $('#dpr_noteviewer').text("aaaaaaaaaaaaaaaa");
    }, 
    function() {
        $('#dpr_noteviewer').text("bbbbbbbbbbbbbbbbb");
    });
   
</script>

