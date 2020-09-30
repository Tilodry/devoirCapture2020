<?php
  require_once "accesseur/NeoDAO.php";

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeAnnee = $neoDAO->resumerAnnee(2020);
  $resumeJour = $neoDAO->resumerJour(2020, 1, 1);
  $neos = $neoDAO->listerNeosDuJour(2020, 1, 1);

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
