<?php
  require_once "../../accesseur/NeoDAO.php";

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeMois = $neoDAO->resumerMois(2020, 1);
  //print_r($resumeMois);
  $detailsMois = $neoDAO->detaillerMois(2020, 1);
  //print_r($detailsMois);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <mois>
    <date-mois><?=$resumeMois->mois?></date-mois>
    <distance-minimum-mois><?=$resumeMois->minimum?></distance-minimum-mois>
    <distance-moyenne-mois><?=$resumeMois->moyenne?></distance-moyenne-mois>
    <distance-maximum-mois><?=$resumeMois->maximum?></distance-maximum-mois>
    <liste-jours>
    <?php
    foreach ($detailsMois as $jour) {
    ?>
      <jour>
        <date-jour><?=$jour->jour?></date-jour>
        <distance-minimum-jour><?=$jour->minimum?></distance-minimum-jour>
        <distance-moyenne-jour><?=$jour->moyenne?></distance-moyenne-jour>
        <distance-maximum-jour><?=$jour->maximum?></distance-maximum-jour>
      </jour>
    <?php
    }
    ?>
  </liste-jours>
  </mois>
