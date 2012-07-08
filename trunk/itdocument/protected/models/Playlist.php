<?php

/**
 * This is the model class for table "playlist".
 *
 * The followings are the available columns in table 'playlist':
 * @property integer $playlistid
 * @property string $username
 * @property string $playlistname
 *
 * The followings are the available model relations:
 * @property User $username0
 * @property Plsong[] $plsongs
 */
class Playlist extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @return Playlist the static model class
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
		return 'playlist';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('username, playlistname', 'length', 'max'=>100),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('playlistid, username, playlistname', 'safe', 'on'=>'search'),
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
			'username0' => array(self::BELONGS_TO, 'User', 'username'),
			'plsongs' => array(self::HAS_MANY, 'Plsong', 'playlistid'),
		);
	}

	/**
	 * @return array customized attribute labels (name=>label)
	 */
	public function attributeLabels()
	{
		return array(
			'playlistid' => 'Playlistid',
			'username' => 'Username',
			'playlistname' => 'Playlistname',
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

		$criteria->compare('playlistid',$this->playlistid);
		$criteria->compare('username',$this->username,true);
		$criteria->compare('playlistname',$this->playlistname,true);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}