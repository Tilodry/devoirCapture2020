<?php
  require_once "../../../accesseur/NeoDAO.php";

  $neoDAO = new NeoDAO();
  $resumeJour = $neoDAO->resumerJour(2020, 1, 1);
  print_r($resumeJour);
