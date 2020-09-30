# Devoir Capture

## URL Service de données

### Application bureau

#### /Neo/annee/2020/

```xml
<annee>
	<date-annee>2020</date-annee>
	<distance-minimum-annee>10.4730648551</distance-minimum-annee>
	<distance-moyenne-annee>59.61035961088</distance-moyenne-annee>
	<distance-maximum-annee>101.2522503457</distance-maximum-annee>
	<liste-mois>
		<mois>
			<date-mois>2020-01</date-mois>
			<distance-minimum-mois>39.9785482853</distance-minimum-mois>
			<distance-moyenne-mois>71.894683299825</distance-moyenne-mois>
			<distance-maximum-mois>101.2522503457</distance-maximum-mois>
		</mois>
		<mois>
			<date-mois>2020-02</date-mois>
			<distance-minimum-mois>10.4730648551</distance-minimum-mois>
			<distance-moyenne-mois>10.4730648551</distance-moyenne-mois>
			<distance-maximum-mois>10.4730648551</distance-maximum-mois>
		</mois>
	</liste-mois>
</annee>
```



#### /Neo/annee/2020/mois/8/

```xml
<mois>
	<date-mois>2020-01</date-mois>
	<distance-minimum-mois>39.9785482853</distance-minimum-mois>
	<distance-moyenne-mois>71.894683299825</distance-moyenne-mois>
	<distance-maximum-mois>101.2522503457</distance-maximum-mois>
	<liste-jours>
		<jour>
			<date-jour>2020-01-01</date-jour>
			<distance-minimum-jour>39.9785482853</distance-minimum-jour>
			<distance-moyenne-jour>70.6153993155</distance-moyenne-jour>
			<distance-maximum-jour>101.2522503457</distance-maximum-jour>
		</jour>
		<jour>
			<date-jour>2020-01-02</date-jour>
			<distance-minimum-jour>68.1753672872</distance-minimum-jour>
			<distance-moyenne-jour>73.17396728415</distance-moyenne-jour>
			<distance-maximum-jour>78.1725672811</distance-maximum-jour>
		</jour>
	</liste-jours>
</mois>
```



#### /Neo/annee/2020/mois/8/jour/31

```xml
<jour>
	<date-jour>2020-01-01</date-jour>
	<distance-minimum-jour>39.9785482853</distance-minimum-jour>
	<distance-moyenne-jour>70.6153993155</distance-moyenne-jour>
	<distance-maximum-jour>101.2522503457</distance-maximum-jour>
	<liste-near-earth-objects>
		<near-earth-object>
			<id>1</id>
			<distance>39.9785482853</distance>
			<date-approche>2020-01-01 09:08:00</date-approche>
		</near-earth-object>
		<near-earth-object>
			<id>2</id>
			<distance>101.2522503457</distance>
			<date-approche>2020-01-01 11:19:00</date-approche>
		</near-earth-object>
	</liste-near-earth-objects>
</jour>
```



### Application mobile

#### /Neo/annee/2020/mois/8/jour/31/resume/

```xml
<2020>
    <distance-moyenne-annee>68.1753672872</distance-moyenne-annee>
    <2020-08-31>
    	<distance-moyenne-jour>59.8755282851</distance-moyenne-jour>
        <near-earth-objects>
            <near-earth-object>
                <id>1</id>
                <date-approche>2020-08-31 14:16</date-approche>
                <distance>39.9785482853</distance>
            </near-earth-object>
            <near-earth-object>
                <id>2</id>
                <date-approche>2020-08-31 15:06</date-approche>
                <distance>101.2522503457</distance>
            </near-earth-object>
            <near-earth-object>
                <id>...</id>
                <date-approche>...</date-approche>
                <distance>...</distance>
            </near-earth-object>
    	</near-earth-objects>
    </2020-08-31>
</2020>
```





#### /Neo/annee/2020/mois/8/jour/31/alerte

```xml
<2020>
	<2020-08-31>
        <distance-critique>5</distance-critique>
    	<near-earth-object>
        	<5>
                <id>2</id>
                <date-approche>2020-08-31 11:45</date-approche>
                <distance>4.2522503457</distance>
        	</5>
        </near-earth-object>
    </2020-08-31>
</2020>
```

