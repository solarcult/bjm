# bjm

2022 Feb 18 

今天刚从蛇口港回来,发现1月的方案太保守了.要更新一下,首先先把目标定一下: 提高胜率. 多赚钱是次要的. 在胜率不降低的情况下,多赚钱.

接下来,我把关键的细节记录一下,方便后续review. 数据如下:

16 vs 7 :
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:26.193567586820908->26.60005852819367  	$d:0.0->5.714046380375154  	$l:73.8064324131791->67.68589509143116
improve value x$w(high is good):0.40649094137276265  	x$d:5.714046380375154  	 x$l(negative is good):-6.120537321747932
$w-$l: -47.612864826358184 -> -41.0858365632375  _  _ 	 lift : 6.527028263120682 : good	 :) hit

16对7要一张,胜率提高了0.4%,失败率降低了6.12%,平局增加了5.71%,整体提升了6.527%,所以请咬牙要.

H

---

16 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:24.369289795036515->24.31551805109735  	$d:0.0->5.8552807900616894  	$l:75.63071020496348->69.82920115884096
improve value x$w(high is good):-0.05377174393916562  	x$d:5.8552807900616894  	 x$l(negative is good):-5.8015090461225185
$w-$l: -51.26142040992696 -> -45.51368310774361  _ #Surrender#	 lift : 5.747737302183353 : good	 :) hit

如果不要牌,(庄家的胜率-我们的胜率)达到了51.2614%,超过了50%,就意味着我们投降是划算的.优先投降. [不对,这样对胜率不利,不应该投降,应该要牌]

16对8,要一张后,胜率和败率都下降了,其实都转化到了平率上. 自己的败率下降的更快,也就是说庄家的胜率下降的更大,值了.


H

---

16 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:22.92418933219526->21.70506674433606  	$d:0.0->5.967159535571979  	$l:77.07581066780475->72.32777372009195
improve value x$w(high is good):-1.2191225878592  	x$d:5.967159535571979  	 x$l(negative is good):-4.748036947712791
$w-$l: -54.15162133560949 -> -50.62270697575588  _ #Surrender#	 lift : 3.5289143598536077 : good	 :) hit

不要牌就投降.
要牌我们的胜率下降1.2点,庄家胜率下降4.748,值得换.换来的还是去了平率.但就算要牌,(庄家的胜率-我们的胜率) 还是达到了50%,对我们非常不利.

G/H

---

16 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=16	[isDouble()=false, isHit()=false, isSurrender()=true]
org->adv	$w:21.24709353187227->18.649703938729186  	$d:0.0->6.096999210435696  	$l:78.75290646812773->75.25329685083511
improve value x$w(high is good):-2.5973895931430846  	x$d:6.096999210435696  	 x$l(negative is good):-3.49960961729262
$w-$l: -57.50581293625546 -> -56.603592912105924  _ #Surrender#	 lift : 0.902220024149536 : good	 :| stand

优先投降.
要牌转化率也不好,一般来说偷鸡就好了.所以建议不能投降的话也不要要牌.

G/S

---

16 vs A
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=One1, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:11.5472965879632->14.57027312064755  	$d:0.0->6.847951231899621  	$l:88.4527034120368->78.58177564745283
improve value x$w(high is good):3.0229765326843516  	x$d:6.847951231899621  	 x$l(negative is good):-9.870927764583968
$w-$l: -76.90540682407361 -> -64.01150252680527  _ #Surrender#	 lift : 12.893904297268332 : good	 :) hit

看数据就是再要一张,败率都转化到胜率和平率上了.挺好. 如果在最后位,此时要不要都不会改变什么,因为来个6你爆了,庄家也会成17点.

H

---
16 总结:

9,T优先投降

投降不了的话:7,8,9,A都要牌, T不要牌偷鸡. :D

---

15 vs 7
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:26.193567586820908->28.354559680702216  	$d:0.0->5.6886652267373075  	$l:73.8064324131791->65.95677509256048
improve value x$w(high is good):2.1609920938813083  	x$d:5.6886652267373075  	 x$l(negative is good):-7.849657320618618
$w-$l: -47.612864826358184 -> -37.60221541185825  _  _ 	 lift : 10.010649414499929 : good	 :) hit

看数据,要就完事了.

H

---


