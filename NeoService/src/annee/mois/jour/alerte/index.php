<?php
  require_once "../../../../accesseur/NeoDAO.php";

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeJour = $neoDAO->resumerJour(2020, 1, 1);
  $distanceCritique = 5;
  $neosCritiques = $neoDAO->listerNeosCritiques(2020, 1, 1, $distanceCritique);
  //print_r($listeNeosCritiques);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <jour>
    <date-jour><?=$resumeJour->jour?></date-jour>
    <distance-critique><?=$distanceCritique?></distance-critique>
    <liste-near-earth-objects>
    <?php
    foreach ($neosCritiques as $neo) {
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
