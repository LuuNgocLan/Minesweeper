# Minesweeper
Learning code game in android
- Reference:https://www.thepolyglotdeveloper.com/2015/05/create-a-minesweeper-game-with-native-android/
1. Prepare: 
- Sheet about game
- Gameplay(casual game, clone idea,...)
2. Struct for our project 
- Sprite.java: this class containt three main thing
  * Split the sprite sheet into a grid of rows and columns representing one sprite each.
  * Drawing one sprite to the canvas at a time
  * Detecting if there is a collision between a point and the bounds of the sprite
- HUD.java: this mean Head-up Display of game( I call MENU), this class is inherrited from Sprite class, the sheet will be separated 1 col and 4 rows
- Cell.java: this class inherits the Sprite class, this is cell object in board game, each cell can be bomb, cheat or 0 to 8(the bomb around this cell)
- Board.java: board in game containt dimension array of Cell, this class will shuffleBombs, calculateCellNeighbors, draw cell,...
- Game.java:  It is responsible for our buttons that start new games, cheat, and validate. It also registers touch events, and determines if we’ve gotten game over or succeeded in the game.
- GameLoopThread.java:  We’ll be handling all game rendering and logic via a GameLoopThread class to avoid freezing and crashes. Thí class thread will get the canvas, and pass it to the draw() function of our GameView class in which case each sprite will go off and do it's own drawing logic still under the looping thread.
- GameView.java: It is responsible for everything that has to do with the SurfaceView which is a driver for the 2D Canvas. It is where we gegister touch events, construct our game and bord, and determine what will be draw to the screen during the lifetime of the game.
- GameActivity.java: is where we start when the android application is openned

3. Run game =)
