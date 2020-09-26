<?php
  require_once "../accesseur/NeoDAO.php";

  $neoDAO = new NeoDAO();
  print_r($neoDAO);
  $listeNeos = $neoDAO->listerNeos();
  print_r($listeNeos);