15 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:24.369289795036515->25.924330495953175  	$d:0.0->5.832952119279137  	$l:75.63071020496348->68.24271738476769
improve value x$w(high is good):1.5550407009166598  	x$d:5.832952119279137  	 x$l(negative is good):-7.387992820195791
$w-$l: -51.26142040992696 -> -42.318386888814516  _  _ 	 lift : 8.943033521112442 : good	 :) hit

6张牌不会爆,要就完事了,提升了8.94%.

H

---

15 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:22.92418933219526->23.215728359977987  	$d:0.0->5.928331021767451  	$l:77.07581066780475->70.85594061825455
improve value x$w(high is good):0.29153902778272567  	x$d:5.928331021767451  	 x$l(negative is good):-6.219870049550195
$w-$l: -54.15162133560949 -> -47.64021225827657  _ #Surrender#	 lift : 6.511409077332919 : good	 :) hit


要了还是有47.64%的劣势,索性优先投降,投不了就要一张. [不对,这样对胜率不利,不应该投降,应该要牌]


H

---

15 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:21.24709353187227->20.117866564903235  	$d:0.0->5.987317307555999  	$l:78.75290646812773->73.89481612754078
improve value x$w(high is good):-1.1292269669690356  	x$d:5.987317307555999  	 x$l(negative is good):-4.858090340586955
$w-$l: -57.50581293625546 -> -53.77694956263754  _ #Surrender#	 lift : 3.728863373617919 : good	 :) hit

要牌还是有53%的劣势,优先投降.降不了就要.

G/H

----

15总结:

T投降，其他要牌.

----

14 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=14	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:22.92418933219526->25.14186001251494  	$d:0.0->5.929305188360633  	$l:77.07581066780475->68.92883479912444
improve value x$w(high is good):2.217670680319678  	x$d:5.929305188360633  	 x$l(negative is good):-8.1469758686803
$w-$l: -54.15162133560949 -> -43.7869747866095  _  _ 	 lift : 10.364646548999989 : good	 :) hit

对9要一张可以,数据不支持投降.

H

---

14 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=14	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:21.24709353187227->21.83493618095885  	$d:0.0->6.060977031065685  	$l:78.75290646812773->72.10408678797546
improve value x$w(high is good):0.5878426490865785  	x$d:6.060977031065685  	 x$l(negative is good):-6.648819680152272
$w-$l: -57.50581293625546 -> -50.26915060701662  _ #Surrender#	 lift : 7.2366623292388415 : good	 :) hit

对10要牌还是差50.269%,弃牌最优.


G/H

----

14总结:

T投降，其他要牌.


---

13 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=13	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:21.24709353187227->23.515973747641862  	$d:0.0->6.096999210435696  	$l:78.75290646812773->70.38702704192245
improve value x$w(high is good):2.2688802157695918  	x$d:6.096999210435696  	 x$l(negative is good):-8.365879426205282
$w-$l: -57.50581293625546 -> -46.871053294280586  _ #Surrender#	 lift : 10.634759641974878 : good	 :) hit

对10,要一张后数据不支持投降.

----

13总结:

有8张牌可以帮助,对战7,8,9,T 都不投降.


---

如果在最后一位, 13vs89TA,14vs9TA,15vsTA,开始,要不要都改变不了结局,改变的只是前面的人的命运.

---

13 vs 2
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Two2, 	playerStartValue=13	[isDouble()=false, isHit()=false, isSurrender()=false]
org->adv	$w:35.350370555696244->32.19987094688945  	$d:0.0->5.0051326021396445  	$l:64.64962944430376->62.794996450970906
improve value x$w(high is good):-3.150499608806797  	x$d:5.0051326021396445  	 x$l(negative is good):-1.8546329933328494
$w-$l: -29.299258888607515 -> -30.595125504081462  _  _ 	 lift : -1.295866615473945 : bad	 :| stand

要一张,自己损失的胜率比敌人要大2倍,所以停止.

S

---

12 vs 2
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Two2, 	playerStartValue=12	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:35.350370555696244->34.65229083815197  	$d:0.0->4.966934947447152  	$l:64.64962944430376->60.38077421440088
improve value x$w(high is good):-0.6980797175442746  	x$d:4.966934947447152  	 x$l(negative is good):-4.268855229902876
$w-$l: -29.299258888607515 -> -25.72848337624891  _  _ 	 lift : 3.570775512358604 : good	 :) hit

