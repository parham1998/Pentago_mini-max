# Pentago_mini-max (warm-up project!)
Implementation of the Pentago game using mini-max algorithm and alpha-beta pruning with JavaFX

The game Pentago is played on a 6x6 board, which is divided into four 3x3 sub-boards. <br />
You play first, and your move consists of placing a marble of black color onto an empty field on the board and turning one of the sub-boards by 90 degrees. The computer plays after your move and tries to find the best move at each step! <br />
The game finishes, when you or the computer puts five marble in a row at first. five in a row can occur vertical, horizontal or diagonal, also before the sub-board rotation takes place. <br />
If neither you nor the computer achieves five in a row, the game ends after the 36th move with a draw. 

### mini-max algorithm and alpha-beta pruning
mini-max algorithm tries to find the best move in every step by evaluates all the available moves.

alpha-Beta pruning is not actually a new algorithm, rather an optimization technique for minimax algorithm. <br />
It reduces the computation time by a huge factor. This allows us to search much faster and even go into deeper levels in the game tree. <br />
It cuts off branches in the game tree which need not be searched because there already exists a better move available. <br />
It is called Alpha-Beta pruning because it passes 2 extra parameters in the minimax function, namely alpha and beta.

Alpha is the best value that the maximizer currently can guarantee at that level or above. <br />
Beta is the best value that the minimizer currently can guarantee at that level or above.
    
### implementation details
Game-tree complexity: The most meaning full parameters to estimate the game-tree size are the number of moves until a game finishes, called game depth, and the number of possible moves per state. for the game Pentago, there are 36 possible places at first, then reduced by 1 at each step. there are also 8 possible rotating at each step which makes the game complexity very much! (worst case: (36 * 8) * (35 * 8) * (34 * 8) * ... * (1 * 8) = 36! * 8^36) <br />
To solve a game with minimax search algorithm, the whole game-tree has to be evaluated. This resultsin a complexity of Θ(moves ^ depth). But alpha-beta Search can reduce the exponent by half if perfect move ordering is given: Θ(moves ^ depth/2) <br />
Even with random move ordering the complexity shrinks to Θ(moves ^ (3/4 * depth)). 

Actually, I used random move ordering in this project. I considered one of the empty places at the center of sub-boards for the computer's first two moves, for the next 10 moves, I reduced the depth of the tree to 4, and then I set the depth to 5 until the end.

### the following animation shows the performance of the mini-max algorithm in the Pentago game: (animation speed has been doubled)
![pentago](https://user-images.githubusercontent.com/85555218/123473179-732a4100-d60d-11eb-885a-aed27e214637.gif)
