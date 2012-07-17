
<div class="manage_header">
    <div class="manage_header_title">Trang Quản Lý</div>
</div>



<link rel="stylesheet" href="jqueryApp/menu-apycom-black/menu.css"/>
<script src="jqueryApp/jqueryLibs/jquery-1.7.2.js"></script>
<script type="text/javascript" src="jqueryApp/menu-apycom-black/menu.js"></script>
<div id="menu">
    <ul class="menu">
        <li><a href="#"><span>Trang chính</span></a></li>
        <li><a href="#" class="parent"><span>Quản lý User</span></a>
            <ul>
                <li><a href="#"><span>Thêm User</span></a></li>
                <li><a href="#"><span>Danh sách User</span></a></li>
            </ul>
        </li>
        <li><a href="#"><span>Quản lý Category</span></a></li>
        <li class="last"><a href="#"><span>Contacts</span></a></li>
    </ul>
    
    <ul class="menu_right">
        <li><a href="#"><span>Trang chủ</span></a></li>
        <li class="last mn_logout"><a href="#"><span>Thoát</span></a></li>
    </ul>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $("body div:last").remove();
    });
</script>