要一张,敌人损失的胜率是自己的6倍,都转移到平率去了,值得要一张.

H

---

12 vs 3
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Three3, 	playerStartValue=12	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:37.419409717495085->35.73171382373884  	$d:0.0->4.80787540749085  	$l:62.5805902825049->59.46041076877031
improve value x$w(high is good):-1.687695893756242  	x$d:4.80787540749085  	 x$l(negative is good):-3.120179513734591
$w-$l: -25.16118056500981 -> -23.72869694503147  _  _ 	 lift : 1.432483619978342 : good	 :) hit

很难抉择的一种场景,相比自己,敌人只损失了1.5倍左右的胜率,这时最好看表,奇数要牌,偶数不要牌.


?

---

11 vs 2
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Two2, 	playerStartValue=11	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:35.350370555696244->57.989968118991854  	$d:0.0->7.712012570081357  	$l:64.64962944430376->34.29801931092678
improve value x$w(high is good):22.63959756329561  	x$d:7.712012570081357  	 x$l(negative is good):-30.351610133376973
$w-$l: -29.299258888607515 -> 23.691948808065067  _ !Double!	 lift : 52.99120769667258 : good	 :) hit

看数据超过敌人23%的胜率,double.

double:
w:58.03501857069991  $d:7.710313288291107  $l:34.25466814100897 346957 : now Money: 475.607008593819

hit:
w:57.99053075460757  $d:8.09219530619508  $l:33.917273939197344 667225 : now Money: 240.7325681541022

D

---

11 vs 7

hit
w:59.73569251953793  $d:9.83084026572613  $l:30.433467214735938 739585 : now Money: 293.02225304801976

double
w:58.08188882005674  $d:7.309377932766352  $l:34.608733247176914 24973 : now Money: 469.46311145759626

多花一倍的钱,效率在60%

D

---

11 vs 8

double:
w:55.20387651665247  $d:7.427187474830083  $l:37.368936008517444 14989 : now Money: 356.69881016270085

hit:
w:56.5490368696232  $d:10.009720813174212  $l:33.44124231720257 443905 : now Money: 231.07794552420637


一倍的钱,带来了54%的效率

D

---

11 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=11	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:22.92418933219526->52.20412380480073  	$d:0.0->7.34322669473891  	$l:77.07581066780475->40.45264950046036
improve value x$w(high is good):29.27993447260547  	x$d:7.34322669473891  	 x$l(negative is good):-36.623161167344385
$w-$l: -54.15162133560949 -> 11.751474304340364  _ !Double!	 lift : 65.90309563994985 : good	 :) hit

胜率超过10%,double不眨眼.

double
w:52.24293343537405  $d:7.342271411376943  $l:40.41479515324901 9997 : now Money: 236.56276564250066 9997 : earn Money: 236.56276564250066 ,playtimes 26.0 ,effect: 9.098567909326949


hit:
w:52.99561229328905  $d:9.968779125045467  $l:37.035608581665485 296065 : now Money: 159.60003711623543 296065 : earn Money: 159.60003711623543 ,playtimes 385.0 ,effect: 0.41454555095126083

double 多花了一倍的钱,收益只多了48.5%,好像不划算啊.

D

---

11 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=11	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:21.24709353187227->47.32600560001775  	$d:0.0->8.661983872532373  	$l:78.75290646812773->44.01201052744988
improve value x$w(high is good):26.07891206814548  	x$d:8.661983872532373  	 x$l(negative is good):-34.74089594067785
$w-$l: -57.50581293625546 -> 3.313995072567871  _  _ 	 lift : 60.81980800882334 : good	 :) hit

再要一张的优势只剩3.31%,只能要一张,不能double了.

H

----

11总结:
11 vs 2~9 数据上来看可以double.

---

10 vs 2
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Two2, 	playerStartValue=10	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:35.350370555696244->55.10952954115352  	$d:0.0->7.842220010060117  	$l:64.64962944430376->37.048250448786355
improve value x$w(high is good):19.759158985457276  	x$d:7.842220010060117  	 x$l(negative is good):-27.6013789955174
$w-$l: -29.299258888607515 -> 18.061279092367172  _ !Double!	 lift : 47.36053798097469 : good	 :) hit

看数据优势有18%,超过阈值10%,可以double.


