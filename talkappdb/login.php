 <?php   
 require "init.php";
 
 //$email = $_POST["email"];
 $user_name = $_POST["user_name"];  
 $user_pass =  $_POST["user_pass"];
 
 $query = "select * from user_info where user_name like '".$user_name."' and user_pass like '".$user_pass."';"; 
 $result = mysqli_query($con,$query);
 
 if(mysqli_num_rows($result)>0){
	$response = array();
	$code = "login_true";
	$row = mysqli_fetch_array($result);
	$name = $row[0];
	$message = "Login Success. Welcome".$name;
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response" => $response));
 }
 else{
	$response = array();
	$code = "login_false";
	$message = "Login Failed. Try Again.";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode(array("server_response" => $response));
 }
 mysqli_close($con);
 ?>  

