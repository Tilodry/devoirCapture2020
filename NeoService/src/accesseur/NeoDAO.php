<?php
  require_once "basededonnees.php";
  
  class NeoDAO {
    function listerNeos() {
      $LISTER_NEOS = "SELECT * FROM neo";
      global $basededonnees;
      $requeteListerNeos = $basededonnees->prepare($LISTER_NEOS);
      $requeteListerNeos->execute();
      return $requeteListerNeos->fetchAll(PDO::FETCH_OBJ);
    }
  }