double
w:55.154579992861606  $d:7.885571179977968  $l:36.95984882716042 346957 : now Money: 363.8946233140237

hit
w:55.11009217676924  $d:8.270952262092283  $l:36.61895556113847 667225 : now Money: 184.91136615630796

多一倍钱,多赚96.8%,值.

D

---

10 vs 6

double
w:61.10339389825439  $d:6.826925135263911  $l:32.06968096648169 40417 : now Money: 580.6742586354543

hit
w:61.10339389825439  $d:6.826925135263911  $l:32.06968096648169 40417 : now Money: 290.33712931772715

花费一倍的钱,得到一倍的收益.值.

D

---

10 vs 7

hit:
w:57.924057517641046  $d:10.04933800182038  $l:32.02660448053856 739585 : now Money: 258.97453037102485

double:
w:56.254445758131766  $d:7.541489442300127  $l:36.2040647995681 24973 : now Money: 401.0076191712729

花费一倍的钱,收益多了54%,有点不划算.

后面又算了一下effect,的确投入不算好的回报,但跟其他牌与dealer比,已经算是少有不多的好回报了,所以double吧

D

----

10 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=10	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:24.369289795036515->53.55461867445699  	$d:0.0->7.346830598062096  	$l:75.63071020496348->39.09855072748092
improve value x$w(high is good):29.185328879420474  	x$d:7.346830598062096  	 x$l(negative is good):-36.53215947748256
$w-$l: -51.26142040992696 -> 14.45606794697607  _ !Double!	 lift : 65.71748835690303 : good	 :) hit

看数据优势有14.5%,超过阈值10%,可以double.

hit:
w:54.9788315289958  $d:9.93352094927619  $l:35.08764752172801 443905 : earn Money: 198.91184007267776 ,effect: 0.5166541300589033

double:
w:53.59621222030865  $d:7.462945086405506  $l:38.94084269328584 14989 : now Money: 293.1073905404568 ,effect: 11.120052266904676


double 多花了一倍的钱,收益只多了47%,好像不划算啊.

D

---

10 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=10	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:22.92418933219526->49.408470810874675  	$d:0.0->8.724958182286697  	$l:77.07581066780475->41.86657100683864
improve value x$w(high is good):26.484281478679414  	x$d:8.724958182286697  	 x$l(negative is good):-35.209239660966105
$w-$l: -54.15162133560949 -> 7.541899804036034  _  _ 	 lift : 61.693521139645526 : good	 :) hit

优势只有7.54%,低于阈值10%,只hit不double.

H

---

10总结:
10 vs 2~8 在数据上都支持double.

---

9 vs 3

hit
w:51.38361937154563  $d:7.443925328741931  $l:41.17245529971245
388825 : earn Money: 102.1116407183317 ,playtimes 25.0 ,effect: 4.084465628733268

double
w:49.68027154993403  $d:6.863659621410223  $l:43.456068828655745
202189 : earn Money: 124.4840544255656 ,playtimes 26.0 ,effect: 4.787848247137139

effect money效率没有提升,胜率也不支持,不值得double

H

---

9 vs 4 

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Four4, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:39.58049180346554->51.386273610369706  	$d:0.0->6.628212972206414  	$l:60.41950819653445->41.98551341742389
improve value x$w(high is good):11.805781806904164  	x$d:6.628212972206414  	 x$l(negative is good):-18.433994779110563
$w-$l: -20.839016393068917 -> 9.400760192945818  _ !Double!	 lift : 30.239776586014735 : good	 :) hit

这里我想double,但小于10%的阈值,所以只hit
有次遇到了我9double后出现了一张2,当场停止傻眼,看着被庄家干掉,心里有了阴影.

hit时的胜率是: w:53.02809290263602  $d:7.190053236747816  $l:39.781853860616174 | 比较组合有226825 : earn Money: 132.4623904201982 ,effect: 5.298495616807928
double后的胜率是:   w:51.38627361036967  $d:6.628212972206417  $l:41.98551341742391  | 比较组合有117949种,收益 188.01520385891519,effect: 7.231353994573661
绝对胜率差距有3%,成本提高一倍,收益提高44.6%,不划算呐.


H

---

