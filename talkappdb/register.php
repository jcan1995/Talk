<?php
//Insert information into database in this script
//Here is where we will get inputs from the android application.
//For now we will hardcode some values for testing.
/*
 $db_name = "talkappdb";  
 $mysql_user = "root";  
 $mysql_pass = "Josca942";  
 $server_name = "localhost";  
 $con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name); 
*/
require "init.php";

$name = $_POST["name"];
$user_name = $_POST["user_name"];
$user_pass=$_POST["user_pass"];
$gender = $_POST["gender"];
$age = $_POST["age"];
$email = $_POST["email"];

$query = "select * from user_info where email like '".$email."';";
$result = mysqli_query($con,$query);

	if(mysqli_num_rows($result)>0)
	{
		$response = array();
		$code = "reg_false";
		$message = "User already exists!";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));

}
else{
		$query = "insert into user_info values('".$name."','".$user_name."','".$user_pass."','".$gender."','".$age."','".$email."');";
		$result = mysqli_query($con,$query);
	if(!$result){
		$response = array();
		$code = "reg_false";
		$message = "Server error occurred. Try again.";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
}
	else{
		$response = array();
		$code = "reg_true";
		$message = "Registration success.";
		array_push($response,array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}

}
		mysqli_close($con);

?>