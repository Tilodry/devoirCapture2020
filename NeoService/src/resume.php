<?php
  require_once "accesseur/NeoDAO.php";

  /* TRAITEMENT DES PARAMETRES */

  $listeDeFiltres = array(
    'annee'=> FILTER_VALIDATE_INT,
    'mois' => FILTER_VALIDATE_INT,
    'jour' => FILTER_VALIDATE_INT
  );
  $parametresFiltres = filter_input_array(INPUT_GET, $listeDeFiltres);

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeAnnee = $neoDAO->resumerAnnee($parametresFiltres["annee"]);
  $resumeJour = $neoDAO->resumerJour($parametresFiltres["annee"],
  $parametresFiltres["mois"], $parametresFiltres["jour"]);
  $neos = $neoDAO->listerNeosDuJour($parametresFiltres["annee"],
  $parametresFiltres["mois"], $parametresFiltres["jour"]);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <annee>
    <date-annee><?=$resumeAnnee->annee?></date-annee>
    <distance-moyenne-annee><?=$resumeAnnee->moyenne?></distance-moyenne-annee>
    <jour>
      <date-jour><?=$resumeJour->jour?></date-jour>
      <distance-moyenne-jour><?=$resumeJour->moyenne?></distance-moyenne-jour>
      <liste-near-earth-objects>
      <?php
      foreach ($neos as $neo) {
      ?>
        <near-earth-object>
          <id><?=$neo->id?></id>
          <distance><?=$neo->distance?></distance>
          <date-approche><?=$neo->date?></date-approche>
        </near-earth-object>
      <?php
      }
      ?>
    </liste-near-earth-objects>
    </jour>
  </annee>
