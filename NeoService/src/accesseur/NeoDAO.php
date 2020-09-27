<?php

  class NeoDAO {

    function resumerAnnee(int $annee) {
      require "basededonnees.php";

      $RESUMER_ANNEE = "SELECT min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('year', date) = :annee
      GROUP BY date_part('year', date)";
      $requeteResumerAnnee = $basededonnees->prepare($RESUMER_ANNEE);
      $requeteResumerAnnee->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerAnnee->execute();

      return $requeteResumerAnnee->fetchAll(PDO::FETCH_OBJ);
    }

    function resumerMois(int $annee, int $mois) {
      require "basededonnees.php";

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
      require "basededonnees.php";

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

    function listerNeosDuJour(int $annee, int $mois, int $jour) {
      require "basededonnees.php";

      $LISTER_NEOS_DU_JOUR = "SELECT * FROM neo WHERE date_part('day', date) = :jour
      AND date_part('month', date) = :mois AND date_part('year', date) = :annee";
      $requeteListerNeosDuJour = $basededonnees->prepare($LISTER_NEOS_DU_JOUR);
      $requeteListerNeosDuJour->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteListerNeosDuJour->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteListerNeosDuJour->bindParam(':jour', $jour, PDO::PARAM_INT);
      $requeteListerNeosDuJour->execute();

      return $requeteListerNeosDuJour->fetchAll(PDO::FETCH_OBJ);
    }

}
