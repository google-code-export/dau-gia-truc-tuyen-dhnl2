<?php

/**
 * This is the model class for table "product".
 *
 * The followings are the available columns in table 'product':
 * @property integer $id_product
 * @property string $name
 * @property string $description
 * @property string $status
 * @property string $paymethod
 * @property string $shipmethod
 * @property integer $start_price
 * @property integer $imediate_price
 * @property integer $buoc_gia
 * @property string $start_date
 * @property string $end_date
 * @property string $created_date
 */
class Product extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @return Product the static model class
	 */
	public static function model($className=__CLASS__)
	{
		return parent::model($className);
	}

	/**
	 * @return string the associated database table name
	 */
	public function tableName()
	{
		return 'product';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('id_product, name, description, status, paymethod, shipmethod, start_price, imediate_price, buoc_gia, start_date, end_date, created_date', 'required'),
			array('id_product, start_price, imediate_price, buoc_gia', 'numerical', 'integerOnly'=>true),
			array('name, status', 'length', 'max'=>100),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id_product, name, description, status, paymethod, shipmethod, start_price, imediate_price, buoc_gia, start_date, end_date, created_date', 'safe', 'on'=>'search'),
		);
	}

	/**
	 * @return array relational rules.
	 */
	public function relations()
	{
		// NOTE: you may need to adjust the relation name and the related
		// class name for the relations automatically generated below.
		return array(
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'id_product' => 'Id Product',
			'name' => 'Name',
			'description' => 'Description',
			'status' => 'Status',
			'paymethod' => 'Paymethod',
			'shipmethod' => 'Shipmethod',
			'start_price' => 'Start Price',
			'imediate_price' => 'Imediate Price',
			'buoc_gia' => 'Buoc Gia',
			'start_date' => 'Start Date',
			'end_date' => 'End Date',
			'created_date' => 'Created Date',
		);
	}

	/**
	 * Retrieves a list of models based on the current search/filter conditions.
	 * @return CActiveDataProvider the data provider that can return the models based on the search/filter conditions.
	 */
	public function search()
	{
		// Warning: Please modify the following code to remove attributes that
		// should not be searched.

		$criteria=new CDbCriteria;

		$criteria->compare('id_product',$this->id_product);
		$criteria->compare('name',$this->name,true);
		$criteria->compare('description',$this->description,true);
		$criteria->compare('status',$this->status,true);
		$criteria->compare('paymethod',$this->paymethod,true);
		$criteria->compare('shipmethod',$this->shipmethod,true);
		$criteria->compare('start_price',$this->start_price);
		$criteria->compare('imediate_price',$this->imediate_price);
		$criteria->compare('buoc_gia',$this->buoc_gia);
		$criteria->compare('start_date',$this->start_date,true);
		$criteria->compare('end_date',$this->end_date,true);
		$criteria->compare('created_date',$this->created_date,true);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}