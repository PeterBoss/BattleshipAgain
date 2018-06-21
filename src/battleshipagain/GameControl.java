package battleshipagain;

/**
 *
 * @author PeterBoss
 */
public interface GameControl {
    public int playSingleGame(BattleshipPlayer p1, BattleshipPlayer p2);
    public int[] playManyGames(BattleshipPlayer p1, BattleshipPlayer p2, int gameCount);
}
