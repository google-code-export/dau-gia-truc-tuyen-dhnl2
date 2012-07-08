<?php
$this->breadcrumbs=array(
	'Menutestings'=>array('index'),
	$model->name,
);

$this->menu=array(
	array('label'=>'List Menutesting', 'url'=>array('index')),
	array('label'=>'Create Menutesting', 'url'=>array('create')),
	array('label'=>'Update Menutesting', 'url'=>array('update', 'id'=>$model->menuid)),
	array('label'=>'Delete Menutesting', 'url'=>'#', 'linkOptions'=>array('submit'=>array('delete','id'=>$model->menuid),'confirm'=>'Are you sure you want to delete this item?')),
	array('label'=>'Manage Menutesting', 'url'=>array('admin')),
);
?>

<h1>View Menutesting #<?php echo $model->menuid; ?></h1>

<?php $this->widget('zii.widgets.CDetailView', array(
	'data'=>$model,
	'attributes'=>array(
		'menuid',
		'name',
		'parrentid',
	),
)); ?>
<?php 
		//Start : Make a tree menu
		$listmenu=	Menutesting::model()->findall();
			foreach ( $listmenu as $item ) 
			{
				$parrentmenu =	findmenu($item->parrentid,$listmenu);
				if($parrentmenu!=null)$parrentmenu->child[] = $item;
			}

		function findmenu($parrentid,$listmenu)
		{
			foreach ( $listmenu as $item ) if($item->menuid==$parrentid) return $item;
			return null;
		}
		$listroot = array();// The roots of menu
		foreach ( $listmenu as $item ) if($item->parrentid==null)$listroot[]= $item;
		//Finish Make a Tree menu;
		
		//add tree menu to view
		echo "<ul>";
		foreach ($listroot as $item) printTree($item);
		echo "</ul>";
		 
		function printTree($node)
		{
			echo "<li>";
			echo $node->name;
			if(count($node->child)>0)
			{
				echo "<ul>";
				foreach($node->child as $item)
				{
					printTree($item);
				}
				echo "</ul>";
			}
			echo "</li>";
		}
		
 ?>
 </br>
  </br>
   </br>
    </br>
<menu>
<ul>
	<li>html</li>
	<li>xhtml
		<ul></ul>
	</li>
	<li>css</li>
</ul>
  <li>html</li>
  <li>xhtml</li>
  <li>css</li>
</menu>
