/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config )
{
    // Define changes to default configuration here. For example:
    // config.language = 'fr';
    // config.uiColor = '#AADC6E';
        
    //edit by LVTD
    config.skin='v2';  // có thể đổi thành 1 trong 3 giá trị sau: v2, kama, office2003 
    //Mặc định thì ckeditor sẽ chèn thẻ p vào trước phần văn bản của ta, nếu bạn muốn loại bỏ thẻ p này thì cho dòng code sau vào:
    //config.enterMode = CKEDITOR.ENTER_BR;
    config.filebrowserBrowseUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/ckfinder.html';
    config.filebrowserImageBrowseUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/ckfinder.html?type=Images';
    config.filebrowserFlashBrowseUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/ckfinder.html?type=Flash';
    config.filebrowserUploadUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = 'http://localhost/luanvan/jqueryApp/ckeditor/ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Flas';
    
    
    
    //xóa bớt những nút ko cần thiết
    //'Source','-','Save',
    ////['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
    //['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
    //'/',   -- chú thích là nút tạo tab mới
    
    //,'-','About'   'Blockquote','CreateDiv' ,'Iframe' 'Flash',
    
    config.toolbar_Full =
    [
    ['NewPage','Preview','Maximize', 'ShowBlocks','-','Templates'],
    ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
    ['NumberedList','BulletedList','-','Outdent','Indent','BidiLtr', 'BidiRtl'],
    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
    ['Link','Unlink','Anchor'],
    ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
    '/',
    ['Styles','Format','Font','FontSize'],
    ['TextColor','BGColor'],
    ['Bold','Italic','Underline','Strike','-','Subscript','Superscript']
    ];
};
