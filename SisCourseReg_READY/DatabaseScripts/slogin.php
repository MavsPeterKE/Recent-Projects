<?php

mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_android_app_studusers') or die(mysql_error());

$regno = $_REQUEST['username'];
$password = $_REQUEST['pwd'];

//retrieve data from the database
$sql = "SELECT * FROM studs_data WHERE  reg_no = '$regno' And password='$password' ";
//checks for empty fields
if (!$regno || !$password)
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

