<div class="postproduct-content">
    <div class="ppr_detailproduct_info">
        <form action="" method="get">
            <textarea cols="80" id="ppr_editor01" name="ppr_editor01" rows="10" >
&lt;p&gt;This is some &lt;strong&gt;sample text&lt;/strong&gt;. 
You are using &lt;a href="http://ckeditor.com/"&gt;CKEditor&lt;/a&gt;.&lt;/p&gt;</textarea>
            <script type="text/javascript">
                //<![CDATA[
                CKEDITOR.replace( 'ppr_editor01',
                {
                    skin : 'v2',
                    language: 'vi',
                    //extraPlugins : 'autogrow',
                    //autoGrow_maxHeight : 800,
                    // Remove the Resize plugin as it does not make sense to use it in conjunction with the AutoGrow plugin.
                    removePlugins : 'resize'
                
                });
                //]]>
            </script>
            <input type="submit" value="lưu"/>
        </form>
    </div>
</div>