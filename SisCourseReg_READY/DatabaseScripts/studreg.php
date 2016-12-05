<?php

//Database connection and selection
mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_android_app_studusers') or die(mysql_error());


//variables to store data
$regno = $_REQUEST['reg_no'];
$course = $_REQUEST['course'];
$year = $_REQUEST['year'];
$contacts = $_REQUEST['contacts'];
$password = $_REQUEST['pwd'];

//checks that all fields are entered
if ( !$regno || !$contacts || !$password)
  { 
 echo "3";
 exit();
  }

//checks double username registration
 $dupe1 = mysql_num_rows(mysql_query("SELECT * FROM studs_data WHERE reg_no='$regno'")); 
 
        if ($dupe1 > 0) { 
  
                    echo "2";
                     exit();
                         }


//insert data into the database
$sql = "INSERT INTO studs_data (reg_no,course,year,contacts,password)
        VALUES('$regno','$course','$year','$contacts','$password')";
$result=mysql_query($sql);
if ($result)
 {
  echo "4";
}
else{
  echo "5";
}

?>

