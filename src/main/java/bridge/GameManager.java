package bridge;

public class GameManager {
    final InputView inputView;
    final OutputView outputView;

    GameManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void showGameTitle() {
        outputView.printGameTitle();
    }

    public BridgeGame buildBridgeGame(BridgeMaker bridgeMaker) {
        outputView.printInputBridgeSize();
        int size = inputView.readBridgeSize();

        return new BridgeGame(bridgeMaker.makeBridge(size));
    }
    public void playGame(BridgeGame bridgeGame) {
        do {
            while (!bridgeGame.roundOver()) {
                outputView.printAskingMove();
                String nextMove = inputView.readMoving();
                System.out.println(nextMove);

                bridgeGame.move(nextMove);
                outputView.printMap(bridgeGame.getMapLines());
            }
        }while (askRetry(bridgeGame));
    }


}
