<?php

//Database connection and selection
mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_android_app_studusers') or die(mysql_error());


//variables to store data
$lname = $_REQUEST['lname'];
$department = $_REQUEST['department'];
$email = $_REQUEST['email'];
$contacts = $_REQUEST['contacts'];
$password = $_REQUEST['password'];

//checks that all fields are entered
if ( !$lname || !$email || !$contacts || !$password)
  { 
 echo "3";
 exit();
  }

//checks double username registration
 $dupe1 = mysql_num_rows(mysql_query("SELECT * FROM lecs_data WHERE lecturer_name='$lname' OR email='$email' OR contacts='$contacts' ")); 
 
        if ($dupe1 > 0) { 
  
                    echo "2";
                     exit();
                         }


//insert data into the database
$sql = "INSERT INTO lecs_data (lecturer_name,department,email,contacts,password)
        VALUES('$lname','$department','$email','$contacts','$password')";
$result=mysql_query($sql);
if ($result)
 {
    echo "4";
}
else{
    echo "5";
}

?>

