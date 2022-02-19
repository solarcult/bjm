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

---

16 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:24.369289795036515->24.31551805109735  	$d:0.0->5.8552807900616894  	$l:75.63071020496348->69.82920115884096
improve value x$w(high is good):-0.05377174393916562  	x$d:5.8552807900616894  	 x$l(negative is good):-5.8015090461225185
$w-$l: -51.26142040992696 -> -45.51368310774361  _ #Surrender#	 lift : 5.747737302183353 : good	 :) hit

如果不要牌,(庄家的胜率-我们的胜率)达到了51.2614%,超过了50%,就意味着我们投降是划算的.优先投降. [不对,这样对胜率不利,不应该投降,应该要牌]

16对8,要一张后,胜率和败率都下降了,其实都转化到了平率上. 自己的败率下降的更快,也就是说庄家的胜率下降的更大,值了.

---

16 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:22.92418933219526->21.70506674433606  	$d:0.0->5.967159535571979  	$l:77.07581066780475->72.32777372009195
improve value x$w(high is good):-1.2191225878592  	x$d:5.967159535571979  	 x$l(negative is good):-4.748036947712791
$w-$l: -54.15162133560949 -> -50.62270697575588  _ #Surrender#	 lift : 3.5289143598536077 : good	 :) hit

不要牌就投降.
要牌我们的胜率下降1.2点,庄家胜率下降4.748,值得换.换来的还是去了平率.但就算要牌,(庄家的胜率-我们的胜率) 还是达到了50%,对我们非常不利.

---

16 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=16	[isDouble()=false, isHit()=false, isSurrender()=true]
org->adv	$w:21.24709353187227->18.649703938729186  	$d:0.0->6.096999210435696  	$l:78.75290646812773->75.25329685083511
improve value x$w(high is good):-2.5973895931430846  	x$d:6.096999210435696  	 x$l(negative is good):-3.49960961729262
$w-$l: -57.50581293625546 -> -56.603592912105924  _ #Surrender#	 lift : 0.902220024149536 : good	 :| stand

优先投降.
要牌转化率也不好,一般来说偷鸡就好了.所以建议不投降也不要要牌.

---

16 vs A
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=One1, 	playerStartValue=16	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:11.5472965879632->14.57027312064755  	$d:0.0->6.847951231899621  	$l:88.4527034120368->78.58177564745283
improve value x$w(high is good):3.0229765326843516  	x$d:6.847951231899621  	 x$l(negative is good):-9.870927764583968
$w-$l: -76.90540682407361 -> -64.01150252680527  _ #Surrender#	 lift : 12.893904297268332 : good	 :) hit

看数据就是再要一张,败率都转化到胜率和平率上了.挺好. 如果在最后位,此时要不要都不会改变什么,因为来个6你爆了,庄家也会成17点.

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

---


15 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:24.369289795036515->25.924330495953175  	$d:0.0->5.832952119279137  	$l:75.63071020496348->68.24271738476769
improve value x$w(high is good):1.5550407009166598  	x$d:5.832952119279137  	 x$l(negative is good):-7.387992820195791
$w-$l: -51.26142040992696 -> -42.318386888814516  _  _ 	 lift : 8.943033521112442 : good	 :) hit

6张牌不会爆,要就完事了,提升了8.94%.

---

15 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:22.92418933219526->23.215728359977987  	$d:0.0->5.928331021767451  	$l:77.07581066780475->70.85594061825455
improve value x$w(high is good):0.29153902778272567  	x$d:5.928331021767451  	 x$l(negative is good):-6.219870049550195
$w-$l: -54.15162133560949 -> -47.64021225827657  _ #Surrender#	 lift : 6.511409077332919 : good	 :) hit


要了还是有47.64%的劣势,索性优先投降,投不了就要一张. [不对,这样对胜率不利,不应该投降,应该要牌]

---

15 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=15	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:21.24709353187227->20.117866564903235  	$d:0.0->5.987317307555999  	$l:78.75290646812773->73.89481612754078
improve value x$w(high is good):-1.1292269669690356  	x$d:5.987317307555999  	 x$l(negative is good):-4.858090340586955
$w-$l: -57.50581293625546 -> -53.77694956263754  _ #Surrender#	 lift : 3.728863373617919 : good	 :) hit

要牌还是有53%的劣势,优先投降.降不了就要.

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


---

