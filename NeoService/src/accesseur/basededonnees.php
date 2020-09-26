<?php

  $base = "neo";
	$hote = "localhost";
	$usager = "postgres";
	$motdepasse = "4101676";
	$dsn = "pgsql:dbname=".$base.";host=".$hote;
	$basededonnees = new PDO($dsn, $usager, $motdepasse);
