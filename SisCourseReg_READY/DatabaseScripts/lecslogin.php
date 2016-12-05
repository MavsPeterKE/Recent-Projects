<?php

mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_android_app_studusers') or die(mysql_error());

$email = $_REQUEST['email'];
$password = $_REQUEST['password'];

//retrieve data from the database
$sql = "SELECT * FROM lecs_data  WHERE  email = '$email' And password='$password' ";
if (!$email || !$password)
  { 
 echo "3";
 exit();
  }
$result=mysql_query($sql);
$num_rows=mysql_num_rows($result);
//echo $num_rows;

if ($num_rows>0) 
{
	echo "1";
}
else
{
	echo "2";
}

?>

