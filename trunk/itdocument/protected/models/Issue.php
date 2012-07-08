<?php

/**
* This is the model class for table "tbl_issue".
*
* The followings are the available columns in table 'tbl_issue':
* @property integer $id
* @property string $content
* @property integer $create_user_id
*
* The followings are the available model relations:
* @property User $createUser
*/
class Issue extends CActiveRecord
{
    /**
    * Returns the static model of the specified AR class.
    * @return Issue the static model class
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
        return 'tbl_issue';
    }

    public function addComment($comment)
    {
        $comment->issue_id=$this->id;
        $comment->create_time=date("F j, Y, g:i a");  
        $comment->create_user_id = 1;
        return $comment->save();
    }
    /**
    * @return array validation rules for model attributes.
    */
    public function rules()
    {
        // NOTE: you should only define rules for those attributes that
        // will receive user inputs.
        return array(
        array('content, create_user_id', 'required'),
        array('create_user_id', 'numerical', 'integerOnly'=>true),
        // The following rule is used by search().
        // Please remove those attributes that should not be searched.
        array('id, content, create_user_id', 'safe', 'on'=>'search'),
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
        'createUser' => array(self::BELONGS_TO, 'User', 'create_user_id'),
        'comments' => array(self::HAS_MANY, 'Comment', 'issue_id'),
        'commentCount' => array(self::STAT, 'Comment', 'issue_id')
        );
    }

    /**
    * @return array customized attribute labels (name=>label)
    */
    public function attributeLabels()
    {
        return array(
        'id' => 'ID',
        'content' => 'Content',
        'create_user_id' => 'Create User',
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

        $criteria->compare('id',$this->id);
        $criteria->compare('content',$this->content,true);
        $criteria->compare('create_user_id',$this->create_user_id);

        return new CActiveDataProvider($this, array(
        'criteria'=>$criteria,
        ));
    }
}