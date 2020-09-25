<?php

  $base = "neo";
	$hote = "localhost";
	$usager = "postgres";
	$motdepasse = "4101676";
	$dsn = "pgsql:host=$hote;dbname=$base;
	$basededonnees = new PDO($dsn, $usager, $motdepasse);
