<?php
  require_once "../../../accesseur/NeoDAO.php";

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeJour = $neoDAO->resumerJour(2020, 1, 1);
  //print_r($resumeJour);
  $neos = $neoDAO->listerNeosDuJour(2020, 1, 1);
  //print_r($neos);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
	echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <jour>
    <date-jour><?=$resumeJour->jour?></date-jour>
    <distance-minimum-jour><?=$resumeJour->minimum?></distance-minimum-jour>
    <distance-moyenne-jour><?=$resumeJour->moyenne?></distance-moyenne-jour>
    <distance-maximum-jour><?=$resumeJour->maximum?></distance-maximum-jour>
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
