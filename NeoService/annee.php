<?php
  require_once "accesseur/NeoDAO.php";

  /* TRAITEMENT DES PARAMETRES */

  if (isset($_GET['annee'])) {
    $annee = filter_var($_GET['annee'], FILTER_VALIDATE_INT);
  }

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  //print_r($neoDAO);
  $resumeAnnee = $neoDAO->resumerAnnee($annee);
  //print_r($resumeAnnee);
  $detailsAnnee = $neoDAO->detaillerAnnee($annee);
  //print_r($detailsAnnee);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <annee>
    <date-annee><?=$annee?></date-annee>
    <distance-minimum-annee><?=$resumeAnnee->minimum?></distance-minimum-annee>
    <distance-moyenne-annee><?=$resumeAnnee->moyenne?></distance-moyenne-annee>
    <distance-maximum-annee><?=$resumeAnnee->maximum?></distance-maximum-annee>
    <liste-mois>
    <?php
    foreach ($detailsAnnee as $mois) {
    ?>
      <mois>
        <date-mois><?=$mois->mois?></date-mois>
        <distance-minimum-mois><?=$mois->minimum?></distance-minimum-mois>
        <distance-moyenne-mois><?=$mois->moyenne?></distance-moyenne-mois>
        <distance-maximum-mois><?=$mois->maximum?></distance-maximum-mois>
      </mois>
    <?php
    }
    ?>
  </liste-mois>
  </annee>
