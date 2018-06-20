package battleshipagain;

/**
 *
 * @author PeterBoss
 */
public interface IGameControl {
    public int playSingleGame(IPlayer p1, IPlayer p2);
    public int[] playManyGames(IPlayer p1, IPlayer p2, int gameCount);
}
