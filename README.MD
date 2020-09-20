# Devoir Capture

## URL Service de données

### Application bureau

#### /Neo/annee/2020/

```xml
<2020>
    <distance-minimum-annee>6.8799493306</distance-minimum-annee>
    <distance-moyenne-annee>68.1753672872</distance-moyenne-annee>
    <distance-maximum-annee>190.493614423</distance-maximum-annee>
	<2020-07>
    	<distance-minimum-mois>6.8799493306</distance-minimum-mois>
        <distance-moyenne-mois>64.7755282823</distance-moyenne-mois>
        <distance-maximum-mois>110.9522514450</distance-maximum-mois>
    </2020-07>
    <2020-08>
        <distance-minimum-mois>7.8761493357</distance-minimum-mois>
        <distance-moyenne-mois>69.1755332871</distance-moyenne-mois>
        <distance-maximum-mois>190.493614423</distance-maximum-mois>
    </2020-08>
    <...>
        <distance-minimum-mois>...</distance-minimum-mois>
        <distance-moyenne-mois>...</distance-moyenne-mois>
        <distance-maximum-mois>...</distance-maximum-mois>
    </...>
</2020>
```



#### /Neo/annee/2020/mois/8/

```xml
<2020-08>
    <distance-minimum-mois>7.8761493357</distance-minimum-mois>
    <distance-moyenne-mois>69.1755332871</distance-moyenne-mois>
    <distance-maximum-mois>110.9522514450</distance-maximum-mois>
	<08-01>
    	<distance-minimum-jour>9.9761492857</distance-minimum-jour>
    	<distance-moyenne-jour>59.8755282851</distance-moyenne-jour>
    	<distance-maximum-jour>101.2522503457</distance-maximum-jour>
    </08-01>
    <08-02>
    	<distance-minimum-jour>7.8761493357</distance-minimum-jour>
    	<distance-moyenne-jour>65.7755282823</distance-moyenne-jour>
    	<distance-maximum-jour>110.9522514450</distance-maximum-jour>
    </08-02>
    <...>
    	<distance-minimum-jour>...</distance-minimum-jour>
    	<distance-moyenne-jour>...</distance-moyenne-jour>
    	<distance-maximum-jour>...</distance-maximum-jour>
        <
    </...>
</2020-08>
```



#### /Neo/annee/2020/mois/8/jour/31

```xml
<2020-08-31>
    <distance-minimum-jour>9.9761492857</distance-minimum-jour>
    <distance-moyenne-jour>59.8755282851</distance-moyenne-jour>
    <distance-maximum-jour>101.2522503457</distance-maximum-jour>
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

