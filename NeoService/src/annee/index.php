<?php
  require_once "../accesseur/NeoDAO.php";

  $neoDAO = new NeoDAO();
  print_r($neoDAO);
  $resumeAnnee = $neoDAO->resumerAnnee(2020);
  print_r($resumeAnnee);
