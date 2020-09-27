<?php

  class NeoDAO {

    function listerNeos() {
      require_once "basededonnees.php";
      $LISTER_NEOS = "SELECT * FROM neo";
      $requeteListerNeos = $basededonnees->prepare($LISTER_NEOS);
      $requeteListerNeos->execute();
      return $requeteListerNeos->fetchAll(PDO::FETCH_OBJ);
    }

    function resumerAnnee(int $annee) {
      require_once "basededonnees.php";
      $RESUMER_ANNEE = "SELECT min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('year', date) = :annee
      GROUP BY date_part('year', date)";
      $requeteResumerAnnee = $basededonnees->prepare($RESUMER_ANNEE);
      $requeteResumerAnnee->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerAnnee->execute();
      return $requeteResumerAnnee->fetchAll(PDO::FETCH_OBJ);
  }

}
