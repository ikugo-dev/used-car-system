<?php
/* $url = "http://payara-web:8080/cars-project/index.xhtml"; */
$url = "http://web:8080/cars-project/index.xhtml";
$response = file_get_contents($url);
echo "Response from server:\n";
echo $response;
?>
