<?php

/**
* This is the model class for table "song".
*
* The followings are the available columns in table 'song':
* @property integer $songid
* @property string $name
* @property string $performer
* @property string $writer
* @property string $genrename
* @property integer $rate
* @property string $size
* @property string $date
* @property string $resource
*/
class Song extends CActiveRecord
{
    /**
    * Returns the static model of the specified AR class.
    * @return Song the static model class
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
        return 'song';
    }

    /**
    * @return array validation rules for model attributes.
    */
    public function rules()
    {
        // NOTE: you should only define rules for those attributes that
        // will receive user inputs.
        return array(
        array('rate', 'numerical', 'integerOnly'=>true),
        array('name, performer, writer, genrename', 'length', 'max'=>10),
        array('size, date, resource', 'safe'),
        // The following rule is used by search().
        // Please remove those attributes that should not be searched.
        array('songid, name, performer, writer, genrename, rate, size, date, resource', 'safe', 'on'=>'search'),
        array('name','required'),
        array('resource','file'),
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
        'songid' => 'Songid',
        'name' => 'Name',
        'performer' => 'Performer',
        'writer' => 'Writer',
        'genrename' => 'Genrename',
        'rate' => 'Rate',
        'size' => 'Size',
        'date' => 'Date',
        'resource' => 'Resource',
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

        $criteria->compare('songid',$this->songid);
        $criteria->compare('name',$this->name,true);
        $criteria->compare('performer',$this->performer,true);
        $criteria->compare('writer',$this->writer,true);
        $criteria->compare('genrename',$this->genrename,true);
        $criteria->compare('rate',$this->rate);
        $criteria->compare('size',$this->size,true);
        $criteria->compare('date',$this->date,true);
        $criteria->compare('resource',$this->resource,true);

        return new CActiveDataProvider($this, array(
        'criteria'=>$criteria,
        ));
    }
}