<?php
  require_once "../../accesseur/NeoDAO.php";

  $neoDAO = new NeoDAO();
  $resumeMois = $neoDAO->resumerMois(2020, 1);
  print_r($resumeMois);
