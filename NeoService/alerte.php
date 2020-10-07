<?php
  require_once "accesseur/NeoDAO.php";

  /* TRAITEMENT DES PARAMETRES */

  $listeDeFiltres = array(
    'annee'=> FILTER_VALIDATE_INT,
    'mois' => FILTER_VALIDATE_INT,
    'jour' => FILTER_VALIDATE_INT,
    'seuil' => FILTER_VALIDATE_INT
  );
  $parametresFiltres = filter_input_array(INPUT_GET, $listeDeFiltres);

  /* RECUEIL DES DONNEES */

  $neoDAO = new NeoDAO();
  $resumeJour = $neoDAO->resumerJour($parametresFiltres["annee"],
  $parametresFiltres["mois"], $parametresFiltres["jour"]);
  $neosCritiques = $neoDAO->listerNeosCritiques($parametresFiltres["annee"],
  $parametresFiltres["mois"], $parametresFiltres["jour"],
  $parametresFiltres["seuil"]);
  //print_r($listeNeosCritiques);

  /* AFFICHAGE DES DONNEES */

  header("Content-Type:text/xml");
  echo '<?xml version="1.0" encoding="UTF-8"?>';
  ?>

  <jour>
    <date-jour><?=$resumeJour->jour?></date-jour>
    <distance-critique><?=$parametresFiltres["seuil"]?></distance-critique>
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
