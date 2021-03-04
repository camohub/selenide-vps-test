pom.xml
==================
- Profily <profiles></profiles>, ktoré sú prepojené 
    na anotácie @Category (fastTestCategory, fullTestcategory) 
    K tomu je nutné definovať premennú <parameters><category /><parameters/>
  

TestWatcher
=================
- Trieda TestWatcher - je rozhranie, ktoré ponúka JUnit pre zachytávanie 
  eventov ako je napr. fail. Tu sa používa na vytvorenie screenshotu 
  keď test padne.


Driver
=================
- Driver sa musí zatvoriť v triede TestWatcher::finish(), pretože
  @After metoda sa zavolá pred TestWatcher::finish() 
  a zavrie driver pred vytvorením screenshotu.  

Jenkins
=================
- Oprávnenia - parent dir projektu musí mať chmod 777 kôli mazaniu v target adresári.
- Viac v /README.md servera