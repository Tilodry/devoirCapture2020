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

    function resumerMois(int $annee, int $mois) {
      require_once "basededonnees.php";

      $RESUMER_MOIS = "SELECT min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('month', date) = :mois
      AND date_part('year', date) = :annee
      GROUP BY date_part('month', date)";
      $requeteResumerMois = $basededonnees->prepare($RESUMER_MOIS);
      $requeteResumerMois->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteResumerMois->execute();

      return $requeteResumerMois->fetchAll(PDO::FETCH_OBJ);
    }

    function resumerJour(int $annee, int $mois, int $jour) {
      require_once "basededonnees.php";

      $RESUMER_MOIS = "SELECT min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('day', date) = :jour
      AND date_part('month', date) = :mois AND date_part('year', date) = :annee
      GROUP BY date_part('month', date)";
      $requeteResumerMois = $basededonnees->prepare($RESUMER_MOIS);
      $requeteResumerMois->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':jour', $jour, PDO::PARAM_INT);
      $requeteResumerMois->execute();

      return $requeteResumerMois->fetchAll(PDO::FETCH_OBJ);
    }

}
