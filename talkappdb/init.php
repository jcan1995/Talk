<?php  
 //Establish a onnection to the database.
 $db_name = "talkappdb";  
 $mysql_user = "root";  
 $mysql_pass = "Josca942";  
 $server_name = "localhost";  
 $con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name); 
 
 if(!$con){
	 die("Error in db connection....".mysqli_connect_error());
 }
 
 else{
	 echo"<h3>Db connection success.";
 }
 ?>  
 