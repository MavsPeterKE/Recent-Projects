<?php

//Database connection and selection
//mysql_connect("http://mysql17.000webhost.com","a7200457_andapp","Walenisisi2") or die(mysql_error());
//mysql_select_db('a7200457_Student') or die(mysql_error());

mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('students') or die(mysql_error());

$code= $_REQUEST['code'];

//checks for empty fields
$exist= mysql_query("SELECT * FROM users WHERE code = '$code'");

if ($exist)
  { 
 //retrieve data from the database
$sql = mysql_query("SELECT * FROM users WHERE code = '$code'");


while($row=mysql_fetch_array($sql))

{
       $field1= $row['code'];
       $field2= $row['product_name'];
       $field3= $row['reg_no'];
       $field4= $row['school'];
       $field5= $row['course'];
       $field6= $row['year'];

	   echo "$field1#$field2#$field3#$field4#$field5#$field6";
}
}
else{exit();}



?>