9 vs 5
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Five5, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:41.84059422952501->53.15018188882523  	$d:0.0->6.3977420616042835  	$l:58.15940577047499->40.45207604957048
improve value x$w(high is good):11.30958765930022  	x$d:6.3977420616042835  	 x$l(negative is good):-17.70732972090451
$w-$l: -16.318811540949984 -> 12.698105839254753  _ !Double!	 lift : 29.016917380204738 : good	 :) hit

数据支持double,

D

---


9 vs 6
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Six6, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:42.28416043620767->54.916220757349045  	$d:0.0->6.187173140905379  	$l:57.71583956379233->38.896606101745576
improve value x$w(high is good):12.632060321141374  	x$d:6.187173140905379  	 x$l(negative is good):-18.819233462046753
$w-$l: -15.431679127584651 -> 16.019614655603466  _ !Double!	 lift : 31.451293783188117 : good	 :) hit

数据支持double

D

---

9 vs 7
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=9	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:26.193567586820908->49.29032247171355  	$d:0.0->6.9641232864182046  	$l:73.8064324131791->43.74555424186825
improve value x$w(high is good):23.096754884892643  	x$d:6.9641232864182046  	 x$l(negative is good):-30.060878171310847
$w-$l: -47.612864826358184 -> 5.544768229845304  _  _ 	 lift : 53.157633056203494 : good	 :) hit

优势没有超过10%,只hit

H

---

9总结:
只对5和6进行double.

---


以上这些基本操作会对后面的分牌造成决定性的影响,所以要把上面的结论确定下来.
数据通过TestOne计算出来和 Jan16Test2022改double / hit方案测试出来.

9 vs 56 double
10 vs 2~8 double
11 vs 2~9 double


-----


2022-Feb-25

22 vs 4

hit
w:46.02320173766002  $d:3.2869636734822407  $l:50.68983458885774
2839849 : earn Money: -46.666328511977234 ,playtimes 313.0 ,effect: -0.14909370131622118

when 9 vs 4 double
w:47.027888052978994  $d:3.8064375728941195  $l:49.165674374126894
14162953 : earn Money: 2060.819856834654 ,playtimes 5230.0 ,effect: 0.3940382135439109

when 9 vs 4 hit
w:47.14645590803534  $d:3.847104967100822  $l:49.00643912486383
14380705 : earn Money: 1693.9250692505948 ,playtimes 5224.0 ,effect: 0.32425824449666824

胜率没有大幅提高,决定对22vs4不split,9vs4不double

如此的话,33vs4也不用计算了.

H


---

22 vs 6

w:50.0677240242995  $d:3.6567722724947314  $l:46.275503703205786
Money Total: 8787.620523782785

S

----


77 vs 5

split
w:46.77229359790462  $d:6.511159914441072  $l:46.71654648765431
530881 : earn Money: 4105.7406908102785 ,playtimes 526.0 ,effect: 7.805590666939693

stand
w:41.840594229524996  $d:0.0  $l:58.15940577047501
5473 : earn Money: -163.18811540950003 ,playtimes 1.0 ,effect: -163.18811540950003

分牌胜率高一些些,收益也多,分

---

77 vs 6

split
w:47.8298801642281  $d:7.721552165309465  $l:44.44856767046243
301573 : earn Money: 7115.306965434069 ,playtimes 526.0 ,effect: 13.527199554057166

stand
w:42.28416043620766  $d:0.0  $l:57.71583956379235
3109 : earn Money: -154.31679127584687 ,playtimes 1.0 ,effect: -154.31679127584687


分牌胜率高一些些,收益也多,分

---


88 vs 2

stand
w:35.35037055569618  $d:0.0  $l:64.64962944430383
26689 : earn Money: -292.9925888860764 ,playtimes 1.0 ,effect: -292.9925888860764

split
w:45.331923663099275  $d:8.09237524955381  $l:46.575701087346914
2588833 : earn Money: 1268.1501735930738 ,playtimes 448.0 ,effect: 2.830692351770254


胜率没有超过败率,选择停牌,不分

--

88 vs 3

split
w:47.110054671389726  $d:7.455953886120483  $l:45.4339914424898
1135369 : earn Money: 3799.2017338676146 ,playtimes 376.0 ,effect: 10.104259930498975


stand
w:37.419409717495114  $d:0.0  $l:62.580590282504886
15553 : earn Money: -251.6118056500976 ,playtimes 1.0 ,effect: -251.6118056500976


分

