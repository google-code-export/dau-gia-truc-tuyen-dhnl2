<?php
require_once(dirname(__FILE__) . '/../requirelib/nusoap/nusoap.php');
class TestEmailController extends Controller
{
	public function actionIndex()
	{
	
		$wsdl = "http://localhost:8080/WebServiceProject/services/EmailService?wsdl";
		// $client = new SoapClient($wsdl);
		// $st =  $client->__getFunctions();
		// foreach($st as $item) 
		// echo $item."<br>";
		$client = new nusoap_client($wsdl, true);
		$st = $client->call('send',
							array(
								'from'=>"dang.capchemgio@gmail.com",
								'to'=>"tuanlhdnl@gmail.com",
								'subject'=>"HELLO WORLD",
								'bodytext'=>"XIN CHAO BAN TUAN",
									),
							"http://mypack",'',false,null,'rpc','encoded');
		foreach($st as $item) echo $item;
		//$this->render('index');
	}

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
}