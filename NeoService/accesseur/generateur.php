<?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    require "basededonnees.php";

    $jourparmois = [31,28,31,30,31,30,31,31,30,31,30,31];

    for($mois = 1; $mois <=10; $mois++)
    {
        $numeroMois = 0;
        for($jour = 1; $jour <= $jourparmois[$numeroMois]; $jour++)
        {
            for($heure = 0; $heure < 24; $heure++)
            {
              $nb = rand(0,2);
              if (!$nb==0)
              {
                for ($i=0; $i <= $nb; $i++)
                {
                  $minutes = rand(1,59);
                  $secondes = 0;
                  $date = "2020-$mois-$jour $heure:$minutes:$secondes";
                  $distance = (0.00025499787 + (200.00000000000 - 0.00025499787)) * mt_rand(0, mt_getrandmax()) / mt_getrandmax();
                  //echo $date." ".$distance."\n";

                  $SQL_AJOUTER_NEO = "INSERT INTO neo(distance, date) VALUES('$distance','$date')";
                  echo $SQL_AJOUTER_NEO."\n";
                  $requete = $basededonnees->prepare($SQL_AJOUTER_NEO);
                  $requete->execute();

                }
              }
            }
        }
        $numeroMois++;
    }

?>
