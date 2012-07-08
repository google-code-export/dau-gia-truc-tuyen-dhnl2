<?php

class ShowHelloWorldController extends Controller
{
    //public $layout='newlayout';

    public function actionIndex()
    {
        $this->render('index');
    }

    public function actionTestArray()
    {
        $data = new CList();
        $data->add('fuck');
        $data->add('shit');
        $data->add('test');
        $data->add('love');
        $data->add('die');


        $this->widget('CLinkPager', array(
        'pages'=>$pagination,
        'pageSize'=>5,
        'cssFile'=>false,
        ));

        //$song = new Song;
        //        $song->setAttributes(
        //        array('songid' => 8,
        //            'name' => 'Ten bai hat',
        //            'performer' => 'Performer',
        //            'writer' => 'Writer',
        //            'genrename' => 'Genre1',
        //            'rate' => 123,
        //            'size' => 123,
        //            'date' => '1970-12-12',
        //            'resource' => 'Resource',)
        //        );
        //        $song->save(false);
        $song = Song::model()->findByPk(8);
        $this->render('index',array('data'=>$data,'song'=>$song)); 
    }

    public function actionShowViewYii(){

        $model=new Playlist;// Any model for ajax
        $arrayitem = Playlist::model()->findAll();
        if(isset($_POST['ajax']) && $_POST['ajax']==='playlist-form')
        {
            echo CActiveForm::validate($model);
            Yii::app()->end();
        }
        if(isset($_POST['Playlist']))
        {
            $model->attributes=$_POST['Playlist'];
            if($model->save());
            $this->render('viewsubmit',array('model'=>$model));
        }
		if(isset($_POST['value']))
		{
			echo $_POST['value'];
			Yii::app()->end();
		}
		
        $this->performAjaxValidation($model);
        $this->render('showviewyii',array('model'=>$model,'arrayitem'=> $arrayitem,));
    }

    public function actionAjaxChangeAutocomplete(){
        $arryne =array('shit','fack','troll');
        //        echo "\"shit\",\"fack me now\", \"Troll\", \"WTF ??\"";
        echo json_encode($arryne);
    }

    public function actionPage($alias){
        echo "page is $alias";
    }
    // -----------------------------------------------------------
    // Uncomment the following methods and override them if needed
    /*
    public function filters()
    {
    // return the filter configuration for this controller, e.g.:
    return array(
    'inlineFilterName',
    array(
    'class'=>'path.to.FilterClass',
    'propertyName'=>'propertyValue',
    ),
    );
    }

    public function actions()
    {
    // return external action classes, e.g.:
    return array(
    'action1'=>'path.to.ActionClass',
    'action2'=>array(
    'class'=>'path.to.AnotherActionClass',
    'propertyName'=>'propertyValue',
    ),
    );
    }
    */

    protected function performAjaxValidation($model)
    {
        if(isset($_POST['ajax']) && $_POST['ajax']==='song-form')
        {
            echo CActiveForm::validate($model);
            Yii::app()->end();
        }
    }

}