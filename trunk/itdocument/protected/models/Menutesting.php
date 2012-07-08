<?php

/**
 * This is the model class for table "menutesting".
 *
 * The followings are the available columns in table 'menutesting':
 * @property integer $menuid
 * @property string $name
 * @property integer $parrentid
 *
 * The followings are the available model relations:
 * @property Menutesting $parrent
 * @property Menutesting[] $menutestings
 */
class Menutesting extends CActiveRecord
{
	var $child = array();
	/**
	 * Returns the static model of the specified AR class.
	 * @return Menutesting the static model class
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
		return 'menutesting';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('name', 'required'),
			array('parrentid', 'numerical', 'integerOnly'=>true),
			array('name', 'length', 'max'=>100),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('menuid, name, parrentid', 'safe', 'on'=>'search'),
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
			'parrent' => array(self::BELONGS_TO, 'Menutesting', 'parrentid'),
			'menutestings' => array(self::HAS_MANY, 'Menutesting', 'parrentid'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'menuid' => 'Menuid',
			'name' => 'Name',
			'parrentid' => 'Parrentid',
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

		$criteria->compare('menuid',$this->menuid);
		$criteria->compare('name',$this->name,true);
		$criteria->compare('parrentid',$this->parrentid);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}