----

88 vs 7


split
w:48.79942192475807  $d:11.616429965676184  $l:39.58414810956576
1546405 : earn Money: 9062.290816778634 ,playtimes 2584.0 ,effect: 3.5070784894654157


stand
w:26.193567586820915  $d:0.0  $l:73.8064324131791
1921 : earn Money: -476.1286482635817 ,playtimes 1.0 ,effect: -476.1286482635817

分

----

99 vs 2

split
w:49.631680403335864  $d:7.817669755703246  $l:42.55064984096089
1948297 : earn Money: 6824.833568587813 ,playtimes 298.0 ,effect: 22.90212606908662

stand
w:49.31601058520999  $d:13.438862674532222  $l:37.24512674025778
26689 : earn Money: 120.70883844952209 ,playtimes 1.0 ,effect: 120.70883844952209

---

99 vs 6 

split
w:56.352396833663896  $d:6.502878862802364  $l:37.144724303533735 152341 : earn Money: 16678.315633039045 ,playtimes 226.0 ,effect: 73.79785678335861

stand
w:58.85482152551146  $d:10.61940442406256  $l:30.525774050425987 3109 : earn Money: 283.2904747508546 ,playtimes 1.0 ,effect: 283.2904747508546


---

99 vs 7

split
w:52.986232963261536  $d:9.89522208948275  $l:37.118544947255714
1523353 : earn Money: 13679.549350356023 ,playtimes 2458.0 ,effect: 5.565317066865754

stand
w:63.11437111287399  $d:13.793092270091048  $l:23.092536617034966
1921 : earn Money: 400.2183449583904 ,playtimes 1.0 ,effect: 400.2183449583904

虽然split输掉的概率提高了14%,但收益的上升却是非常大的,值得冒险.

分

---

99 vs 8

split
w:49.44766986495144  $d:10.469944696421635  $l:40.082385438626915
914329 : earn Money: 8160.073233593286 ,playtimes 2458.0 ,effect: 3.319801966474079

stand
w:37.26328900905531  $d:35.99549138645802  $l:26.741219604486684
1153 : earn Money: 105.22069404568651 ,playtimes 1.0 ,effect: 105.22069404568651

两种方案的胜率-败率都是10%.
分牌后输掉的概率提高了13,但收益的提升可以弥补损失吗?这个是否值得?
分派后有5张牌ATJQK直接帮助你,1张牌2可以让Double,一共6张好牌;1张9就买中保险,不亏钱,出1张8直接17,剩下34567需要再要牌.

整体来说,分.



-----
A6 vs 5

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Five5, 	playerStartValue=6	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:41.84059422952501->51.104223151119946  	$d:12.18434584844274->7.2930804108765654  	$l:45.97505992203225->41.60269643800349
improve value x$w(high is good):9.263628921594936  	x$d:-4.891265437566175  	 x$l(negative is good):-4.37236348402876
$w-$l: -4.134465692507239 -> 9.501526713116448  _ !Double!	 lift : 13.635992405623687 : good	 :) hit

double

---

A6 vs 6

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Six6, 	playerStartValue=6	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:42.28416043620767->52.262876822540264  	$d:16.57066108930379->8.28273659205428  	$l:41.14517847448853->39.45438658540547
improve value x$w(high is good):9.978716386332593  	x$d:-8.287924497249511  	 x$l(negative is good):-1.6907918890830587
$w-$l: 1.1389819617191432 -> 12.808490237134789  _ !Double!	 lift : 11.669508275415646 : good	 :) hit


double

---
A6 vs 7

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=6	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:26.193567586820908->42.535081231322465  	$d:36.92080352605307->14.24470690168396  	$l:36.88562888712602->43.22021186699358
improve value x$w(high is good):16.341513644501557  	x$d:-22.67609662436911  	 x$l(negative is good):6.334582979867562
$w-$l: -10.692061300305106 -> -0.6851306356711162  _  _ 	 lift : 10.00693066463399 : good	 :) hit

整体效果
org->adv	$w:26.193567586820894->44.24371721789503  	$d:36.920803526053085->16.767599404484383  	$l:36.88562888712602->38.98868337762059
improve value x$w(high is good):18.050149631074138  	x$d:-20.153204121568702  	 x$l(negative is good):2.1030544904945714
$w-$l: -10.692061300305127 -> 5.255033840274442  _  _ 	 lift : 15.94709514057957 : good	 :) hit

