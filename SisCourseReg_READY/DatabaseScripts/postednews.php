<?php

//Database connection and selection
mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_android_app_studusers') or die(mysql_error());


//variables to store data
$target = $_REQUEST['target'];
$year = $_REQUEST['tyear'];
$name = $_REQUEST['lec'];
$news = $_REQUEST['news'];


//checks that all fields are entered
if ( !$name || !$news)
  { 
 echo "3";
 exit();
  }

//checks double username registration
 $dupe1 = mysql_num_rows(mysql_query("SELECT * FROM lecs_news WHERE lecturer_name='$name' AND news='$news'")); 
 
        if ($dupe1 > 0) { 
  
                    echo "2";
                     exit();
                         }


//insert data into the database
$sql = "INSERT INTO lecs_news (newsno,target_audience,target_year,lecturer_name,news)
        VALUES('','$target','$year','$name','$news')";
$result=mysql_query($sql);
if ($result)
 {
    echo "4";
}
else{
    echo "5";
}

?>

