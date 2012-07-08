<?php

/**
 * This is the model class for table "user".
 *
 * The followings are the available columns in table 'user':
 * @property integer $id_user
 * @property string $last_name
 * @property string $first_name
 * @property string $username
 * @property string $password
 * @property string $email
 * @property string $phone_number
 * @property string $gender
 * @property string $birthday
 * @property string $address
 * @property string $province
 * @property string $district
 * @property integer $permission
 */
class User extends CActiveRecord
{
	/**
	 * Returns the static model of the specified AR class.
	 * @return User the static model class
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
		return 'user';
	}

	/**
	 * @return array validation rules for model attributes.
	 */
	public function rules()
	{
		// NOTE: you should only define rules for those attributes that
		// will receive user inputs.
		return array(
			array('last_name, first_name, username, password, email, birthday, address', 'required'),
			array('permission', 'numerical', 'integerOnly'=>true),
			array('last_name, first_name, username, password, email, gender, province, district', 'length', 'max'=>100),
			array('phone_number', 'length', 'max'=>10),
			array('username, email','unique'),
			array('email','email'),
			// The following rule is used by search().
			// Please remove those attributes that should not be searched.
			array('id_user, last_name, first_name, username, password, email, phone_number, gender, birthday, address, province, district, permission', 'safe', 'on'=>'search'),
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
			'id_user' => 'Id User',
			'last_name' => 'Last Name',
			'first_name' => 'First Name',
			'username' => 'Username',
			'password' => 'Password',
			'email' => 'Email',
			'phone_number' => 'Phone Number',
			'gender' => 'Gender',
			'birthday' => 'Birthday',
			'address' => 'Address',
			'province' => 'Province',
			'district' => 'District',
			'permission' => 'Permission',
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

		$criteria->compare('id_user',$this->id_user);
		$criteria->compare('last_name',$this->last_name,true);
		$criteria->compare('first_name',$this->first_name,true);
		$criteria->compare('username',$this->username,true);
		$criteria->compare('password',$this->password,true);
		$criteria->compare('email',$this->email,true);
		$criteria->compare('phone_number',$this->phone_number,true);
		$criteria->compare('gender',$this->gender,true);
		$criteria->compare('birthday',$this->birthday,true);
		$criteria->compare('address',$this->address,true);
		$criteria->compare('province',$this->province,true);
		$criteria->compare('district',$this->district,true);
		$criteria->compare('permission',$this->permission);

		return new CActiveDataProvider($this, array(
			'criteria'=>$criteria,
		));
	}
}