hit

---
A6 vs 8

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=6	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:24.369289795036515->39.209940831235805  	$d:12.893999214018798->8.73390160303877  	$l:62.73671099094469->52.05615756572543
improve value x$w(high is good):14.84065103619929  	x$d:-4.160097610980028  	 x$l(negative is good):-10.680553425219259
$w-$l: -38.36742119590817 -> -12.846216734489618  _  _ 	 lift : 25.521204461418556 : good	 :) hit

整体效果
org->adv	$w:24.369289795036504->40.60498827885871  	$d:12.89399921401881->11.326300972703693  	$l:62.73671099094468->48.068710748437596
improve value x$w(high is good):16.23569848382221  	x$d:-1.5676982413151173  	 x$l(negative is good):-14.668000242507084
$w-$l: -38.36742119590817 -> -7.463722469578881  _  _ 	 lift : 30.90369872632929 : good	 :) hit

hit

---
A7 vs 6

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Six6, 	playerStartValue=7	[isDouble()=true, isHit()=false, isSurrender()=false]
org->adv	$w:58.85482152551147->56.07729035159126  	$d:10.619404424062568->6.900432723349183  	$l:30.525774050425973->37.02227692505956
improve value x$w(high is good):-2.7775311739202095  	x$d:-3.718971700713385  	 x$l(negative is good):6.496502874633585
$w-$l: 28.329047475085495 -> 19.055013426531698  _ !Double!	 lift : -9.274034048553798 : bad	 :| stand

stand
w:58.85482152551147  $d:10.619404424062568  $l:30.525774050425962 3109 : now Money: 283.2904747508551 ,effect: 0.09111948367669832

hit
w:56.07729035159126  $d:6.900432723349183  $l:37.02227692505956 40417 : Before Money: 190.55013426531715 ,effect: 0.004714603613957423

纯优势从28.3%->19%, 选停

---
A7 vs 7

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=7	[isDouble()=true, isHit()=false, isSurrender()=false]
org->adv	$w:63.11437111287399->51.065741752631276  	$d:13.793092270091048->8.89230393528956  	$l:23.09253661703497->40.04195431207916
improve value x$w(high is good):-12.048629360242714  	x$d:-4.900788334801488  	 x$l(negative is good):16.949417695044193
$w-$l: 40.02183449583902 -> 11.023787440552113  _ !Double!	 lift : -28.998047055286907 : bad	 :| stand

stand
w:63.11437111287398  $d:13.793092270091051  $l:23.092536617034973 1921 : now Money: 400.21834495839016 ,effect: 0.2083385450069704

hit
w:52.81169872942739  $d:11.427481441010428  $l:35.76081982956217 739585 : Before Money: 170.50878899865097 ,effect: 2.30546575442513E-4


选停

---
A7 vs 8

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=7	[isDouble()=false, isHit()=false, isSurrender()=false]
org->adv	$w:37.26328900905532->42.08856164421289  	$d:35.99549138645802->14.174000348271104  	$l:26.74121960448667->43.73743800751602
improve value x$w(high is good):4.825272635157567  	x$d:-21.821491038186917  	 x$l(negative is good):16.99621840302935
$w-$l: 10.522069404568645 -> -1.6488763633031311  _  _ 	 lift : -12.170945767871777 : bad	 :| stand

stand
w:37.26328900905532  $d:35.99549138645802  $l:26.741219604486666 1153 : now Money: 105.22069404568651 ,effect: 0.09125819084621553

hit
w:43.518828704890915  $d:16.774339656271493  $l:39.70683163883759 443905 : Before Money: 38.119970660532196 ,effect: 8.587416375245199E-5

纯优势从10.52%->3.81% 
不划算,选停

---
A7 vs 9

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=7	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:34.95517480992236->38.47300575853028  	$d:11.734847635517633->8.579171177762367  	$l:53.30997755456001->52.947823063707354
improve value x$w(high is good):3.517830948607916  	x$d:-3.1556764577552663  	 x$l(negative is good):-0.36215449085265305
$w-$l: -18.354802744637645 -> -14.47481730517708  _  _ 	 lift : 3.879985439460565 : good	 :) hit