14 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=14	[isDouble()=false, isHit()=true, isSurrender()=true]
org->adv	$w:21.24709353187227->21.83493618095885  	$d:0.0->6.060977031065685  	$l:78.75290646812773->72.10408678797546
improve value x$w(high is good):0.5878426490865785  	x$d:6.060977031065685  	 x$l(negative is good):-6.648819680152272
$w-$l: -57.50581293625546 -> -50.26915060701662  _ #Surrender#	 lift : 7.2366623292388415 : good	 :) hit

对10要牌还是差50.269%,弃牌最优.


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

---

12 vs 2
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Two2, 	playerStartValue=12	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:35.350370555696244->34.65229083815197  	$d:0.0->4.966934947447152  	$l:64.64962944430376->60.38077421440088
improve value x$w(high is good):-0.6980797175442746  	x$d:4.966934947447152  	 x$l(negative is good):-4.268855229902876
$w-$l: -29.299258888607515 -> -25.72848337624891  _  _ 	 lift : 3.570775512358604 : good	 :) hit

要一张,敌人损失的胜率是自己的6倍,都转移到平率去了,值得要一张.

---

12 vs 3
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Three3, 	playerStartValue=12	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:37.419409717495085->35.73171382373884  	$d:0.0->4.80787540749085  	$l:62.5805902825049->59.46041076877031
improve value x$w(high is good):-1.687695893756242  	x$d:4.80787540749085  	 x$l(negative is good):-3.120179513734591
$w-$l: -25.16118056500981 -> -23.72869694503147  _  _ 	 lift : 1.432483619978342 : good	 :) hit

很难抉择的一种场景,相比自己,敌人只损失了1.5倍左右的胜率,这时最好看表,奇数要牌,偶数不要牌.

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


---

11 vs 7

hit
w:59.73569251953793  $d:9.83084026572613  $l:30.433467214735938 739585 : now Money: 293.02225304801976

double
w:58.08188882005674  $d:7.309377932766352  $l:34.608733247176914 24973 : now Money: 469.46311145759626

多花一倍的钱,效率在60%

---

11 vs 8

double:
w:55.20387651665247  $d:7.427187474830083  $l:37.368936008517444 14989 : now Money: 356.69881016270085

hit:
w:56.5490368696232  $d:10.009720813174212  $l:33.44124231720257 443905 : now Money: 231.07794552420637


一倍的钱,带来了54%的效率

---

11 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=11	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:22.92418933219526->52.20412380480073  	$d:0.0->7.34322669473891  	$l:77.07581066780475->40.45264950046036
improve value x$w(high is good):29.27993447260547  	x$d:7.34322669473891  	 x$l(negative is good):-36.623161167344385
$w-$l: -54.15162133560949 -> 11.751474304340364  _ !Double!	 lift : 65.90309563994985 : good	 :) hit

胜率超过10%,double不眨眼.

double
w:52.24293343537405  $d:7.342271411376943  $l:40.41479515324901 9997 : now Money: 236.56276564250066
9997 : earn Money: 236.56276564250066 ,playtimes 26.0 ,effect: 9.098567909326949


hit:
w:52.99561229328905  $d:9.968779125045467  $l:37.035608581665485 296065 : now Money: 159.60003711623543
296065 : earn Money: 159.60003711623543 ,playtimes 385.0 ,effect: 0.41454555095126083

double 多花了一倍的钱,收益只多了48.5%,好像不划算啊.

---

11 vs T
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Ten, 	playerStartValue=11	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:21.24709353187227->47.32600560001775  	$d:0.0->8.661983872532373  	$l:78.75290646812773->44.01201052744988
improve value x$w(high is good):26.07891206814548  	x$d:8.661983872532373  	 x$l(negative is good):-34.74089594067785
$w-$l: -57.50581293625546 -> 3.313995072567871  _  _ 	 lift : 60.81980800882334 : good	 :) hit

再要一张的优势只剩3.31%,只能要一张,不能double了.

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


---

10 vs 6

double
w:61.10339389825439  $d:6.826925135263911  $l:32.06968096648169 40417 : now Money: 580.6742586354543

hit
w:61.10339389825439  $d:6.826925135263911  $l:32.06968096648169 40417 : now Money: 290.33712931772715

花费一倍的钱,得到一倍的收益.值.

---

10 vs 7

hit:
w:57.924057517641046  $d:10.04933800182038  $l:32.02660448053856 739585 : now Money: 258.97453037102485

double:
w:56.254445758131766  $d:7.541489442300127  $l:36.2040647995681 24973 : now Money: 401.0076191712729

花费一倍的钱,收益多了54%,有点不划算.

