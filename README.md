# CentipedeArmyRepo

Hi there,

Instructions for running the thing:

Best Case:
- You double click the runnable CentipedeChess.Jar and bing bang boom the magic happens

More likely case:
- You're forced to download eclipse (should be the hottest version (Oxygen)), 
- make an empty project called Centipede Chess, 
- replace the src and bin from your empty project with our repo src and bin
- Possibly add JUnit 5 to your build path (doesnt this sound fun) (we've got 28.6% code coverage though so be proud :') )
- Run it in eclipse

So in short hopefully the runnable jar works


- There should be no game breaking bugs (but im sure you'll surprise us)
- All features should work as intended
- Didnt have time to implement "Checkmate" so the game ends when you kill the king (lets call it hardmode because nothing is holding your  hand and making sure you move your king out of danger)
- Easy AI is 100% Random
- Hard AI is Minimax

Oh also the timers run off of update rate (60TPS in a game of chess lets go boi) so lets hope you didnt download our .jar onto a toaster, otherwise you'll wonder why 1 second is actually 5 seconds.