stand
w:34.955174809922376  $d:11.734847635517626  $l:53.30997755455999 769 : now Money: -183.54802744637618 ,effect: -0.2386840408925568

hit
w:39.298527525972425  $d:11.22803361566019  $l:49.47343885836739 296065 : Before Money: -101.74911332395007 ,effect: -3.4367153606116923E-4

有提升,要

---
A7 vs T

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=7	[isDouble()=false, isHit()=false, isSurrender()=false]
org->adv	$w:32.43849443867281->34.19928574464488  	$d:11.166875604703378->8.65448496182615  	$l:56.39462995662381->57.146229293528975
improve value x$w(high is good):1.7607913059720701  	x$d:-2.5123906428772287  	 x$l(negative is good):0.7515993369051657
$w-$l: -23.956135517951 -> -22.946943548884093  _  _ 	 lift : 1.0091919690669082 : good	 :| stand

stand
w:32.43849443867282  $d:11.166875604703383  $l:56.394629956623795 385 : now Money: -239.56135517950986 ,effect: -0.6222372861805451

hit
w:34.592224157241446  $d:10.72770911732027  $l:54.68006672543828 74305 : Before Money: -200.87842568196845 ,effect: -0.0027034308011838833

有提升,要

---
A7 vs A

hit one more
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=One1, 	playerStartValue=7	[isDouble()=false, isHit()=false, isSurrender()=false]
org->adv	$w:24.548959667640755->24.583248200504176  	$d:13.082155614562557->9.844260294138504  	$l:62.36888471779668->65.57249150535732
improve value x$w(high is good):0.03428853286342104  	x$d:-3.2378953204240535  	 x$l(negative is good):3.2036067875606378
$w-$l: -37.81992505015592 -> -40.98924330485315  _  _ 	 lift : -3.169318254697223 : bad	 :| stand


stand
w:24.548959667640812  $d:13.082155614562504  $l:62.36888471779668 14209 : now Money: -378.1992505015587 ,effect: -0.026616880181684757

hit
w:26.613468588460698  $d:12.883878625533212  $l:60.50265278600608 5470465 : Before Money: -338.89184197545376 ,effect: -6.194936663984758E-5

有提升,要

-----------------

2022.01.16

1.RivalAnalyzeUtil 是一切的起点,通过这个类,比较再来一张牌和不要的胜率区别。
2.关于胜率的计算，一个使用出现概率来计算，一个是通过出现组合来计算，差别非常大：因为有些组合会非常多，但概率小。
具体Dealer牌产生的差距在 AnalyzeCardsPathValue.java 里面有展示。
最后我还是决定用概率的形式来进行分析和计算。
3.我提高了double的要求，必须胜率在比庄家高10%以上才double.
4.我降低了投降的要求，当胜率比庄家低45%的时候就投降，这样17vsT也会投降了。
5.发现就算庄家是6也有57%的胜率。
6.strategy包是测试特定方案的包,可以测试指定的打法对结果的影响,可以创建两个有稍微差异的来比较结果。
7.strategy8102包是用遗传算法算方案的包，分固定方法 和 可变进化方法，配置变异率以后跑自己的结果。

01.17 01:05
现实中面临的是有限的几次机会，怎样才能得到更好的结果。
怎么定义更好的结果：
1.赢的概率高，就是说在不同的打法中，选赢得概率高的打法，有些打法需要hit后再根据结果决定是否hit,这样分散了选择，让结果更多，但更多的结果带来的是降低了胜率，那就选择少但胜率高的方案。
2.输的钱少，这样，在庄家比我们优势高45%以上的时候，放弃1%~5%的机会，把一半钱拿回来，选择giveup，是否能达到目的，这种结果是17vsT的时候，选择投降。
3.有大机会时再double，否则稳定一些，赢了就好。这样造成9vs everything都不double了。


Double:
9 vs 5,6
T vs 2~8
11 vs 2~9
A6 vs 6

投降：
14 vs T
15 vs 9,T
16 vs 8,9,T
17 vs T

Hit
12 vs 2
16 vs 7,8,9
A7 vs 9
vs T , A ???



------- 

2019 April 22 

通过穷举,计算blackjack的所有最优解.
算了很久,找到了最优解.
然而,胜率依然是庄家占优,赌徒就是输钱的料,计算加上算牌,但现在是6副+蜗牛机,优势不大.

最终结果是Myth2019April22.java
