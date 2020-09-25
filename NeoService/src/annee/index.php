<?php
  include "accesseur/NeoDAO.php";

  $SQL_LISTE_NEOS = "SELECT * FROM neo";
  $requete = $basededonnees->prepare($SQL_LISTE_NEOS);
  $requete->execute();
  $neos = $requete->fetchAll();
  print_r($neos);

  //header ("Content-Type:text/xml");
  //echo '<?xml version="1.0" encoding="UTF-8"?>';
