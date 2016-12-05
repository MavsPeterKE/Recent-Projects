<?php

//Database connection and selection
mysql_connect("localhost","root","") or die(mysql_error('Server Down: ' . mysql_error()));
mysql_select_db('sis_android_app_studusers') or die(mysql_error('Server Down: ' . mysql_error()));




//retrieve data from the database
$sql = mysql_query("SELECT lecturer_name, news FROM lecs_news");


while($row=mysql_fetch_array($sql))

{
       $field1= $row['lecturer_name'];
       $field2= $row['news'];


	   echo "$field2#$field1";
	   
}	


?>


