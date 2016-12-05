<?php

mysql_connect("localhost","root","") or die(mysql_error());
mysql_select_db('sis_lecsaunthication') or die(mysql_error());

$secret_word = $_REQUEST['sw'];
$code = $_REQUEST['code'];

//retrieve data from the database
$sql = "SELECT * FROM lecauthentication WHERE secret_word = '$secret_word' And code='$code' ";
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

