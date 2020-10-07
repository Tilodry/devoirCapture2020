<?php

  class NeoDAO {

    function resumerAnnee(int $annee) {
      require "basededonnees.php";

      $RESUMER_ANNEE = "SELECT date_part('year', date) as annee,
      min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('year', date) = :annee
      GROUP BY date_part('year', date)";
      $requeteResumerAnnee = $basededonnees->prepare($RESUMER_ANNEE);
      $requeteResumerAnnee->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerAnnee->execute();

      return $requeteResumerAnnee->fetch(PDO::FETCH_OBJ);
    }

    function resumerMois(int $annee, int $mois) {
      require "basededonnees.php";

      $RESUMER_MOIS = "SELECT to_char(date, 'yyyy-mm') as mois,
      min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('month', date) = :mois
      AND date_part('year', date) = :annee
      GROUP BY date_part('month', date), mois";
      $requeteResumerMois = $basededonnees->prepare($RESUMER_MOIS);
      $requeteResumerMois->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteResumerMois->execute();

      return $requeteResumerMois->fetch(PDO::FETCH_OBJ);
    }

    function resumerJour(int $annee, int $mois, int $jour) {
      require "basededonnees.php";

      $RESUMER_MOIS = "SELECT to_char(date, 'yyyy-mm-dd') as jour,
      min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('day', date) = :jour
      AND date_part('month', date) = :mois AND date_part('year', date) = :annee
      GROUP BY date_part('month', date), jour";
      $requeteResumerMois = $basededonnees->prepare($RESUMER_MOIS);
      $requeteResumerMois->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteResumerMois->bindParam(':jour', $jour, PDO::PARAM_INT);
      $requeteResumerMois->execute();

      return $requeteResumerMois->fetch(PDO::FETCH_OBJ);
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

    function detaillerMois(int $annee, int $mois) {
      require "basededonnees.php";

      $DETAILLER_MOIS = "SELECT to_char(date, 'yyyy-mm-dd') as jour,
      min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('month', date) = :mois
      AND date_part('year', date) = :annee
	    GROUP BY date_part('day', date), jour
	    ORDER BY date_part('day', date) ASC";
      $requeteDetaillerMois = $basededonnees->prepare($DETAILLER_MOIS);
      $requeteDetaillerMois->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteDetaillerMois->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteDetaillerMois->execute();

      return $requeteDetaillerMois->fetchAll(PDO::FETCH_OBJ);
    }

    function detaillerAnnee(int $annee) {
      require "basededonnees.php";

      $DETAILLER_ANNEE = "SELECT to_char(date, 'yyyy-mm') as mois,
      min(distance) as minimum, avg(distance) as moyenne,
      max(distance) as maximum FROM neo WHERE date_part('year', date) = :annee
	    GROUP BY date_part('month', date), mois
	    ORDER BY date_part('month', date) ASC";
      $requeteDetaillerAnnee = $basededonnees->prepare($DETAILLER_ANNEE);
      $requeteDetaillerAnnee->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteDetaillerAnnee->execute();

      return $requeteDetaillerAnnee->fetchAll(PDO::FETCH_OBJ);
    }

    function listerNeosCritiques(int $annee, int $mois, int $jour, int $distanceCritique) {
      require "basededonnees.php";

      $LISTER_NEOS_CRITIQUES = "SELECT * FROM neo
      WHERE date_part('day', date) = :jour
      AND date_part('month', date) = :mois
      AND date_part('year', date) = :annee
	    AND distance <= :distanceCritique";
      $requeteGenererAlerte = $basededonnees->prepare($LISTER_NEOS_CRITIQUES);
      $requeteGenererAlerte->bindParam(':annee', $annee, PDO::PARAM_INT);
      $requeteGenererAlerte->bindParam(':mois', $mois, PDO::PARAM_INT);
      $requeteGenererAlerte->bindParam(':jour', $jour, PDO::PARAM_INT);
      $requeteGenererAlerte->bindParam(':distanceCritique', $distanceCritique,
      PDO::PARAM_INT);
      $requeteGenererAlerte->execute();

      return $requeteGenererAlerte->fetchAll(PDO::FETCH_OBJ);
    }

}