----

10 vs 8
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Eight8, 	playerStartValue=10	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:24.369289795036515->53.55461867445699  	$d:0.0->7.346830598062096  	$l:75.63071020496348->39.09855072748092
improve value x$w(high is good):29.185328879420474  	x$d:7.346830598062096  	 x$l(negative is good):-36.53215947748256
$w-$l: -51.26142040992696 -> 14.45606794697607  _ !Double!	 lift : 65.71748835690303 : good	 :) hit

看数据优势有14.5%,超过阈值10%,可以double.

hit:
w:54.965481497565584  $d:10.02118112364807  $l:35.01333737878635 443905 : now Money: 199.52144118779262

double:
w:53.59621222030865  $d:7.462945086405506  $l:38.94084269328584 14989 : now Money: 293.1073905404568


double 多花了一倍的钱,收益只多了47%,好像不划算啊.

---

10 vs 9
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Nine9, 	playerStartValue=10	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:22.92418933219526->49.408470810874675  	$d:0.0->8.724958182286697  	$l:77.07581066780475->41.86657100683864
improve value x$w(high is good):26.484281478679414  	x$d:8.724958182286697  	 x$l(negative is good):-35.209239660966105
$w-$l: -54.15162133560949 -> 7.541899804036034  _  _ 	 lift : 61.693521139645526 : good	 :) hit

优势只有7.54%,低于阈值10%,只hit不double.

---

10总结:
10 vs 2~8 在数据上都支持double.

---

9 vs 4 

DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Four4, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:39.58049180346554->51.386273610369706  	$d:0.0->6.628212972206414  	$l:60.41950819653445->41.98551341742389
improve value x$w(high is good):11.805781806904164  	x$d:6.628212972206414  	 x$l(negative is good):-18.433994779110563
$w-$l: -20.839016393068917 -> 9.400760192945818  _ !Double!	 lift : 30.239776586014735 : good	 :) hit

这里我想double,但小于10%的阈值,所以只hit
有次遇到了我9double后出现了一张2,当场停止傻眼,看着被庄家干掉,心里有了阴影.

不double时的胜率是: w:52.956549010656204  $d:7.166799157190358  $l:39.87665183215345 | 比较组合有226825种,收益 130.7989717850276
double后的胜率是:   w:51.38627361036967  $d:6.628212972206417  $l:41.98551341742391  | 比较组合有117949种,收益 188.01520385891519
绝对胜率差距有3%,成本提高一倍,收益提高44.6%,不划算呐.

---

9 vs 5
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Five5, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:41.84059422952501->53.15018188882523  	$d:0.0->6.3977420616042835  	$l:58.15940577047499->40.45207604957048
improve value x$w(high is good):11.30958765930022  	x$d:6.3977420616042835  	 x$l(negative is good):-17.70732972090451
$w-$l: -16.318811540949984 -> 12.698105839254753  _ !Double!	 lift : 29.016917380204738 : good	 :) hit

数据支持double,


9 vs 6
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Six6, 	playerStartValue=9	[isDouble()=true, isHit()=true, isSurrender()=false]
org->adv	$w:42.28416043620767->54.916220757349045  	$d:0.0->6.187173140905379  	$l:57.71583956379233->38.896606101745576
improve value x$w(high is good):12.632060321141374  	x$d:6.187173140905379  	 x$l(negative is good):-18.819233462046753
$w-$l: -15.431679127584651 -> 16.019614655603466  _ !Double!	 lift : 31.451293783188117 : good	 :) hit

数据支持double

---

9 vs 7
DealerVSPlayerChance [ 	deckStatus=0	dealerCard=Seven7, 	playerStartValue=9	[isDouble()=false, isHit()=true, isSurrender()=false]
org->adv	$w:26.193567586820908->49.29032247171355  	$d:0.0->6.9641232864182046  	$l:73.8064324131791->43.74555424186825
improve value x$w(high is good):23.096754884892643  	x$d:6.9641232864182046  	 x$l(negative is good):-30.060878171310847
$w-$l: -47.612864826358184 -> 5.544768229845304  _  _ 	 lift : 53.157633056203494 : good	 :) hit

优势没有超过10%,只hit

---

9总结:
只对5和6进行double.

---


以上这些基本操作会对后面的分牌造成决定性的影响,所以要把上面的结论确定下来.
数据通过TestOne计算出来和 Jan16Test2022改double / hit方案测试出来.

9 vs 56 double
10 vs 2~8 double
11 vs 2~9 double






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
